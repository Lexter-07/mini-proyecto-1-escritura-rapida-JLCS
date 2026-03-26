package com.example.escriturarapida.controller;

import com.example.escriturarapida.view.Path;
import com.example.escriturarapida.view.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;


/**
 * Controller for the main menu view.
 *
 * This class handles user interactions in the menu screen,
 * allowing the player to start the game or exit the application.
 */
public class MenuController {

    /**
     * Button used to start the game.
     */
    @FXML
    private Button playButton;

    /**
     * Button used to start the game.
     */
    @FXML
    private Button exitButton;

    /**
     * Initializes the menu controller.
     *
     * This method assigns actions to the menu buttons.
     */
    @FXML
    private void initialize() {
        playButton.setOnAction(e -> goToGame());
        exitButton.setOnAction(e -> exitGame());
    }

    /**
     * This Method navigates to the main game view.
     * Loads the game scene using the 'SceneManager'.
     */
    private void goToGame() {
        try {
            SceneManager.changeScene(Path.EscrituraRapidaGameView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes the application.
     */
    private void exitGame() {
        System.exit(0);
    }

}
