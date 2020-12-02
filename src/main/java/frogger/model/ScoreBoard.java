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
    private static int maxScore = 0;
    public ScoreBoard(ObservableList<Node> children) {
        initializeScoreText();
        children.add(scoreText);
    }

    public void focus() {
        instance = this;
        update(maxScore);
    }

    private void initializeScoreText() {
        scoreText = new TextField();
        update(maxScore);
        scoreText.setStyle("-fx-font: 40 arial; -fx-text-inner-color: white;");
        scoreText.setLayoutX(500);
        scoreText.setLayoutY(20);
        scoreText.setBackground(Background.EMPTY);
        scoreText.setDisable(true);
    }

    public boolean update(Integer score) {
        if(score < maxScore) {
            return false;
        }
        maxScore = score;
        scoreText.setText(score.toString());
        return true;
    }

    public static ScoreBoard getInstance() {
        if(instance == null) {
            throw new NullPointerException("Instance is not initialized");
        }
        return instance;
    }

    public static int getMaxScore() {
        return maxScore;
    }

    public static void getMaxScore(int maxScore) {
        ScoreBoard.maxScore = maxScore;
    }
}
