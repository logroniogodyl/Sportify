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
	
	private static final String QUERY_INSERT = "INSERT INTO ASD (citta, nome, indirizzo, provincia, regione, email, password, telefono) VALUES (?, ?, ?, ?, ?, ?,?,?);";
	private static final String QUERY_UPDATE = "";
	private static final String QUERY_DELETE = "";
	private static final String QUERY = "select * from ";
	private static final String SELECT_ASD_BY_NOME = "select * from ASD where LOWER(nome=?)"; //fatta
	private static final String SELECT_ASD_BY_EMAIL = "select * from ASD where (email=?)"; //fatta
	
	
	
	//richiamare asd tramite l'email
	public static ASD selectASDByEmail(String email)
	{
	System.out.println("Effettuo check account");
	ASD asd = null;
	try {
		ConnessioneDB.connect();
		Connection connection= ConnessioneDB.getCon();
		PreparedStatement st = connection.prepareStatement(SELECT_ASD_BY_EMAIL); //chiamo la query
		st.setString(1, email); //setto punti interrogativi
		System.out.println(st);
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) //next è un boolean true se i valori matchano ed entra nel ciclo;
		{
			int id=rs.getInt("idsocieta");
			String citta=rs.getString("citta");
			String nome = rs.getString("nome");
			String indirizzo = rs.getString("indirizzo");
			String provincia = rs.getString("provincia");
			String regione = rs.getString("regione");
			String email2 = rs.getString("email");
			String password = rs.getString("password");
			String telefono = rs.getString("telefono");
			asd=new ASD(id,citta,nome,indirizzo,provincia,regione,email2,password,telefono);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally
	{
		closeDAO();
	}
	return asd;
}
	
	
	public static ASD selectASDBynome(String nome)
	{
	System.out.println("Effettuo check account");
	ASD asd = null;
	try {
		ConnessioneDB.connect();
		Connection connection= ConnessioneDB.getCon();
		PreparedStatement st = connection.prepareStatement(SELECT_ASD_BY_NOME); //chiamo la query
		st.setString(1, nome); //setto punti interrogativi
		System.out.println(st);
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) //next è un boolean true se i valori matchano ed entra nel ciclo;
		{
			int id=rs.getInt("idsocieta");
			String citta=rs.getString("citta");
			String nome2 = rs.getString("nome");
			String indirizzo = rs.getString("indirizzo");
			String provincia = rs.getString("provincia");
			String regione = rs.getString("regione");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String telefono = rs.getString("telefono");
			asd=new ASD(id,citta,nome2,indirizzo,provincia,regione,email,password,telefono);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally
	{
		closeDAO();
	}
	return asd;
}
	
	
	
	
	
	public List<ASD> selectAllAsd() throws SQLException{
		System.out.println(QUERY);
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
	
	
	
	
	
	
	
	
	//INSERIRE NUOVO ASD 
	
	public static void insertAsd(ASD asd) throws SQLException {
        System.out.println(QUERY_INSERT);
        
        try {
        	ConnessioneDB.connect();
        	Connection connection = ConnessioneDB.getCon();
        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT); 
            
        	preparedStatement.setString(1, asd.getCitta());
            preparedStatement.setString(2, asd.getNome());
            preparedStatement.setString(3, asd.getIndirizzo());
            preparedStatement.setString(4, asd.getProvincia());
            preparedStatement.setString(5, asd.getRegione());
            preparedStatement.setString(6, asd.getEmail());
            preparedStatement.setString(7, asd.getPassword());
            preparedStatement.setString(8, asd.getTelefono());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnessioneDB.close();
		}
    }
	
	
	
	public boolean updateAsd(ASD asd) throws SQLException {
		System.out.println(QUERY_UPDATE);
        boolean rowUpdated = true;
        try {
        	ConnessioneDB.connect();
        	Connection connection = ConnessioneDB.getCon();
        	PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE);
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
    }
	//public ASD selectAsdBy.. quando abbiamo attributi db
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void closeDAO() {
		try {
			ConnessioneDB.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}

}
