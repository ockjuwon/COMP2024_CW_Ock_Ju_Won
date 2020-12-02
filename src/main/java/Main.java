import frogger.controller.SceneController;
import frogger.view.Start;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private Start start;
	private SceneController sceneController;


	@Override
	public void start(Stage primaryStage) throws Exception {
		sceneController = new SceneController(primaryStage);
		sceneController.start();
	}

	public static void main(String[] args) {
		launch(args);
	}


}
