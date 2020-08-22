package pcmiguel.fastshopping.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import pcmiguel.fastshopping.DAOS.ShopDAO;
import pcmiguel.fastshopping.Main.WindowManager;

public class ShopScreenController {
	
	@FXML
    private Label shopName;
	
	@FXML
	private void initialize() {
		
		shopName.setText(ShopDAO.getShopName(MapaScreenController.idLoja));
		
	}
	
	@FXML
    void mapaLojas(MouseEvent event) {
		WindowManager.openMainWindow();
    }

}
