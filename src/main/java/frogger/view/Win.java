package frogger.view;

import frogger.controller.SceneController;
import frogger.model.StartButton;
import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class Win extends Pane {

    private TextField winField;

    private static final int MENU_BUTTONS_START_X = 100;
    private static final int MENU_BUTTONS_START_Y = 150;
    private SceneController sceneController;

    // define list to store these buttons
    List<StartButton> menuButtons;

    public Win() {
        sceneController = SceneController.getInstance();

        menuButtons = new ArrayList<>();

        addYouWinField();
        createMainMenuButton();

    }

    private void addYouWinField() {
        winField = new TextField();
        winField.setText("You Win!");
        winField.setStyle("-fx-font: 40 arial");
        winField.setLayoutX(40);
        winField.setLayoutY(30);
        winField.setBackground(Background.EMPTY);
        winField.setDisable(true);
        getChildren().add(winField);
    }

    private void addMenuButton(StartButton button) {
        button.setLayoutX(MENU_BUTTONS_START_X);
        button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
        menuButtons.add(button);
        getChildren().add(button);
    }


    private void createMainMenuButton() {
        StartButton startButton = new StartButton("MAIN");
        addMenuButton(startButton);
        startButton.setOnAction((event) -> {
            sceneController.changeScene("start");
        });
    }
}