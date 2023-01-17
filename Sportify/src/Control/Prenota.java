package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.AsdDAO;
import Data.CampoDAO;
import Data.Mail;
import Data.PrenotazioneDAO;
import Model.ASD;
import Model.Campo;
import Model.Prenotazione;

@WebServlet("/prenota")
public class Prenota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Prenota() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data = request.getParameter("date");
		String ora = request.getParameter("orario");
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String tel = request.getParameter("telefono");
		String tipo = request.getParameter("tipo");
		String idCampoPadre=request.getParameter("idCampo");
		int orario=Integer.parseInt(ora);
		int idCampo=Integer.parseInt(idCampoPadre);
		String codiceSoc = request.getParameter("codiceSoc");
		//String nomeprenotante = request.getParameter("nomePren");
		Campo campo=null;
		ASD societa=null;
		
		if(tipo.equals("Normale")) {
			System.out.println("sono nel normale");
			try {
				if(email==""||nome==""||tel=="")
				{
					request.setAttribute("errore", "errore");
				    response.getWriter().print("errore");
				    
				}
				else
				{
					campo = CampoDAO.selectCampiById(idCampo);
					societa= AsdDAO.selectASDByID(campo.getCodiceSoc());
			
	
					Prenotazione nuovaPrenotazione = new Prenotazione(data,orario,email,idCampo,tel,nome,tipo);
					nuovaPrenotazione.setTipologia("Normale");
					//DA INSERIRE IL NOME DI CHI HA PRENOTATO
					String oggetto= "Ciao "+nome+"!\n\n La tua prenotazione al campo " + campo.getNome()+ " di "+ societa.getNome() + " in " + societa.getIndirizzo() + " (" + societa.getProvincia()+") è avvenuta correttamente. \n\nTi aspettiamo in data "+ data + " alle " + orario+":00.\n\nPer info o disdetta contattare " + societa.getNome() + " al numero " + societa.getTelefono() + " o per email all'indirizzo " + societa.getEmail()+".\n\nGrazie di aver usato la nostra piattaforma!\nTEAM SPORTIFY"; //getcampofrom id cosi ho tutti i dati del campo
					
					PrenotazioneDAO.insertPrenotazione(nuovaPrenotazione);
				
					Mail.invioMail(email, "Prenotazione effettuata", oggetto );
				
				}

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
			
		else
		{
			try {
				if(tipo=="")
				{
					request.setAttribute("errore", "errore");
					response.getWriter().print("errore");
				}
				else
				{
					int idSocieta=Integer.parseInt(codiceSoc);
			
					Prenotazione nuovaPrenotazione = new Prenotazione(data,orario,email,idCampo,tel,idSocieta,tipo,nome);
			
					PrenotazioneDAO.insertPrenotazione(nuovaPrenotazione);
			
				}
				} catch (SQLException e) {
				e.printStackTrace();
				}
			}
		
		}	
	}