package frogger.view;

import frogger.controller.SceneController;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class Start extends Pane {

    private static final int sceneWidth = 600;
    private static final int sceneHeight = 800;
    private static final String IMAGE = "file:src/main/resources/startBackground.png";
    private static final int MENU_BUTTONS_START_X = 205;
    private static final int MENU_BUTTONS_START_Y = 250;
    
    BackgroundImage startImage = new BackgroundImage(new Image(IMAGE, sceneWidth, sceneHeight, false, true),
            BackgroundRepeat.NO_REPEAT, null, BackgroundPosition.DEFAULT, null);

    private SceneController sceneController;

    // define list to store these buttons
    List<StartButton> menuButtons;

    public Start() {
        sceneController = SceneController.getInstance();
        menuButtons = new ArrayList<>();
        setBackground(new Background(startImage));
        createLogo();
        createFrogImage();
        createStartButton();
        createInfoButton();
        createExitButton();

    }
    
        private void createLogo() {
        ImageView logo = new ImageView("file:src/main/resources/froggerLogo.png");
        logo.setFitHeight(200);
        logo.setFitWidth(500);
        logo.setLayoutX(50);
        logo.setLayoutY(30);
        getChildren().add(logo);
    }

    private void createFrogImage() {
        ImageView frogImage = new ImageView("file:src/main/resources/froggerImage.png");
        frogImage.setFitHeight(200);
        frogImage.setFitWidth(500);
        frogImage.setLayoutX(50);
        frogImage.setLayoutY(550);
        getChildren().add(frogImage);
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
