package frogger.model;

import frogger.view.Level;

public abstract class DigitPanel {
    public static void setNumber(int n, int x, Level level) {
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
