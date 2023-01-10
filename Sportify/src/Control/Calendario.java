package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
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
import Model.Campo;
import Model.ASD;

@WebServlet("/Calendario")
public class Calendario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CampoDAO campoDAO;
       
    public Calendario() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		campoDAO = new CampoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BISOGNA PRENDERE L'ID DELLA SESSION
		try
		{
			HttpSession session = request.getSession();
			ASD asdsessione;
			asdsessione = (ASD) session.getAttribute("Utente");
			int idsessione = asdsessione.getIdsocieta();
			
			List<Campo> ListaCampiASD = new ArrayList<Campo>();
			ListaCampiASD = CampoDAO.selectAllCampiById(idsessione);
			request.setAttribute("MyCampi", ListaCampiASD);
			
			
			List<String> CampiPerTipologia = new ArrayList<String>();
			CampiPerTipologia = CampoDAO.selectTipologiaPerFiltro();
			Collections.sort(CampiPerTipologia);
			request.setAttribute("TypoCampi", CampiPerTipologia);
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("jsp/calendario.jsp");
		rd.forward(request, response);
	}

}
