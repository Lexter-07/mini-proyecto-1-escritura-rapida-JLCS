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
     * Label displayed when the player loses the game.
     *
     * This label shows a "Game Over" message and is visible
     * only when the player fails.
     */
    @FXML
    private Label gameOverLabel;
    /**
     * Label displayed when the player wins the game.
     *
     * This label shows a victory message and is visible
     * only when the player successfully completes the game.
     */
    @FXML
    private Label winTitleLabel;

    /**
     * Button used to exit the application.
     */
    @FXML
    private Button exitButton;


    /**
     * Indicates whether the player has won the game.
     */
    public static boolean isPlayerWinner;
    /**
     * Final message passed from the game controller.
     */
    private static String messageFinal;
    /**
     * Final score achieved by the player.
     */
    private static int finalScore = 0;



    /**
     * Initializes the results view after the FXML file is loaded.
     * .
     * This method sets up the UI elements with the final game data:
     * - Displays the appropriate title (win or game over)
     * - Shows the final score (levels completed)
     * - Displays the final message based on the game outcome
     * - Assigns the action to the exit button.
     *
     * It is automatically called by the JavaFX framework.
     */
    @FXML
    private void initialize() {
        setEndGameTitle(isPlayerWinner);
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
     * Updates the result screen title based on the game outcome.
     * .
     * This method controls the visibility of the title labels:
     * - If the player wins, the "win" title is displayed
     * - If the player loses, the "game over" title is displayed.
     *
     * It ensures that only one title is visible at a time.
     *
     * @param isPlayerWinner true if the player has won the game,
     * false if the player has lost
     */
    public void setEndGameTitle(boolean isPlayerWinner){
        if (isPlayerWinner) {
            winTitleLabel.setVisible(true);
            gameOverLabel.setVisible(false);
        } else {
            winTitleLabel.setVisible(false);
            gameOverLabel.setVisible(true);
        }
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
