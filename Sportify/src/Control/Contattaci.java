package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.Mail;


@WebServlet("/Contattaci")
public class Contattaci extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Contattaci() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Sei nella Servlet che risponde a /Contattaci");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("name");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("emailContatti");
		String telefono = request.getParameter("tel");
		String message = request.getParameter("message");
		String teamMail = "logroniogodyl@gmail.com";
		
		String messaggio = "Messaggio ricevuto da: " + nome + cognome + "\nIndirizzo email: " + email + "\nNumero di telefono: " + telefono + "\n\n" + message;
		Mail.invioMail(teamMail, " "+nome+" "+cognome+" vuole parlarci", messaggio);
		
		request.setAttribute("nomeContatto", nome);
		request.setAttribute("cognomeContatto", cognome);
		request.setAttribute("telefonocontattante", telefono);
		request.setAttribute("emailcontattante", email);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/contattaci.jsp");
		rd.forward(request, response);
	}

}
