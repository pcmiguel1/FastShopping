package pcmiguel.fastshopping.Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pcmiguel.fastshopping.DAOS.DBConnector;
import pcmiguel.fastshopping.DAOS.ShopDAO;
import pcmiguel.fastshopping.Main.Main;
import pcmiguel.fastshopping.Main.WindowManager;
import pcmiguel.fastshopping.Models.ShopType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapaScreenController {
	
	@FXML
    private Label username;
	
	@FXML
    private AnchorPane root;
	
	public static int idLoja;
	
	@FXML
	private void initialize() {
		
		username.setText(LoginController.username);
		
		for (String coords : ShopDAO.loadAllCoodsShops()) {
			
			String[] split = coords.split("#");
			double coordx = Double.parseDouble(split[0]);
			double coordy = Double.parseDouble(split[1]);
			String type = split[2];
			
			for (ShopType st : ShopType.values()) {
				
				if (type.equals(st.getType())) {
					
					
					
					Circle circle = new Circle(1, 1, 14, st.getColor());
					circle.setStroke(Color.BLACK);
					circle.setStrokeWidth(1);
					circle.setCenterX(coordx);
					circle.setCenterY(coordy);
					circle.setRadius(13);
					circle.setCursor(Cursor.HAND);
					
					Image image = new Image(Main.class.getResource(st.getImage()).toString());
					
					ImageView imageView = new ImageView(image); 
					
					imageView.setX(circle.getCenterX() - 9); 
				    imageView.setY(circle.getCenterY() - 9); 
				    imageView.setFitHeight(18); 
				    imageView.setFitWidth(18); 
				    imageView.setCursor(Cursor.HAND);
					
					root.getChildren().add(circle);
					root.getChildren().add(imageView);	
					
				}
				
			}		
		}
		
		root.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			public void handle(MouseEvent event) {
				
				double x = event.getX();
				double y = event.getY();
				
				try {
					
					PreparedStatement statement = DBConnector.getConnection().prepareStatement("SELECT idShop, coords FROM Shop");
					ResultSet results = statement.executeQuery();
					while (results.next()) {
						String coordenadas = results.getString(2);
						//Vai tirar o # das coordenadas para sabermos a coordenada X e Y
						String[] split = coordenadas.split("#");
						double coordxLoja = Double.parseDouble(split[0]);
						double coordyLoja = Double.parseDouble(split[1]);
						
						//Vai comparar se as coordenadas onde o utilizador clicou com o rato coincidem com a da loja
						if (x > coordxLoja - 13 / 2 && x < coordxLoja + 13 / 2 && y > coordyLoja - 13 / 2 && y < coordyLoja + 13 / 2) {
							idLoja = results.getInt(1);
							WindowManager.openShopWindow();
						}
						
					}
					statement.close();
					results.close();
					
				}
				catch (SQLException ev) {
					ev.printStackTrace();
				}
				
			}
			
		});
		
	}
	
	@FXML
    void cart(MouseEvent event) {
		WindowManager.openCartWindow();
    }
	
	@FXML
    void logout(MouseEvent event) {
		WindowManager.openLoginWindow();
    }

}
