package frogger.controller;

import frogger.model.World;
import frogger.view.Info;
import frogger.view.Level1;
import frogger.view.Start;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;


public class SceneController extends World {

    private HashMap<String, Pane> sceneHashMap;
    private Pane currentPane = null;
    private Stage primaryStage;
    static final int WORLD_WIDTH = 600;
    static final int WORLD_HEIGHT = 800;

    public SceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        sceneHashMap = new HashMap<>();
        addScreen();
    }

    public void start() {
        changeScene("start");
    }

    private void addScreen() {
        sceneHashMap.put("start", new Start());
        sceneHashMap.put("info", new Info());
        sceneHashMap.put("Level1", new Level1());
    }

    public void changeScene(String sceneName) {
        if(currentPane != null && currentPane instanceof World) {
            ((World) currentPane).stop();
        }
        currentPane = sceneHashMap.get(sceneName);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(currentPane, WORLD_WIDTH, WORLD_HEIGHT));
        primaryStage.show();
        if(currentPane != null && currentPane instanceof World) {
            ((World) currentPane).start();
        }
    }

    public Pane getCurrentPane() {
        return currentPane;
    }

    @Override
    public void act(long now) {

    }
}
