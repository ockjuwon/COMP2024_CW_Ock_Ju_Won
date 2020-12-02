import frogger.model.MyStage;
import frogger.view.Start;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	static final int WORLD_WIDTH = 600;
	static final int WORLD_HEIGHT = 800;
	Start start;

	@Override
	public void start(Stage primaryStage) throws Exception {

		start = new Start();
		Scene scene = new Scene(start, WORLD_WIDTH, WORLD_HEIGHT);

		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}


}
