package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.ASD;
import Data.ConnessioneDB;

public class AsdDAO {

	private static final String SELECT_ALL_ASD = "SELECT idsocieta, citta, nome, indirizzo, provincia, regione, email, password, telefono, geolocalizzazione FROM asd;";	
	public static List<ASD> selectAllAsd() throws SQLException{
		System.out.println(SELECT_ALL_ASD);
		List<ASD> listaAsd = new ArrayList <ASD>();
		
		ConnessioneDB.connect();
        Connection connection = ConnessioneDB.getCon();
        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ASD);
        System.out.println(preparedStatement);
        // Step 3: Execute the query or update query
        ResultSet rs = preparedStatement.executeQuery();
     // Step 4: Process the ResultSet object.
        while (rs.next()) {
            int id = rs.getInt("idsocieta");
            String citta = rs.getString("citta");
            String nome = rs.getString("nome");
            String indirizzo = rs.getString("indirizzo");
            String provincia = rs.getString("provincia");
            String regione = rs.getString("regione");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String telefono = rs.getString("telefono");
            String geolocalizzazione = rs.getString("geolocalizzazione");
            listaAsd.add(new ASD(id, citta , nome , indirizzo, provincia, regione, email, password, telefono, geolocalizzazione));//setting the attributes
        }
        ConnessioneDB.close();
		
		return listaAsd;
	}
	
	private static final String SELECT_PER_CITTA = "SELECT asd.citta FROM asd GROUP BY asd.citta";
	public static List<String> selectByCitta() throws SQLException
	{
		List<String> listaASDperCitta = new ArrayList<String>();
		
		ConnessioneDB.connect();
		Connection connection = ConnessioneDB.getCon();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PER_CITTA);
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next())
		{
			String citta = rs.getString("citta");
			listaASDperCitta.add(citta);
		}
		ConnessioneDB.close();
		
		return listaASDperCitta;
	}
	
	private static final String SELECT_PER_PROVINCIA = "SELECT asd.provincia FROM asd GROUP BY asd.provincia";
	public List<String> selectByProvincia() throws SQLException
	{
		List<String> listaASDperProvincia = new ArrayList<String>();
		
		ConnessioneDB.connect();
		Connection connection = ConnessioneDB.getCon();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PER_PROVINCIA);
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next())
		{
			String provincia = rs.getString("provincia");
			listaASDperProvincia.add(provincia);
		}
		ConnessioneDB.close();
		
		return listaASDperProvincia;
	}
	
	private static final String SELECT_PER_REGIONE = "SELECT asd.regione FROM asd GROUP BY asd.regione";
	public static List<String> selectByRegione() throws SQLException
	{
		List<String> listaASDperRegione = new ArrayList<String>();
		
		ConnessioneDB.connect();
		Connection connection = ConnessioneDB.getCon();
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PER_REGIONE);
		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next())
		{
			String regione = rs.getString("regione");
			listaASDperRegione.add(regione);
		}
		ConnessioneDB.close();
		
		return listaASDperRegione;
	}
	
	private static final String SELECT_ASD_BY_EMAIL = "select * from ASD where (email=?)"; //FATTA
	//RICHIAMARE ASD TRAMITE MAIL
	public static ASD selectASDByEmail(String email)
	{
	System.out.println("Effettuo check account");
	ASD asd = null;
	try {
		ConnessioneDB.connect();
		Connection connection= ConnessioneDB.getCon();
		PreparedStatement st = connection.prepareStatement(SELECT_ASD_BY_EMAIL); //CHIAMO LA QUERY
		st.setString(1, email); //SETTO PUNTI INTERROGATIVI
		System.out.println(st);
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) //NEXT E' UN BOOLEAN TRUE SE I VALORI MATCHANO ED ENTRA NEL CICLO
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
	
	private static final String SELECT_ASD_BY_NOME = "select * from ASD where LOWER(nome=?)"; //FATTA	
	public static ASD selectASDBynome(String nome)
	{
	System.out.println("Effettuo check account");
	ASD asd = null;
	try {
		ConnessioneDB.connect();
		Connection connection= ConnessioneDB.getCon();
		PreparedStatement st = connection.prepareStatement(SELECT_ASD_BY_NOME);
		st.setString(1, nome);
		System.out.println(st);
		ResultSet rs=st.executeQuery();
		
		while(rs.next())
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
	
	private static final String QUERY_INSERT = "INSERT INTO ASD (citta, nome, indirizzo, provincia, regione, email, password, telefono) VALUES (?, ?, ?, ?, ?, ?,?,?);";
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
	
	private static final String SELECT_ASD_BY_ID = "SELECT * FROM asd WHERE (idsocieta=?)"; //FATTA	
	public static ASD selectASDByID(int id)
	{
	System.out.println("Effettuo check account");
	ASD asd = null;
	try {
		ConnessioneDB.connect();
		Connection connection= ConnessioneDB.getCon();
		PreparedStatement st = connection.prepareStatement(SELECT_ASD_BY_ID);
		st.setInt(1, id);
		System.out.println(st);
		ResultSet rs=st.executeQuery();
		
		while(rs.next())
		{
			int id2=rs.getInt("idsocieta");
			String citta=rs.getString("citta");
			String nome = rs.getString("nome");
			String indirizzo = rs.getString("indirizzo");
			String provincia = rs.getString("provincia");
			String regione = rs.getString("regione");
			String email = rs.getString("email");
			String password = rs.getString("password");
			String telefono = rs.getString("telefono");
			asd=new ASD(id2,citta,nome,indirizzo,provincia,regione,email,password,telefono);
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
	
			private static final String QUERY_UPDATE_PROFILO = "UPDATE `asd` SET `indirizzo` = ?, `regione` = ?, `provincia` = ?, `citta` = ?, `telefono` = ?, `email` = ?, `password` = ? WHERE (`idsocieta` = ?);";
			
			public boolean updateAsd(ASD asd) throws SQLException {
				System.out.println(QUERY_UPDATE_PROFILO);
				boolean rowUpdated = true;
		        try {
		        	ConnessioneDB.connect();
		        	Connection connection = ConnessioneDB.getCon();
		        	PreparedStatement st = connection.prepareStatement(QUERY_UPDATE_PROFILO + "\n");
		        	
		        	st.setString(1, asd.getIndirizzo());
		        	st.setString(2, asd.getRegione());
		        	st.setString(3, asd.getProvincia());
		        	st.setString(4, asd.getCitta());
		        	st.setString(5, asd.getTelefono());
		        	st.setString(6, asd.getEmail());
		        	st.setString(7, asd.getPassword());
		        	st.setInt(8, asd.getIdsocieta());
		
		            rowUpdated = st.executeUpdate() > 0;
		            
		            System.out.println("rowupdate= " + rowUpdated + "\n");
		            System.out.println("Ho aggiornato la ASD con i seguenti dati: " + asd + "\n");
		        }catch (SQLException e) {
					e.printStackTrace();
				}
				ConnessioneDB.close();
				
		        return rowUpdated;
		    }
	
	private static final String QUERY_DELETE = "";
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
	
	public static void closeDAO() {
		try {
			ConnessioneDB.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}

}
