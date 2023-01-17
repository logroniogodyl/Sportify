package Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Data.CampoDAO;
import Model.Campo;

/**
 * Servlet implementation class DeleteCampo
 */
@WebServlet("/Delete")
public class CancellaCampo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CampoDAO campodao;   
    
    public CancellaCampo() {
        super();       
    }
    public void init() {
    	campodao=new CampoDAO();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stridSocieta = request.getParameter("id");
		int idSocieta = Integer.parseInt(stridSocieta);
		System.out.println(idSocieta);
		String strcodSocieta = request.getParameter("codSoc");
		int codSocieta = Integer.parseInt(strcodSocieta);
		System.out.println(codSocieta);
		
		String path = request.getContextPath();
		
		try {
			campodao.DELETE_CAMPO(idSocieta,codSocieta);
			response.sendRedirect(path + "/GestioneCampi");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}