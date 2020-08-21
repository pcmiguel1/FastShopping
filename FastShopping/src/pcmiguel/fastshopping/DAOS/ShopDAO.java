package pcmiguel.fastshopping.DAOS;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShopDAO {
	
	public static void addShop(String name, String coord, String owner, String type) {

		try {
			
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("INSERT INTO Shop (shopName, coords, shopOwner, shopType) VALUES (?,?,?,?)");
			statement.setString(1, name);
			statement.setString(2, coord);
			statement.setString(3, owner);
			statement.setString(4, type);
			statement.executeUpdate();
			

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
