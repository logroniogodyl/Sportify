package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Data.AsdDAO;
import Data.Mail;
import Model.ASD;


@WebServlet("/confermaReg")
public class ConfermaReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ConfermaReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		int codice= (int)session.getAttribute("codice");
		int codiceInserito = Integer.parseInt(request.getParameter("codiceInserito"));
		
		
		if(codiceInserito==codice)
		{
			ASD nuovoAsd = (ASD)session.getAttribute("Utentelog");
			session.setAttribute("Utente", nuovoAsd);
			session.removeAttribute("Utentelog");
			session.removeAttribute("codice");
			try {
				AsdDAO.insertAsd(nuovoAsd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String oggetto="Registazione a Sportify effettuata!";
			String messaggio= "Benvenuto, Adesso "+ nuovoAsd.getNome() + " è una società registrata nel mondo di Sportify";
			Mail.invioMail(nuovoAsd.getEmail(), oggetto, messaggio);
			
			
		}
		else
		{
			request.setAttribute("errore", "Errore Code");

		    response.getWriter().print("Errore Code");
		}
	
	}

}