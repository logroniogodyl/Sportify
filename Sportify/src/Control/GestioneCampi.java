package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.CampoDAO;

@WebServlet("/GestioneCampi")
public class GestioneCampi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CampoDAO campoDAO;
       
    public GestioneCampi() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		campoDAO = new CampoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//BISOGNA VERIFICARE CHE LA SESSION SIA ATTIVA E PRENDERE L'ID DALL'UTENTE CHE VIAGGIA IN SESSIONE
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/gestioneCampi.jsp");
		rd.forward(request, response);
	}

}
