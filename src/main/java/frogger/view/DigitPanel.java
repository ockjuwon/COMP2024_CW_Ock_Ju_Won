package frogger.view;

import frogger.view.Digit;
import frogger.view.Level;

/**
 * An abstract class which set digits.
 */
public abstract class DigitPanel {
    /**
     * set number of digits.
     * @param n int represents number
     * @param x int represents initial x position
     * @param level Level represents current level
     */
    public static void setNumber(int n, int x, Level level) {
        initPanel(3, x, level);
        int shift = 0;
        while (n > 0) {
            int k = n % 10;
            Digit digit = new Digit(k, 32, x - shift, 20);
            level.add(digit);
            digit.setVisible(true);
            shift += 30;
            n /= 10;
        }
    }

    /**
     * initialize digits.
     * @param k int represents size of digits
     * @param x int represents initial x position
     * @param level Level represents current level
     */
    public static void initPanel(int k, int x, Level level) {
        int shift = 0;
        for (int i=0;i<k;i++) {
            Digit digit = new Digit(0, 32, x - shift, 20);
            level.add(digit);
            digit.setVisible(true);
            shift += 30;
        }
    }
}
