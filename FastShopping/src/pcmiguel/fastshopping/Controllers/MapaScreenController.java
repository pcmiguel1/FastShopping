package pcmiguel.fastshopping.Controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pcmiguel.fastshopping.DAOS.ShopDAO;
import pcmiguel.fastshopping.Main.WindowManager;

public class MapaScreenController {
	
	@FXML
    private AnchorPane root;
	
	@FXML
	private void initialize() {
		
		for (String coords : ShopDAO.loadAllCoodsShops()) {
			
			String[] split = coords.split("#");
			double coordx = Double.parseDouble(split[0]);
			double coordy = Double.parseDouble(split[1]);
			
			Circle circle = new Circle(1, 1, 7, Color.RED);
			circle.setStroke(Color.BLACK);
			circle.setStrokeWidth(1);
			circle.setLayoutX(coordx);
			circle.setLayoutY(coordy);
			root.getChildren().add(circle);
			
		}
		
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
