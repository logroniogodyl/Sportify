package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.ASD;
import Data.ConnessioneDB;

public class AsdDAO {
	
	
	
	
	
	
	
	
	public List<ASD> selectAllAsd(){
		List<ASD> listaAsd = new ArrayList <ASD>();
		
		ConnessioneDB.connect();
        Connection connection = ConnessioneDB.getCon();
        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        System.out.println(preparedStatement);
        // Step 3: Execute the query or update query
        ResultSet rs = preparedStatement.executeQuery();
		
		return listaAsd;
	}  
}
