package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Campo;

import Data.ConnessioneDB;

public class CampoDAO {

		private static final String QUERY_FILTRO_CAMPO_PER_CITTA = "SELECT DISTINCT citta FROM asd WHERE idsocieta IN (SELECT codicesoc FROM campi);";
		
		public static List<String> selectCittaPerFiltro() throws SQLException{
			List<String> cittaperfiltro = new ArrayList<String>();
			
			ConnessioneDB.connect();
			Connection connection = ConnessioneDB.getCon();
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FILTRO_CAMPO_PER_CITTA);
	        System.out.println(preparedStatement);
	        
	        ResultSet rs = preparedStatement.executeQuery();
	        
	        while(rs.next())
	        {
	        	String citta = rs.getString("citta");
	        	System.out.println("Ho preso" + citta + "e ora procedo a metterla nella lista");
	        	cittaperfiltro.add(citta);
	        }
	        ConnessioneDB.close();
			
			return cittaperfiltro;
		}
		
		private static final String QUERY_FILTRO_CAMPO_PER_ASD = "SELECT DISTINCT nome FROM asd WHERE idsocieta IN (SELECT codiceSoc FROM campi);";
		
		public static List<String> selectASDPerFiltro() throws SQLException{
			List<String> ASDperfiltro = new ArrayList<String>();
				
			ConnessioneDB.connect();
			Connection connection = ConnessioneDB.getCon();
				
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FILTRO_CAMPO_PER_ASD);
		    System.out.println(preparedStatement);
		        
		    ResultSet rs = preparedStatement.executeQuery();
		        
		    while(rs.next())
		    {
		    	String associazione = rs.getString("nome");
		        System.out.println("Ho preso" + associazione + "e ora procedo a metterla nella lista");
		        ASDperfiltro.add(associazione);
		    }
		    ConnessioneDB.close();
				
		    return ASDperfiltro;
			}
		
		private static final String QUERY_FILTRO_CAMPO_PER_TIPOLOGIA = "SELECT DISTINCT tipologia FROM campi;";
		
		public static List<String> selectTipologiaPerFiltro() throws SQLException{
			List<String> Tipologiaperfiltro = new ArrayList<String>();
				
			ConnessioneDB.connect();
			Connection connection = ConnessioneDB.getCon();
				
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FILTRO_CAMPO_PER_TIPOLOGIA);
		    System.out.println(preparedStatement);
		        
		    ResultSet rs = preparedStatement.executeQuery();
		        
		    while(rs.next())
		    {
		    	String tipocampo = rs.getString("tipologia");
		        System.out.println("Ho preso" + tipocampo + "e ora procedo a metterla nella lista");
		        Tipologiaperfiltro.add(tipocampo);
		    }
		    ConnessioneDB.close();
				
		    return Tipologiaperfiltro;
			}
		
		private static final String SELECT_ALL_CAMPI = "SELECT * FROM campi;";
		
		public static List<Campo> selectAllCampi() throws SQLException{
			List<Campo> tutticampi = new ArrayList<Campo>();
			
			ConnessioneDB.connect();
			Connection connection = ConnessioneDB.getCon();
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CAMPI);
		    System.out.println(preparedStatement);
		        
		    ResultSet rs = preparedStatement.executeQuery();
		        
		    while(rs.next())
		    {
		    	int identificativocampo = rs.getInt("idcampo");
		    	int identificativosocieta = rs.getInt("codiceSoc");
		    	int prezzoh = rs.getInt("prezzOrari");
		    	String tipologiacampo = rs.getString("tipologia");
		    	String nomecampo = rs.getString("nome");
		    	tutticampi.add(new Campo(identificativocampo, identificativosocieta, prezzoh, tipologiacampo, nomecampo));
		    }
		    ConnessioneDB.close();
			
			return tutticampi;
		}
		
		private static final String QUERY_SELECT_NOME_ASD_BY_CAMPO_ID = "SELECT asd.nome AS nome FROM asd INNER JOIN campi ON asd.idsocieta = campi.codiceSoc WHERE campi.idcampo = ?;";
		
		public static String selectNomeASDbyCampoId(int idDELcampo) throws SQLException
		{
			String nomedesiderato = new String();
			
			ConnessioneDB.connect();
			Connection connection = ConnessioneDB.getCon();
				
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELECT_NOME_ASD_BY_CAMPO_ID);
		    System.out.println(preparedStatement);
		    preparedStatement.setInt(1, idDELcampo);
		    
		    ResultSet result = preparedStatement.executeQuery();
			
			if (result.next()) {
				nomedesiderato = result.getString("nome");
			}
			
			ConnessioneDB.close();
			
			System.out.println(nomedesiderato);
			return nomedesiderato;
		}
		
		private static final String QUERY_SELECT_INDIRIZZO_ASD_BY_CAMPO_ID = "SELECT asd.indirizzo AS indirizzo FROM asd INNER JOIN campi ON asd.idsocieta = campi.codiceSoc WHERE campi.idcampo = ?;";
		
		public static String selectIndirizzoASDbyCampoId(int idDELcampo) throws SQLException
		{
			String indirizzodesiderato = new String();
			
			ConnessioneDB.connect();
			Connection connection = ConnessioneDB.getCon();
				
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELECT_INDIRIZZO_ASD_BY_CAMPO_ID);
		    System.out.println(preparedStatement);
		    preparedStatement.setInt(1, idDELcampo);
		    
		    ResultSet result = preparedStatement.executeQuery();
		    
			
			if (result.next()) {
				indirizzodesiderato = result.getString("indirizzo");
			}
			
			ConnessioneDB.close();
			
			System.out.println(indirizzodesiderato);
			return indirizzodesiderato;
		}
		
		private static final String QUERY_SELECT_CITTA_ASD_BY_CAMPO_ID = "SELECT asd.citta AS citta FROM asd INNER JOIN campi ON asd.idsocieta = campi.codiceSoc WHERE campi.idcampo = ?;";
		
		public static String selectCittaASDbyCampoId(int idDELcampo) throws SQLException
		{
			String cittadesiderata = new String();
			
			ConnessioneDB.connect();
			Connection connection = ConnessioneDB.getCon();
				
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SELECT_CITTA_ASD_BY_CAMPO_ID);
		    System.out.println(preparedStatement);
		    preparedStatement.setInt(1, idDELcampo);
		    
		    ResultSet result = preparedStatement.executeQuery();
			
			if (result.next()) {
				cittadesiderata = result.getString("citta");
			}
			
			ConnessioneDB.close();
			
			System.out.println(cittadesiderata);
			return cittadesiderata;
		}
		
		private static final String SELECT_CAMPO_BY_ID = "SELECT * FROM campi WHERE(idcampo=?)";
		public static Campo selectCampiById(int id) throws SQLException{
			System.out.println(SELECT_CAMPO_BY_ID);
			Campo campo = null;
			
			ConnessioneDB.connect();
			
	        Connection connection = ConnessioneDB.getCon();
	        // Step 2:Create a statement using connection object
	        PreparedStatement st = connection.prepareStatement(SELECT_CAMPO_BY_ID); //CHIAMO LA QUERY
			st.setInt(1, id); //SETTO PUNTI INTERROGATIVI
			System.out.println(st);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) //NEXT E' UN BOOLEAN TRUE SE I VALORI MATCHANO ED ENTRA NEL CICLO
			{
				int id2=rs.getInt("idcampo");
				int idsoc=rs.getInt("codiceSoc");
				int prezzo=rs.getInt("prezzOrari");
				String tipo = rs.getString("tipologia");
				String nome = rs.getString("nome");
				campo=new Campo(id2,idsoc,prezzo,tipo,nome);
			}
			
			ConnessioneDB.close();
		return campo;
		}  
		
		private static final String SELECT_ALL_CAMPI_BY_ID = "SELECT * FROM campi WHERE codiceSoc=?;";
		
		public static List<Campo> selectAllCampiById(int id) throws SQLException{
			List<Campo> tutticampiperid = new ArrayList<Campo>();
			
			ConnessioneDB.connect();
			Connection connection = ConnessioneDB.getCon();
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CAMPI_BY_ID);
		    System.out.println(preparedStatement);
		    preparedStatement.setInt(1, id);
		        
		    ResultSet rs = preparedStatement.executeQuery();
		        
		    while(rs.next())
		    {
		    	int identificativocampo = rs.getInt("idcampo");
		    	int identificativosocieta = rs.getInt("codiceSoc");
		    	int prezzoh = rs.getInt("prezzOrari");
		    	String tipologiacampo = rs.getString("tipologia");
		    	String nomecampo = rs.getString("nome");
		    	tutticampiperid.add(new Campo(identificativocampo, identificativosocieta, prezzoh, tipologiacampo, nomecampo));
		    }
		    ConnessioneDB.close();
			
			return tutticampiperid;
		}
		
		private static final String QUERY_INSERT_CAMPO= "INSERT INTO `campi` (`codiceSoc`, `prezzOrari`, `tipologia`, `nome`) VALUES ('?', '?', '?', '?');";
		
		public void INSERT_CAMPO(Campo campo) throws SQLException {
	        System.out.println(QUERY_INSERT_CAMPO);
	        
	        try {
	        	ConnessioneDB.connect();
	        	Connection connection = ConnessioneDB.getCon();
	        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_CAMPO); 
	            preparedStatement.setInt(1, campo.getCodiceSoc());
	            preparedStatement.setInt(2, campo.getPrezzOrari());
	            preparedStatement.setString(3, campo.getTipologia());
	            preparedStatement.setString(4, campo.getNome());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnessioneDB.close();
			}
	    }
		private static final String QUERY_UPDATE_CAMPO = "UPDATE `campi` SET `prezzOrari` = '?', `tipologia` = '?', `nome` = '?' WHERE (`idcampo` = '?') and (`codiceSoc` = '?');";
		
		public boolean UPDATE_CAMPO(Campo campo) throws SQLException {
	        boolean rowUpdated = true;
	        try {
	        	ConnessioneDB.connect();
	        	Connection connection = ConnessioneDB.getCon();
	        	PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE_CAMPO);
	            statement.setInt(1, campo.getCodiceSoc());
	            statement.setInt(2, campo.getPrezzOrari());
	            statement.setString(3, campo.getTipologia());
	            statement.setString(4, campo.getNome());
	            statement.setInt(5, campo.getIdcampo());
	            statement.setInt(6, campo.getCodiceSoc());

	            rowUpdated = statement.executeUpdate() > 0;
	        }catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnessioneDB.close();
			}
	        return rowUpdated;
	    }

		
		/*private static final String QUERY_INSERT = "";
		private static final String QUERY_UPDATE = "";
		private static final String QUERY_DELETE = "";
		private static final String QUERY = "select * from ";
		private static final String SELECT_BY = "";*/
		
		
		
		/*public List<Campo> selectAllCampi() throws SQLException{
			System.out.println(QUERY);
			List<Campo> listaCampi = new ArrayList <Campo>();
			
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
	            listaCampi.add(new Campo(id, n , e , c ));//aspetto attributi
	        }
	        ConnessioneDB.close();
			
			return listaCampi;
		}  
		
		public void insertCampo(Campo campo) throws SQLException {
	        System.out.println(QUERY_INSERT);
	        
	        try {
	        	ConnessioneDB.connect();
	        	Connection connection = ConnessioneDB.getCon();
	        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT); 
	            preparedStatement.setString(1, campo.get());
	            preparedStatement.setString(2, campo.get());
	            preparedStatement.setString(3, campo.get());
	            preparedStatement.setString(4, campo.get());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnessioneDB.close();
			}
	    }
		public boolean updateCampo(Campo campo) throws SQLException {
			System.out.println(QUERY_UPDATE);
	        boolean rowUpdated = true;
	        try {
	        	ConnessioneDB.connect();
	        	Connection connection = ConnessioneDB.getCon();
	        	PreparedStatement statement = connection.prepareStatement(QUERY_UPDATE);
	            statement.setString(1, campo.get());
	            statement.setString(2, campo.get());
	            statement.setString(3, campo.get());
	            statement.setString(4, campo.get());
	            statement.setInt(5, campo.getId());

	            rowUpdated = statement.executeUpdate() > 0;
	        }catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnessioneDB.close();
			}
	        return rowUpdated;
	    }
		public boolean deleteCampo (int id) throws SQLException {
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

