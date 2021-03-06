package pcmiguel.fastshopping.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import pcmiguel.fastshopping.DAOS.LoginDAO;
import pcmiguel.fastshopping.Main.WindowManager;

public class LoginController {
	
	public static String username;
	
	@FXML
    private TextField user;

    @FXML
    private PasswordField password;
    
    @FXML
    private AnchorPane dialogLoginError;

	
	@FXML
    void clickLogin(ActionEvent event) {
		
		login();
		
		
    }
	
	@FXML
    void LoginEnter(KeyEvent event) {

		if (event.getCode() == KeyCode.ENTER) {
			login();
		}
		
    }
	
	@FXML
    void createAccount(MouseEvent event) {
		WindowManager.openRegisterWindow();
    }
	
	
	
	private void login() {
		
		//Check if is not empty
		if (!user.getText().isEmpty() && !password.getText().isEmpty()) {
			// Check if the user and password exists
			if (LoginDAO.checkUser(user.getText(), password.getText())) {
				
				if (LoginDAO.checkAdmin(user.getText())) {
					WindowManager.openAdminWindow();
				}
				else {
					username = user.getText();
					WindowManager.openMainWindow();
				}
			}
			else {
				dialogLoginError.setVisible(true);
			}
		}
		
	}


}
