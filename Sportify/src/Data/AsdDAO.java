package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ASD;
import model.Account;
import Data.ConnessioneDB;

public class AsdDAO {
	
	private static final String QUERY INSERT = "";
	private static final String QUERY UPDATE = "";
	private static final String QUERY DELETE = "";
	private static final String QUERY = "select * from ";
	private static final String SELECT_USER_BY = "";
	
	
	
	public List<ASD> selectAllAsd() throws SQLException{
		List<ASD> listaAsd = new ArrayList <ASD>();
		
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
            listaAsd.add(new ASD(id, n , e , c ));//aspetto attributi
        }
        ConnessioneDB.close();
		
		return listaAsd;
	}  
	public void insertAsd(ASD asd) throws SQLException {
        System.out.println(QUERY INSERT);
        
        try {
        	ConnessioneDB.connect();
        	Connection connection = ConnessioneDB.getCon();
        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY INSERT); 
            preparedStatement.setString(1, asd.get());
            preparedStatement.setString(2, asd.get());
            preparedStatement.setString(3, asd.get());
            preparedStatement.setString(4, asd.get());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnessioneDB.close();
		}
    }
	public boolean updateAsd(ASD asd) throws SQLException {
        boolean rowUpdated = true;
        try {
        	ConnessioneDB.connect();
        	Connection connection = ConnessioneDB.getCon();
        	PreparedStatement statement = connection.prepareStatement(QUERY UPDATE);
            statement.setString(1, asd.get());
            statement.setString(2, asd.get());
            statement.setString(3, asd.get());
            statement.setString(4, asd.get());
            statement.setInt(5, asd.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnessioneDB.close();
		}
        return rowUpdated;
    }
	public boolean deleteAsd (int id) throws SQLException {
        boolean rowDeleted = true;
        try {
        	ConnessioneDB.connect();
        	Connection connection = ConnessioneDB.getCon();
        	PreparedStatement statement = connection.prepareStatement(QUERY DELETE);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnessioneDB.close();
		}
        return rowDeleted;
    }
	//public ASD selectAsdBy.. quando abbiamo attributi db
	
}
