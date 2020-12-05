package frogger.controller;

import frogger.model.*;
import frogger.view.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.util.HashMap;


public class SceneController extends World {
    private static SceneController instance;
    private final HashMap<String, Pane> paneHashMap = new HashMap<>();
    private final HashMap<String, Scene> sceneHashMap = new HashMap<>();
    private String sceneName = null;
    private Pane currentPane = null;
    private final Stage primaryStage;
    private String currentSceneName = "start";
    static final int WORLD_WIDTH = 600;
    static final int WORLD_HEIGHT = 800;
    private MusicPlayer musicPlayer;
    private int endCount = 0;


    public SceneController(Stage primaryStage) {
        try {
            musicPlayer = new MusicPlayer();
        } catch (MalformedURLException err) {
            err.printStackTrace();
        }
        if(instance == null) {
            instance = this;
        } else {
            throw new ExceptionInInitializerError("Multiple construction of singleton class");
        }
        this.primaryStage = primaryStage;
        addScreen();
    }

    public void start() {
        changeScene(currentSceneName);
    }

    private void addScreen() {
        paneHashMap.put("start", new Start());
        paneHashMap.put("info", new Info());
        paneHashMap.put("win", new Win());
        paneHashMap.put("level1", new Level1());
        paneHashMap.put("level2", new Level2());
        paneHashMap.put("level3", new Level3());
        paneHashMap.put("level4", new Level4());
        paneHashMap.put("level5", new Level5());
        paneHashMap.put("level6", new Level6());
        paneHashMap.put("level7", new Level7());
        paneHashMap.put("level8", new Level8());
        paneHashMap.put("level9", new Level9());
        paneHashMap.put("level10", new Level10());

        for(String key : paneHashMap.keySet()) {
            Pane pane = paneHashMap.get(key);
            Scene scene = new Scene(pane, WORLD_WIDTH, WORLD_HEIGHT);
            sceneHashMap.put(key, scene);
        }
    }

    public void touchEnd(Animal animal) {
        endCount++;
        if(endCount < 5) {
            return;
        }
        endCount = 0;
        goNextLevel(animal);
    }

    public void resetEndCount() {
        endCount = 0;
    }

    public void goNextLevel(Animal animal) {
        if(!sceneName.startsWith("level")) {
            changeScene("level1");
            return;
        }
        int idx = Integer.parseInt(String.valueOf(sceneName.charAt(sceneName.length()-1)));
        int score = ScoreBoard.getCurrentScore();
        if(sceneName.equals("level10")) {
            idx = 10;
        }
        ScoreFileAdder.addScore(idx, score);
        if(idx == 10) {
            win();
            return;
        }

        String nextScene = String.format("level%d", idx);
        currentPane = paneHashMap.get(String.format("level%d", idx));
        musicPlayer.stopMusic();
        if(sceneName.startsWith("level")) {
            int currentMaxScore = ScoreFileAdder.getMaxScore(idx);
            int nextMaxScore = ScoreFileAdder.getMaxScore(idx+1);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You Have Won The Stage " + idx + "!");
            alert.setHeaderText("Your Current Score: " + score+ "!");
            alert.setContentText("Current Stage Highest Score: " + currentMaxScore);
            alert.setContentText("Next Stage Highest Score: " + nextMaxScore);
            alert.show();
        }
        changeScene(nextScene);
    }

    public void win() {
        int score = ScoreBoard.getCurrentScore();
        int maxScore = ScoreFileAdder.getMaxScore(10);
        changeScene("win");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("You Have Won The Game!");
        alert.setHeaderText(String.format("Your High Score: %d!", score));
        alert.setContentText("Highest Possible Score: " + maxScore);
        alert.show();
    }

    public void changeScene(String sceneName) {
        this.sceneName = sceneName;
        if(currentPane != null && currentPane instanceof World) {
            ((World) currentPane).stop();
        }
        musicPlayer.stopMusic();
        currentPane = paneHashMap.get(sceneName);
        primaryStage.setResizable(false);
        if(currentPane != null && currentPane instanceof World) {
            ScoreBoard scoreBoard = ((Level) currentPane).getScoreBoard();
            scoreBoard.focus();
            ((World) currentPane).getObjects(Animal.class).get(0).focus();
            ((World) currentPane).start();
        }
        Scene scene = sceneHashMap.get(sceneName);
        primaryStage.setScene(scene);
        primaryStage.show();
        if(sceneName.startsWith("level")) {
            String intString = sceneName.replace("level", "");
            musicPlayer.playMusic();
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

    public String getCurrentSceneName() {
        return currentSceneName;
    }
}
