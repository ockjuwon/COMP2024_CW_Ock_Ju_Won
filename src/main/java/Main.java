import frogger.model.MyStage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	static final int WORLD_WIDTH = 600;
	static final int WORLD_HEIGHT = 800;

	MyStage container = new MyStage();

	@Override
	public void start(Stage primaryStage) throws Exception {

		//stage > scene > container > node

		Scene scene = new Scene(container, WORLD_WIDTH, WORLD_HEIGHT);

		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
		// test


	}

	public static void main(String[] args) {
		launch(args);
	}


}
