package pcmiguel.fastshopping.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pcmiguel.fastshopping.DAOS.ShopDAO;
import pcmiguel.fastshopping.Main.WindowManager;

public class AdminScreenController {
	
	private boolean selectLocationMode = false;
	
	private double coordX, coordY;
	
	private String shopName, ownerShop, shopType;
	
	@FXML
    private AnchorPane dialogAddShop;
	
	@FXML
    private ImageView locationShop, btnImgAddShop, btnImgConfirm;
	
	@FXML
    private Button btnAddShop, btnConfirm;
	
	@FXML
    private TextField shopname, ownershop;
	
	@FXML
    private ComboBox<String> shoptype;
	
	
	@FXML
	private void initialize() {
		
		shoptype.getItems().add("Roupa");
		shoptype.getItems().add("Restaurante");
		shoptype.getItems().add("Brinquedos");
		shoptype.getItems().add("Desporto");
		
	}

	
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
    	
    	if (!shopname.getText().isEmpty() && !ownershop.getText().isEmpty() && shoptype.getValue() != null) {
    		
    		shopName = shopname.getText();
    		ownerShop = ownershop.getText();
    		shopType = shoptype.getValue();
    		
    		
    		dialogAddShop.setVisible(false);
        	selectLocationMode = true;
        	
        	btnAddShop.setVisible(false);
        	btnImgAddShop.setVisible(false);
        	btnConfirm.setVisible(true);
        	btnImgConfirm.setVisible(true);
    		
    	}
    	
    }
    
    @FXML
    void closeDialogNewShop(MouseEvent event) {
    	dialogAddShop.setVisible(false);
    	
    	btnAddShop.setVisible(true);
    	btnImgAddShop.setVisible(true);
    	
    }
    
    @FXML
    void confirmShop(ActionEvent event) {
    	
    	String coord = coordX + "#" + coordY;
    	ShopDAO.addShop(shopName, coord, ownerShop, shopType);
    	WindowManager.openAdminWindow();
    	
    }


}
