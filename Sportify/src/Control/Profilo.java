package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Data.AsdDAO;
import Model.ASD;

@WebServlet("/Profilo")
public class Profilo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AsdDAO asdDAO;
       
    public Profilo() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		asdDAO = new AsdDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/profilo.jsp");
		rd.forward(request, response);
	}

}