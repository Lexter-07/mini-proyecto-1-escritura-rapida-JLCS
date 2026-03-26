package com.example.escriturarapida.controller;

import com.example.escriturarapida.view.Path;
import com.example.escriturarapida.view.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.io.IOException;


/**
 * Controller for the results view.
 *
 * This class is responsible for displaying the player's final score
 * and a message after the game ends. It also provides options to
 * restart the game, return to the main menu, or exit the application.
 */
public class ResultsController {

    /**
     * Label that displays the final score (levels completed).
     */
    @FXML
    private Label scoreLabel;
    /**
     * Label that displays the final message (motive of lose).
     */
    @FXML
    private Label messageLabel;
    /**
     * Button used to exit the application.
     */
    @FXML
    private Button exitButton;

    /**
     * Final message passed from the game controller.
     */
    private static String messageFinal;
    /**
     * Final score achieved by the player.
     */
    private static int finalScore = 0;


    /**
     * Initializes the results screen.
     *
     * This method sets the final score and message,
     * and configures button actions.
     */
    @FXML
    private void initialize() {
        scoreLabel.setText("Niveles Superados: " + finalScore);
        messageLabel.setText(messageFinal);
        exitButton.setOnAction(e -> exitGame());
    }

    /**
     * This method allows starts a new game.
     *
     * @param event the action event triggered by the button
     * @throws IOException if the scene cannot be loaded
     */
    @FXML
    public void onHandlePlayAgain(ActionEvent event) throws IOException {
        SceneManager.changeScene(Path.EscrituraRapidaGameView);
    }

    /**
     * This method allows returns to the main menu.
     *
     * @param event the action event triggered by the button
     * @throws IOException if the scene cannot be loaded
     */
    @FXML
    public void onHandleGoMenu(ActionEvent event) throws IOException {
        SceneManager.changeScene(Path.EscrituraRapidaMenuView);
    }

    /**
     * Sets the final message to be displayed on the results screen.
     *
     * @param message the message to display
     */
    public static void setMessageFinal(String message){
        messageFinal = message;
    }

    /**
     * Sets the final score to be displayed.
     *
     * @param score the player's final score
     */
    public static void setScore(int score) {
        finalScore = score;
    }

    /**
     * Closes the app.
     */
    private void exitGame(){System.exit(0);}

}
