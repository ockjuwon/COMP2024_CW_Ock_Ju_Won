package frogger.model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class StartButton extends Button{

    public StartButton(String text) {

        setText(text);
        setFont(Font.font("Verdana",23));
        setPrefWidth(190);
        setPrefHeight(49);
        initializeButtonListeners();
    }

    private void setButtonPressedStyle() {
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    private void setButtonReleasedStyle() {
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    private void initializeButtonListeners() {
        setOnMousePressed(new MousePressedHandler());
        setOnMouseReleased(new MouseReleasedHandler());
        setOnMouseExited(new MouseExitedHandler());
    }

    private class MousePressedHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                setButtonPressedStyle();
            }
        }
    }

    private class MouseReleasedHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            if(event.getButton().equals(MouseButton.PRIMARY)) {
                setButtonReleasedStyle();
            }
        }
    }

    private class MouseExitedHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            setEffect(null);
        }
    }
}


