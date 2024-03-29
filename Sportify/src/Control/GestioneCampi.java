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
		System.out.println(ListaCampiASD);
		request.setAttribute("MieiCampi", ListaCampiASD);
		
		//PRENDO LE TIPOLOGIE DI CAMPO DELL'ASD IN SESSIONE PER I FILTRI
		List<String> ListaTipologieCampi = new ArrayList<String>();
		try {
			ListaTipologieCampi = CampoDAO.selectTipologiaById(idsessione);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("MieTipologie", ListaTipologieCampi);
		
		//PRENDO LE TIPOLOGIE DI CAMPO POSSIBILE PER LE OPZIONI DELL'INSERT
		List<String> ListaTipologieDisponibili = new ArrayList<String>();
		try {
			ListaTipologieDisponibili = CampoDAO.selectTipologiaPerFiltro();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("AllTipologie", ListaTipologieDisponibili);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/gestioneCampi.jsp");
		rd.forward(request, response);
	}

}
