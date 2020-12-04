package frogger.model;

import frogger.view.Level;

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
        DigitPanel.setNumber(n, 550, level);
    }
}
