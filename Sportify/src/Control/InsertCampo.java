package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Data.CampoDAO;
import Model.ASD;
import Model.Campo;

/**
 * Servlet implementation class InsertCampo
 */
@WebServlet("/Insert")
public class InsertCampo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CampoDAO campoDAO;    
  
    public InsertCampo() {
        super();
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		campoDAO = new CampoDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("NomeCampo");
		
		System.out.println(nome);
		String strPrezzo = request.getParameter("PrezzoCampo");
		int prezzo = Integer.parseInt(strPrezzo);
		System.out.println(prezzo);
		String tipologia = request.getParameter("Tipologia");
		System.out.println(tipologia);
		
		String strcodSocieta = request.getParameter("IdSocieta");
		int codSocieta = Integer.parseInt(strcodSocieta);
		System.out.println(codSocieta);
		
		Campo campo1= new Campo(codSocieta,prezzo,tipologia,nome);
		
		try {
			System.out.println("campo inserito correttamente");
			campoDAO.INSERT_CAMPO(campo1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		ASD asdsessione;
		asdsessione = (ASD) session.getAttribute("Utente");
		int idsessione = asdsessione.getIdsocieta();
		
		//BISOGNA VERIFICARE CHE LA SESSION SIA ATTIVA E PRENDERE L'ID DALL'UTENTE CHE VIAGGIA IN SESSIONE
		List<Campo> ListaCampiASD = new ArrayList<Campo>();
		try {
			ListaCampiASD = CampoDAO.selectAllCampiById(idsessione);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("MieiCampi", ListaCampiASD);
		
		String path = request.getContextPath();
		response.sendRedirect(path + "/GestioneCampi");
		
	}

}
