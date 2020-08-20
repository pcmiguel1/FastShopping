package pcmiguel.fastshopping.Controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import pcmiguel.fastshopping.Main.WindowManager;

public class MapaScreenController {
	
	@FXML
    void cart(MouseEvent event) {
		WindowManager.openCartWindow();
    }

}
