package frogger.model;

import frogger.controller.SceneController;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;

public class ScoreBoard {
    private static ScoreBoard instance;
    private TextField scoreText;
    public ScoreBoard(ObservableList<Node> children) {
        if(instance == null) {
            instance = this;
        }
        initializeScoreText();
        children.add(scoreText);
    }

    private void initializeScoreText() {
        scoreText = new TextField();
        scoreText.setText("0");
        scoreText.setStyle("-fx-font: 40 arial; -fx-text-inner-color: white;");
        scoreText.setLayoutX(500);
        scoreText.setLayoutY(20);
        scoreText.setBackground(Background.EMPTY);
        scoreText.setDisable(true);
    }

    public void update(Integer score) {
        scoreText.setText(score.toString());
    }

    public static ScoreBoard getInstance() {
        if(instance == null) {
            throw new NullPointerException("Instance is not initialized");
        }
        return instance;
    }
}
