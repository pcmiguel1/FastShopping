package pcmiguel.fastshopping.DAOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

	private static Connection connection = null;
	static Statement statement;
	
	public String host, database, username, password;
	public int port;
	
	public static void abrirConexao() {
		String host = "localhost";
		String database = "fastshopping";
		String username = "root";
		String password = "";
		Integer port = 3306;
		
		String URL = "jdbc:mysql://" + host + ":" + port + "/" + database;
		
		try {
			connection = DriverManager.getConnection(URL, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
