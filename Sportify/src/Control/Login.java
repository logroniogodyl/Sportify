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

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass=request.getParameter("password");
		ASD ASDacc=AsdDAO.selectASDByEmail(email);
		HttpSession session = request.getSession(true);
		
		boolean errore=false;
		if(ASDacc!=null) 
		{
			//se email non presente
			System.out.println("email corretta");
			
			if(ASDacc.getPassword().equals(pass))
				{	
				System.out.println("password corretta");
				System.out.println("Accesso eseguito");
				session.setAttribute("Utente", ASDacc);
				response.sendRedirect(request.getContextPath() + "/");				
				}
			else
			{
				System.out.println("password sbagliata");
				
				errore=true;
				
			}
		}
		
		else 
		{ 
			System.out.println("email non presente");
			errore=true;
			
			
				 
		}
		
	    request.setAttribute("errore", errore);

	    
	    response.getWriter().print(errore);
		 
		
		}
		
		
	}


