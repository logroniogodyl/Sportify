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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Data.AsdDAO;
import Model.ASD;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

@WebServlet("/RicercaASD")
public class RicercaASD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RicercaASD() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {			
			int checkVuoto=0;
			boolean vuoto=true;
			List<ASD> ASDlist = AsdDAO.selectAllAsd();
			request.setAttribute("AllASD", ASDlist);

			List<String> ASDregions = new ArrayList<>();
			ASDregions = AsdDAO.selectByRegione();
			Collections.sort(ASDregions);
			request.setAttribute("ASDregioni", ASDregions);

			List<String> ASDcities = new ArrayList<>();
			ASDcities = AsdDAO.selectByCitta();
			Collections.sort(ASDcities);
			request.setAttribute("ASDcitta", ASDcities);
			
			String filtro = request.getParameter("Filtro");

			if (filtro != null) {
				System.out.println("sono nel filtro servlet");
				Enumeration<String> params = request.getParameterNames();

				while (params.hasMoreElements()) {
					String paramName = params.nextElement();
					String paramValue = request.getParameter(paramName);
					System.out.println(paramName + ": " + paramValue);

					if (paramValue.equals("false")) { //se lazio è false
						// MI DEVE TORNARE LA LISTA DI ASD CON QUELLA REGIONE, PRENDO LA LISTA TOTALE E
						// PER OGNI ASD NELLA LISTA REGIONI LA RIMUOVO E POI BO TORNA LA RICHIESTA
						List<ASD> newASDList = new ArrayList<>();

						for (int i = 0; i < ASDlist.size(); i++) {
						  ASD asdTemp = ASDlist.get(i);
						  if (!asdTemp.getRegione().equals(paramName)) {
						    newASDList.add(asdTemp);
						  }
						}
						ASDlist = newASDList;
					}
					else
					{
						if(checkVuoto!=0)
						{
							vuoto=false;
						}
						checkVuoto++;
					}
						

				}
				
				
				if(vuoto==true)
				{
					ASDlist = AsdDAO.selectAllAsd();
					System.out.println("vuoto è true ed esco tutta la lista");
				}
				Gson gson = new Gson();
				String json = gson.toJson(ASDlist);
				response.getWriter().write(json);
				
				
			} 
			else 
				{
				RequestDispatcher rd = request.getRequestDispatcher("jsp/elencoASD.jsp");
				rd.forward(request, response);
				}
		} 
		catch (SQLException e) {}
		
	}

}
