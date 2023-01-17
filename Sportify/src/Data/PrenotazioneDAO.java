package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Model.Prenotazione;

public class PrenotazioneDAO {

	private static final String QUERY_UPDATE = "";
	private static final String QUERY_DELETE = "";
	private static final String QUERY = "select * from ";
	private static final String SELECT_BY = "";
	
	private static final String SELECT_BY_DAY = "SELECT * FROM prenotazione WHERE (data_prenotazione=?)";
	public static List<Prenotazione> selectAllByDay(String data) throws SQLException{
		System.out.println(SELECT_BY_DAY);
		List<Prenotazione> listaPrenotazioni = new ArrayList <Prenotazione>();
		
		ConnessioneDB.connect();
		
        Connection connection = ConnessioneDB.getCon();
        // Step 2:Create a statement using connection object
        PreparedStatement st = connection.prepareStatement(SELECT_BY_DAY);
        st.setString(1, data);
        System.out.println(st);
        // Step 3: Execute the query or update query
        
        
        ResultSet rs = st.executeQuery();
        // Step 4: Process the ResultSet object.
        while (rs.next()) {
            String data2 = rs.getString("data_prenotazione");
            int ora = rs.getInt("ora_prenotazione");
            String mail = rs.getString("email_nonRegistrato");
           
            int idcampo = rs.getInt("idcampo");
            String num=rs.getString("numeroTelefono");
            String nome=rs.getString("nome");
            String tipo=rs.getString("tipologia");
            listaPrenotazioni.add(new Prenotazione(data2 , ora , mail, idcampo,num,nome,tipo ));
        }
        ConnessioneDB.close();
		
		return listaPrenotazioni;
	}
	
	private static final String QUERY_INSERT = "INSERT INTO sportify.prenotazione (`data_prenotazione`, `ora_prenotazione`, `email_nonRegistrato`, `idcampo`, `numeroTelefono`, `nome`, `tipologia`) VALUES (?, ?, ?, ?, ?, ?,?);";
	public static void insertPrenotazione(Prenotazione prenotazione) throws SQLException {
        System.out.println(QUERY_INSERT);
        
        try {
        	ConnessioneDB.connect();
        	Connection connection = ConnessioneDB.getCon();
        	
        	
        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT); 
            preparedStatement.setString(1, prenotazione.getData_prenotazione());
            preparedStatement.setInt(2, prenotazione.getOra_prenotazione());
            preparedStatement.setString(3, prenotazione.getEmail_nonRegistrato());
            preparedStatement.setInt(4, prenotazione.getIdcampo());
            preparedStatement.setString(5, prenotazione.getNumeroTelefono());
            preparedStatement.setString(6, prenotazione.getNome());
            preparedStatement.setString(7, prenotazione.getTipologia());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnessioneDB.close();
		}
    }
	
	
	
	
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
