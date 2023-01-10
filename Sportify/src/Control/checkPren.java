package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Data.PrenotazioneDAO;
import Model.ASD;
import Model.Prenotazione;


@WebServlet("/checkPren")
public class checkPren extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public checkPren() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sono nella servlet");
		
		String data = request.getParameter("date");
		System.out.println("data selezionata:" + data);
		
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
				try {
					prenotazioni=PrenotazioneDAO.selectAllByDay(data);
					
					
					Gson gson = new Gson();
					String json = gson.toJson(prenotazioni);
					System.out.println(json);
					response.getWriter().write(json);
					

				} catch (SQLException e) {
					e.printStackTrace();
				}
	
	}

}