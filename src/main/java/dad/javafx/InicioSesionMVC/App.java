package dad.javafx.InicioSesionMVC;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private InicioSesionController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		controller = new InicioSesionController();

		Scene scene = new Scene(controller.getView(), 320, 200);

		Stage stage = new Stage();
		stage.setTitle("InicioSesionMVC");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
