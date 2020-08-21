package pcmiguel.fastshopping.DAOS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	public static boolean checkUser(String username, String password) {
		boolean verificar = false;
		try {
			//Vai verificar se o nome já existe na base de dados
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT idUser FROM user WHERE username = ? and password = ?");
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet results = statement.executeQuery();
			//se o utilizador existir na base dedados 
			if (results.next()) {

				verificar = true;
			}
			statement.close();
			results.close();
		}
		catch (SQLException ev) {
			ev.printStackTrace();
		}
		return verificar;
	}
	
	public static boolean checkAdmin(String username) {
		
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT isAdmin FROM User WHERE username = ?");
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				return results.getBoolean(1);
			}
			statement.close();
			results.close();
		}
		catch (SQLException ev) {
			ev.printStackTrace();
		}
		return false;
		
	}

}
