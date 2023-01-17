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
		String day = request.getParameter("day");
		System.out.println("data selezionata:" + data);
		
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		List<Prenotazione> allenamenti = new ArrayList<Prenotazione>();
		try {
			prenotazioni=PrenotazioneDAO.selectAllByDay(data);
			Gson gson = new Gson();
			System.out.println("SONO IN prenotazioni: " + prenotazioni);
	
			allenamenti=PrenotazioneDAO.selectAllByDay(day);
			prenotazioni.addAll(allenamenti);
			for (int i = 0; i < allenamenti.size(); i++) {
			    Prenotazione element = allenamenti.get(i);
			    System.out.println(element.getNome());
			}
			String json = gson.toJson(prenotazioni);
			System.out.println(json);
			response.getWriter().write(json);
			System.out.println("SONO IN ALLENAMENTI: " + allenamenti);
			System.out.println("SONO IN prenotazioni finali: " + prenotazioni);
			System.out.println(json);
			
			

			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
	}