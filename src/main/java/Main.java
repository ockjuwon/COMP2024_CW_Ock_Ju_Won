import frogger.controller.SceneController;
import frogger.view.Start;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	private SceneController sceneController;


	/**
	 * starts SceneController.
	 * @param primaryStage given stage.
	 */
	@Override
	public void start(Stage primaryStage) {
		sceneController = new SceneController(primaryStage);
		sceneController.start();
	}

	/**
	 * Entrypoint of program.
	 * launches application.
	 * @param args program's arguments.
	 */
	public static void main(String[] args) {
		launch(args);
	}


}
