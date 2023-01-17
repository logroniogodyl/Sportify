package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Data.AsdDAO;
import Model.ASD;


@WebServlet("/AggiornaProfilo")
public class AggiornaProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AsdDAO asdDAO;
       

    public AggiornaProfilo() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		asdDAO = new AsdDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Sono nella servlet\n");
		HttpSession session = request.getSession(true);
		ASD asdSessione = (ASD) session.getAttribute("Utente");
		int id = asdSessione.getIdsocieta();
		String passwordSessione = asdSessione.getPassword();
		String indirizzo = request.getParameter("indirizzoASD");
		String regione = request.getParameter("regione");
		String provincia = request.getParameter("provincia");
		String citta = request.getParameter("cittaASD");
		String telefono = request.getParameter("telefonoASD");
		String email = request.getParameter("emailASD");
		String pass = request.getParameter("passwordASD");
		String repass = request.getParameter("repasswordASD");
		String nome = request.getParameter("nomeASD");
		
		System.out.println("DATI: " + indirizzo + regione + provincia + citta + telefono + email + pass + repass + nome +"\nDATI SESSIONE: " + id + " & " + passwordSessione + "\n");
		
		ASD asdAggiornata = null;
		if (pass == "")
		{
			asdAggiornata = new ASD(id, citta, nome, indirizzo, provincia, regione, email, passwordSessione, telefono);
			System.out.println("Ho generato la seguente ASD: " + asdAggiornata.toString() + "\n");
			try {
				asdDAO.updateAsd(asdAggiornata);
				System.out.println("Sono nel try cercando di aggiornare la ASD" + nome + "tenendo la vecchia password (" + passwordSessione +")\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("Utente", asdAggiornata);
			System.out.println("Ho settato l'utente della sessione con i seguenti dati: " + session.getAttribute("Utente") + "\n");
			response.getWriter().write("success");
			String path = request.getContextPath();
			response.sendRedirect(path + "/Profilo");
		}
		else
		{
			if(pass.length()<8) {
				
				System.out.println("Sono nella password troppo corta");
				request.setAttribute("errore","Password corta");
			    response.getWriter().print("Password corta");
				
			}
			else
			{
				if(pass.equals(repass))
				{
					try {
						asdAggiornata = new ASD(id, citta, nome, indirizzo, provincia, regione, email, pass, telefono);
						System.out.println("Ho generato la seguente ASD: " + asdAggiornata);
						asdDAO.updateAsd(asdAggiornata);
						System.out.println("Sono nel try cercando di aggiornare la ASD " + nome + "cambiando la password in: " + pass + "\n");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					session.setAttribute("Utente", asdAggiornata);
					System.out.println("Ho settato l'utente della sessione con i seguenti dati: " + session.getAttribute("Utente") + "\n");
					response.getWriter().write("success");
					String path = request.getContextPath();
					response.sendRedirect(path + "/Profilo");
				}
				else
				{
				
				System.out.println("Sono nella password diversa");
				request.setAttribute("errore","Password diversa");
			    response.getWriter().print("Password diversa");
				
				}
			}
		}
	}

}
