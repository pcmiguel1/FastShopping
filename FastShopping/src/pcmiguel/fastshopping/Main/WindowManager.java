package pcmiguel.fastshopping.Main;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pcmiguel.fastshopping.Controllers.AdminScreenController;
import pcmiguel.fastshopping.Controllers.CartScreenController;
import pcmiguel.fastshopping.Controllers.LoginController;
import pcmiguel.fastshopping.Controllers.MapaScreenController;
import pcmiguel.fastshopping.Controllers.RegisterController;
import pcmiguel.fastshopping.Controllers.ShopScreenController;

public class WindowManager {

	private static Stage primaryStage;

	public static void setPrimaryStage(Stage primaryStage) {
		WindowManager.primaryStage = primaryStage;
	}

	// Metodo que serve para abrir a janela do Mapa das Lojas
	public static void openMainWindow() {
		openWindow("../Views/MapaScreen.fxml", primaryStage, new MapaScreenController(), "FastShopping", 400, 600);
		primaryStage.show();
	}
	
	// Metodo que serve para abrir a janela de Login
	public static void openLoginWindow() {
		openWindow("../Views/LoginScreen.fxml", primaryStage, new LoginController(), "FastShopping", 400,
				600);
		primaryStage.show();
	}
	
	// Metodo que serve para abrir a janela de Register
	public static void openRegisterWindow() {
		openWindow("../Views/RegisterScreen.fxml", primaryStage, new RegisterController(), "FastShopping", 400,
				600);
		primaryStage.show();
	}
	
	// Metodo que serve para abrir a janela de Cart
	public static void openCartWindow() {
		openWindow("../Views/CartScreen.fxml", primaryStage, new CartScreenController(), "FastShopping", 400,
				600);
		primaryStage.show();
	}

	// Metodo que serve para abrir a janela do Painel Administrativo
	public static void openAdminWindow() {
		openWindow("../Views/AdminScreen.fxml", primaryStage, new AdminScreenController(), "FastShopping", 400,
				600);
		primaryStage.show();
	}
	
	// Metodo que serve para abrir a janela do Painel Administrativo
		public static void openShopWindow() {
			openWindow("../Views/ShopScreen.fxml", primaryStage, new ShopScreenController(), "FastShopping", 400,
					600);
			primaryStage.show();
		}
	
	// Metodo que serve para a janela do Proprietario da Loja
	public static void openLojaAddProdutosWindow() {
		openWindow("views/LojaAddProdutos.fxml", primaryStage, new LojaAddProdutosController(), "FastShopping", 926,
				471);
		primaryStage.show();
	}

	// Metodo que serve para abrir a janela do Produtos da Loja
	public static void openComentariosWindow() {
		openWindow("views/LojaComentariosScreen.fxml", primaryStage, new LojaComentariosScreenController(),
				"FastShopping", 926, 471);
		primaryStage.show();
	}

	public static void openProdutosWindow() {
		openWindow("views/LojaProdutos.fxml", primaryStage, new LojaProdutosController(), "FastShopping", 926, 471);
		primaryStage.show();
	}
	
	public static void openSidebarLojaWindow() {
		openWindow("views/SidebarLoja.fxml", primaryStage, new SidebarLojaController(), "FastShopping", 926, 471);
		primaryStage.show();
	}

	public static void openWindow(String viewPath, Stage window, Object controller, String titulo, double width,
			double height) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(viewPath));
			loader.setController(controller);
			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
			window.setTitle(titulo);
			Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
			window.setX((screenBounds.getWidth() - width) / 2);
			window.setY((screenBounds.getHeight() - height) / 2);
			window.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void loadUI(String viewPath, Object controller, BorderPane pane) {
		AnchorPane root = null;
		try {
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(viewPath));
			loader.setController(controller);
			root = loader.load();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		pane.setCenter(root);
	}
	
}
