package pcmiguel.fastshopping.Controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import pcmiguel.fastshopping.DAOS.ShopDAO;
import pcmiguel.fastshopping.Main.Main;
import pcmiguel.fastshopping.Main.WindowManager;
import pcmiguel.fastshopping.Models.ShopType;

public class MapaScreenController {
	
	@FXML
    private AnchorPane root;
	
	@FXML
	private void initialize() {
		
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
					
					Image image = new Image(Main.class.getResource(st.getImage()).toString());
					
					ImageView imageView = new ImageView(image); 
					
					imageView.setX(circle.getCenterX() - 9); 
				    imageView.setY(circle.getCenterY() - 9); 
				    
				    
				    imageView.setFitHeight(18); 
				    imageView.setFitWidth(18); 
					
					root.getChildren().add(circle);
					root.getChildren().add(imageView);	
					
				}
				
			}		
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
