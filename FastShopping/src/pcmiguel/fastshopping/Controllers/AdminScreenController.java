package pcmiguel.fastshopping.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pcmiguel.fastshopping.Main.WindowManager;

public class AdminScreenController {
	
	private boolean selectLocationMode = false;
	
	private double coordX, coordY;
	
	@FXML
    private AnchorPane dialogAddShop;
	
	@FXML
    private ImageView locationShop, btnImgAddShop, btnImgConfirm;
	
	@FXML
    private Button btnAddShop, btnConfirm;

	
	@FXML
    void MapClick(MouseEvent event) {
		
		if (selectLocationMode) {
			
			coordX = event.getX();
			coordY = event.getY();
			
			locationShop.setVisible(true);
			locationShop.setLayoutX(coordX);
			locationShop.setLayoutY(coordY);
		}
		
    }
	
	
	@FXML
    void logout(MouseEvent event) {
		WindowManager.openLoginWindow();
    }

    @FXML
    void addShop(ActionEvent event) {
    	
    	dialogAddShop.setVisible(true);
    	locationShop.setVisible(false);
    	

    }
    
    @FXML
    void selectLocationShop(ActionEvent event) {
    	dialogAddShop.setVisible(false);
    	selectLocationMode = true;
    	
    	btnAddShop.setVisible(false);
    	btnImgAddShop.setVisible(false);
    	btnConfirm.setVisible(true);
    	btnImgConfirm.setVisible(true);
    	
    }
    
    @FXML
    void closeDialogNewShop(MouseEvent event) {
    	dialogAddShop.setVisible(false);
    	
    	btnAddShop.setVisible(true);
    	btnImgAddShop.setVisible(true);
    	
    }
    
    @FXML
    void confirmShop(ActionEvent event) {
    	
    	System.out.print("X: " + coordX + " Y: " + coordY);
    	
    }


}
