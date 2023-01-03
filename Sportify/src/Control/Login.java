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

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass=request.getParameter("password");
		ASD ASDacc=AsdDAO.selectASDByEmail(email);
		HttpSession session = request.getSession(true);
		
		if(ASDacc!=null)
		{
			//se email presente
			System.out.println("email corretta");
			
			if(ASDacc.getPassword().equals(pass))
				{	
				System.out.println("password corretta");
				ASD asd= (ASD) session.getAttribute("Asd");
				System.out.println("Accesso eseguito");
				session.setAttribute("Utente", ASDacc);
				response.sendRedirect(request.getContextPath() + "/");
				}
			else
			{
				System.out.println("password sbagliata");
				response.sendRedirect(request.getContextPath());
			}
		}
		
		else 
		{ 
			System.out.println("email non presente");
			//deve apparire messaggio di errore
			response.sendRedirect(request.getContextPath());
				 
		}
			
		
		}
		
		
	}


