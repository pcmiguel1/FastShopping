package pcmiguel.fastshopping.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pcmiguel.fastshopping.Main.WindowManager;

public class LoginController {
	
	@FXML
    void clickLogin(ActionEvent event) {
		
		WindowManager.openMainWindow();
		
    }


}
