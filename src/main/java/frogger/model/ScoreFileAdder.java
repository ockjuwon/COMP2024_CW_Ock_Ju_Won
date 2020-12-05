package frogger.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public abstract class ScoreFileAdder {
    private static final String filename = "highscore.txt";

    public static void addScore(int stage, int score) {
        String format = "%d:%d\n";
        String formatted = String.format(format, stage, score);

        try {
            File file = new File(filename);
            file.createNewFile();
        } catch (IOException e) { }

        try {
            Files.write(Paths.get(filename), formatted.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getMaxScore(int stage) {
        int maxScore = 0;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] splited = data.split(":");
                if(Integer.parseInt(splited[0]) != stage) {
                    continue;
                }
                int candidate = Integer.parseInt(splited[1]);
                maxScore = Math.max(maxScore, candidate);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return maxScore;
    }
}
