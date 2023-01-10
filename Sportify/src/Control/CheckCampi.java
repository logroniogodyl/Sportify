package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.CampoDAO;
import Model.Campo;


@WebServlet("/Prenota")
public class CheckCampi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CampoDAO campoDAO;
       
    public CheckCampi() {
        super();
    }
    
    public void init()
    {
    	campoDAO = new CampoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			List<Campo> CampiList = new ArrayList<Campo>();
			CampiList = CampoDAO.selectAllCampi();
			request.setAttribute("AllCampi", CampiList);
			
			List<String> CampiPerCitta = new ArrayList<String>();
			CampiPerCitta = CampoDAO.selectCittaPerFiltro();
			Collections.sort(CampiPerCitta);
			request.setAttribute("CampiPerCitta", CampiPerCitta);
			
			List<String> CampiPerASD = new ArrayList<String>();
			CampiPerASD = CampoDAO.selectASDPerFiltro();
			Collections.sort(CampiPerASD);
			request.setAttribute("CampiPerASD", CampiPerASD);
			
			List<String> CampiPerTipologia = new ArrayList<String>();
			CampiPerTipologia = CampoDAO.selectTipologiaPerFiltro();
			Collections.sort(CampiPerTipologia);
			request.setAttribute("TypoCampi", CampiPerTipologia);
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/prenotaCampi.jsp");
        rd.forward(request, response);
	}

}
