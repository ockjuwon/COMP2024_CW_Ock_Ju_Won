import frogger.controller.SceneController;
import frogger.view.Start;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	private SceneController sceneController;


	@Override
	public void start(Stage primaryStage) {
		sceneController = new SceneController(primaryStage);
		sceneController.start();
	}

	public static void main(String[] args) {
		launch(args);
	}


}
