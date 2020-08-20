package pcmiguel.fastshopping.Main;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		//Conectar com a base de dados
		//DBConnector.abrirConexao();
	
		WindowManager.setPrimaryStage(primaryStage);
		WindowManager.openLoginWindow();
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
