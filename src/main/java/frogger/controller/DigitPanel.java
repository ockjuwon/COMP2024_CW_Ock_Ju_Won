package frogger.controller;

import frogger.view.Digit;
import frogger.view.Level;

public abstract class DigitPanel {
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
