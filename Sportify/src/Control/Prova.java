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


@WebServlet("/Prova")
public class Prova extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Prova() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		System.out.println("Sei nella Servlet che risponde a /Prova");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nomeProva");
		String cognome = request.getParameter("cognomeProva");
		String telefono = request.getParameter("telefonoProva");
		String nomeASD = request.getParameter("nomeASDProva");
		String emailASD = request.getParameter("emailProva");
		
		String messaggio = "Ciao " + nomeASD + "!\n" + nome + " " + cognome + " avrebbe il piacere di fare una prova da voi.\nContattalo al numero " + telefono + "\n\nGrazie di aver usato la nostra piattaforma!\nTEAM SPORTIFY";
		Mail.invioMail(emailASD, " "+nome+" vuol provare con voi!", messaggio);
		
		request.setAttribute("nomeASDperProva", nomeASD);
		request.setAttribute("nomeperProva", nome);
		request.setAttribute("cognomeperProva", cognome);
		request.setAttribute("telefonoperProva", telefono);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/prova.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
