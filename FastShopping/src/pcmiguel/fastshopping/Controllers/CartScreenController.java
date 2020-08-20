package pcmiguel.fastshopping.Controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import pcmiguel.fastshopping.Main.WindowManager;

public class CartScreenController {
	
	@FXML
    void mapaLojas(MouseEvent event) {
		
		WindowManager.openMainWindow();
		
    }

}
