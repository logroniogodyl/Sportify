package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Data.AsdDAO;
import Data.Mail;
import Model.ASD;


@WebServlet("/registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Registrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("sono nel post di registrazione");
		HttpSession session = request.getSession(true);
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String password = request.getParameter("password");
		String telefono = request.getParameter("telefono");
		String regione = request.getParameter("regione");
		String provincia = request.getParameter("provincia");
		String citta = request.getParameter("citta");
		String indirizzo = request.getParameter("indirizzo");
		String repassword = request.getParameter("repassword");
		ASD ASDacc=AsdDAO.selectASDByEmail(email);
		ASD ASDnome=AsdDAO.selectASDBynome(nome);
		int codice = 0;
		
	if (email == "" || nome == "" || password == "" || telefono == "" || regione == "" || provincia == "" || citta == "" || indirizzo == "" || repassword == "") 
	{
		request.setAttribute("errore","campi vuoti");
		 
	    response.getWriter().print("campi vuoti");
	}
	else
	{

		if(ASDacc!=null) //se l'account esiste allora errore
	{
		
		request.setAttribute("errore","Errore Mail");

	    response.getWriter().print("Errore Mail");
	}
	else if(ASDnome!=null)//se il nome, preso dall'account, esiste errore
		{
		
		request.setAttribute("errore","Errore nome");
		 
	    response.getWriter().print("Errore nome");
	}
	else //se tutto va bene
	{
		Random random = new Random();
        codice = random.nextInt(8999) + 1000;
		
		
		ASD nuovoAsd = new ASD(citta, nome, indirizzo, provincia, regione, email, password, telefono);
		System.out.println(provincia);
		
		if(password.length()<8) {
			request.setAttribute("errore","Password corta");
			 
		    response.getWriter().print("Password corta");
			
		}
		else {
			if(password.equals(repassword))
		
		{
			
			
			session.setAttribute("Utentelog", nuovoAsd);
			session.setAttribute("codice", codice);
			
			String messaggio="Ciao " + nuovoAsd.getNome() + "!\nSiamo molto felici che tu abbia deciso di far parte di Sportify.\nEcco il tuo codice di verifica: " + codice;
			Mail.invioMail(nuovoAsd.getEmail(), "Codice di Verifica Sportify", messaggio);
			
		}
		else
		{
			
			request.setAttribute("errore","Password diversa");
			 
		    response.getWriter().print("Password diversa");
			
		}
		}
			
		
	}
		System.out.println("dati:"+ email + nome + password + " " + codice);
	}
		
		
	}

	}