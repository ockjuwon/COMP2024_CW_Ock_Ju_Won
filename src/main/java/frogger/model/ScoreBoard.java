package frogger.model;

import frogger.controller.SceneController;
import frogger.view.Level;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

public class ScoreBoard {
    private static ScoreBoard instance;
    private static int maxScore = 0;
    private Level level;
    public ScoreBoard(Level level) {
        this.level = level;
        if(instance == null) {
            instance = this;
        }
        initializeScoreText();
    }

    public void focus() {
        instance = this;
        update(maxScore);
    }

    private void initializeScoreText() {
        update(maxScore);
    }

    public boolean update(Integer score) {
        if(score < maxScore) {
            return false;
        }
        maxScore = score;
        setNumber(maxScore);
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

    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int k = n % 10;
            Digit digit = new Digit(k, 32, 550 - shift, 20);
            level.add(digit);
            digit.setVisible(true);
            shift += 30;
            n /= 10;
        }
    }
}
