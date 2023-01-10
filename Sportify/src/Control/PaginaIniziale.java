package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.AsdDAO;
import Model.ASD;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


@WebServlet("/Home")
public class PaginaIniziale extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AsdDAO asdDAO;
       
    public PaginaIniziale() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		asdDAO = new AsdDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		List<ASD> ASDlist = new ArrayList<>();
		List<ASD> ASDlistRandomicaPerHome = new ArrayList<>();
		ASDlist = asdDAO.selectAllAsd();
		if (ASDlist != null)
		{
			Random casuale = new Random();
			int casuale1 = casuale.nextInt(ASDlist.size());
			ASDlistRandomicaPerHome.add(ASDlist.get(casuale1));
			int casuale2;
			do
			{
				casuale2 = casuale.nextInt(ASDlist.size());
			} while (casuale2 == casuale1);
			int casuale3;
			do
			{
				casuale3 = casuale.nextInt(ASDlist.size());
			} while (casuale3 == casuale1 || casuale3 == casuale2);
			ASDlistRandomicaPerHome.add(ASDlist.get(casuale2));
			ASDlistRandomicaPerHome.add(ASDlist.get(casuale3));
			request.setAttribute("ASDlistRandomica", ASDlistRandomicaPerHome);
		}
		
		} catch (SQLException e)
		{
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
		rd.forward(request, response);
	}

}
