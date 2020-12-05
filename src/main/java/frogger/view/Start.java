package frogger.view;

import frogger.controller.SceneController;
import javafx.application.Platform;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Start extends Pane {

    private static final int MENU_BUTTONS_START_X = 100;
    private static final int MENU_BUTTONS_START_Y = 150;
    private SceneController sceneController;

    // define list to store these buttons
    List<StartButton> menuButtons;

    public Start() {
        sceneController = SceneController.getInstance();

        menuButtons = new ArrayList<>();

        createStartButton();
        createInfoButton();
        createExitButton();

    }

    private void addMenuButton(StartButton button) {
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
        menuButtons.add(button);
        getChildren().add(button);
    }


    private void createStartButton() {
        StartButton startButton = new StartButton("PLAY");
        addMenuButton(startButton);
        startButton.setOnAction((event) -> {
            sceneController.changeScene("level1");
        });
    }

    private void createInfoButton() {
        StartButton infoButton = new StartButton("INFO");
        addMenuButton(infoButton);
        infoButton.setOnAction((event) -> {
            sceneController.changeScene("info");
        });
    }

    private void createExitButton() {
        StartButton exitButton = new StartButton("EXIT");
        addMenuButton(exitButton);
        exitButton.setOnAction((event) -> {
            Platform.exit();
        });
    }
}
