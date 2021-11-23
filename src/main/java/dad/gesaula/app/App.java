package dad.gesaula.app;

import dad.gesaula.controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	MainController controller;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller = new MainController();
		
		Scene scene = new Scene(controller.getView(), 600, 520);
		
		primaryStage.setTitle("GesAula");
		primaryStage.setScene(scene);
		primaryStage.getIcons().addAll(new Image("/images/app-icon-64x64.png"));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
