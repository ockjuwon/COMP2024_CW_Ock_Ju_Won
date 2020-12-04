package frogger.model;

import frogger.view.Level;

public class ScoreBoard {
    private static ScoreBoard instance;
    private static int currentScore = 0;
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
        update(currentScore);
    }

    private void initializeScoreText() {
        update(currentScore);
    }

    public boolean update(Integer score) {
        currentScore = score;
        setNumber(currentScore);
        return true;
    }

    public static ScoreBoard getInstance() {
        if(instance == null) {
            throw new NullPointerException("Instance is not initialized");
        }
        return instance;
    }

    public static int getCurrentScore() {
        return currentScore;
    }

    public static void getMaxScore(int maxScore) {
        ScoreBoard.currentScore = maxScore;
    }

    private void setNumber(int n) {
        DigitPanel.setNumber(n, 550, level);
    }
}
