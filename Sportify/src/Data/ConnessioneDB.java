package Data;

import java.sql.Connection;

import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnessioneDB {
	private static Connection con;
	// parametri di configurazione del DB
	private static final String NOME_DB = "";//DEVE DARCELI LUCA
	private static final int PORT = 3306;
	private static final String SERVER_NAME = "localhost";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";//OGNUNO METTE LA SUA

	public ConnessioneDB() {
		ConnessioneDB.con = null;
	}

	public static Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	// metodo di connessione al db con i parametri corretti
	public static void connect() throws SQLException {
		try {
			if (con == null) {

				// oggeto di tipo MysqlDataSource per settare i parametri di configurazione
				MysqlDataSource dataSource = new MysqlDataSource();
				dataSource.setDatabaseName(NOME_DB);
				dataSource.setPortNumber(PORT);
				dataSource.setServerName(SERVER_NAME);
				dataSource.setUser(USERNAME);
				dataSource.setPassword(PASSWORD);

				con = dataSource.getConnection();

				System.out.println("Connessione avvenuta con il database : " + con.getCatalog());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close() throws SQLException {
		try {
			ConnessioneDB.con.close();
			ConnessioneDB.con = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
