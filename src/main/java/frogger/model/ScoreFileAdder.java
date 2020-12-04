package frogger.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public abstract class ScoreFileAdder {
    private static final String filename = "scores.txt";

    public static void addScore(int score) {
        FileOutputStream out = null;

        try {
            File file = new File(filename);
            file.createNewFile();
        } catch (IOException e) { }

        try {
            Files.write(Paths.get(filename), String.valueOf(score).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
