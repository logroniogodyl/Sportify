package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Model.Prenotazione;

public class PrenotazioneDAO {

	private static final String QUERY_INSERT = "";
	private static final String QUERY_UPDATE = "";
	private static final String QUERY_DELETE = "";
	private static final String QUERY = "select * from ";
	private static final String SELECT_BY = "";
	
	
	
	/*public List<Prenotazione> selectAllPrenotazioni() throws SQLException{
		System.out.println(QUERY);
		List<Prenotazione> listaPrenotazioni = new ArrayList <Prenotazione>();
		
		ConnessioneDB.connect();
		
        Connection connection = ConnessioneDB.getCon();
        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        System.out.println(preparedStatement);
        // Step 3: Execute the query or update query
        ResultSet rs = preparedStatement.executeQuery();
     // Step 4: Process the ResultSet object.
        while (rs.next()) {
            int id = rs.getInt("id");
            String n = rs.getString("");
            String e = rs.getString("");
            String c = rs.getString("");
            listaPrenotazioni.add(new Prenotazione(id, n , e , c ));//aspetto attributi
        }
        ConnessioneDB.close();
		
		return listaPrenotazioni;
	}  
	
	public void insertPrenotazione(Prenotazione prenotazione) throws SQLException {
        System.out.println(QUERY_INSERT);
        
        try {
        	ConnessioneDB.connect();
        	Connection connection = ConnessioneDB.getCon();
        	//aggiungere controllo con selectAll dove se data+ora+campo =! allora inserisco prenotazione
        	
        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT); 
            preparedStatement.setString(1, prenotazione.get());
            preparedStatement.setString(2, prenotazione.get());
            preparedStatement.setString(3, prenotazione.get());
            preparedStatement.setString(4, prenotazione.get());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnessioneDB.close();
		}
    }
	public boolean updatePrenotazione(Prenotazione prenotazione) throws SQLException {
		System.out.println(QUERY_UPDATE);
        boolean rowUpdated = true;
        try {
        	ConnessioneDB.connect();
        	Connection connection = ConnessioneDB.getCon();
        	PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE);
            statement.setString(1, prenotazione.get());
            statement.setString(2, prenotazione.get());
            statement.setString(3, prenotazione.get());
            statement.setString(4, prenotazione.get());
            statement.setInt(5, prenotazione.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnessioneDB.close();
		}
        return rowUpdated;
    }
	public boolean deletePrenotazione (int id) throws SQLException {
		System.out.println(QUERY_DELETE);
        boolean rowDeleted = true;
        try {
        	ConnessioneDB.connect();
        	Connection connection = ConnessioneDB.getCon();
        	PreparedStatement statement = connection.prepareStatement(QUERY_DELETE);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnessioneDB.close();
		}
        return rowDeleted;
    }*/
	
}
