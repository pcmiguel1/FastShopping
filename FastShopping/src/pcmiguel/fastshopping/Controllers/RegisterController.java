package pcmiguel.fastshopping.Controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import pcmiguel.fastshopping.Main.WindowManager;

public class RegisterController {
	
	@FXML
    void LoginScreen(MouseEvent event) {
		WindowManager.openLoginWindow();
    }

}
