package frogger.view;

/**
 * A view class which represents score.
 */
public class ScoreBoard {
    private static ScoreBoard instance;
    private static int currentScore = 0;
    private Level level;


    /**
     * Constructs ScoreBoard.
     * @param level Level class.
     */
    public ScoreBoard(Level level) {
        this.level = level;
        if(instance == null) {
            instance = this;
        }
        initializeScoreText();
    }

    /**
     * make singleton references this object.
     */
    public void focus() {
        instance = this;
        update(currentScore);
    }

    private void initializeScoreText() {
        update(currentScore);
    }


    /**
     * updates score.
     * show current score.
     * @param score score to be updated,
     * @return true
     */
    public boolean update(Integer score) {
        currentScore = score;
        setNumber(currentScore);
        return true;
    }

    /**
     * returns Instance which is focused.
     * @return instance
     */
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
