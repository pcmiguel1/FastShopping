package pcmiguel.fastshopping.DAOS;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public static ArrayList<String> loadAllCoodsShops() {
		ArrayList<String> coordsShop = new ArrayList<String>();
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT coords, shopType FROM Shop");
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				coordsShop.add(results.getString(1)+"#"+results.getString(2));
			}
			statement.close();
			results.close();
		}
		catch (SQLException ev) {
			ev.printStackTrace();
		}
		return coordsShop;
	}
	
	public static String getShopName(int id) {	
		String shopName = "";
		try {
			PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT shopName FROM Shop WHERE idShop = ?");
			statement.setInt(1, id);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				shopName = results.getString(1);
			}
			statement.close();
			results.close();
		}
		catch (SQLException ev) {
			ev.printStackTrace();
		}
		return shopName;
	}

}
