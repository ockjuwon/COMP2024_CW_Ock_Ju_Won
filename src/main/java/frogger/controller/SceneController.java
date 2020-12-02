package frogger.controller;

import frogger.model.World;
import frogger.view.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;


public class SceneController extends World {
    private static SceneController instance;
    private final HashMap<String, Pane> sceneHashMap;
    private String sceneName = null;
    private Pane currentPane = null;
    private final Stage primaryStage;
    static final int WORLD_WIDTH = 600;
    static final int WORLD_HEIGHT = 800;

    public SceneController(Stage primaryStage) {
        if(instance == null) {
            instance = this;
        } else {
            throw new ExceptionInInitializerError("Multiple construction of singleton class");
        }
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
        sceneHashMap.put("level1", new Level1());
        sceneHashMap.put("level2", new Level2());
        sceneHashMap.put("level3", new Level3());
        sceneHashMap.put("level4", new Level4());
        sceneHashMap.put("level5", new Level5());
        sceneHashMap.put("level6", new Level6());
        sceneHashMap.put("level7", new Level7());
        sceneHashMap.put("level8", new Level8());
        sceneHashMap.put("level9", new Level9());
        sceneHashMap.put("level10", new Level10());
    }

    public void nextLevel() {
        if(!sceneName.startsWith("level")) {
            changeScene("level1");
            return;
        }
        int idx = Integer.parseInt(String.valueOf(sceneName.charAt(sceneName.length()-1)));
        if(idx == 0) {
            return;
        }
        idx++;
        String nextScene = String.format("level%d", idx);
        changeScene(nextScene);
    }

    public void changeScene(String sceneName) {
        this.sceneName = sceneName;
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

    public static SceneController getInstance() {
        if(instance == null) {
            throw new NullPointerException("Instance is not initialized");
        }
        return instance;
    }
}
