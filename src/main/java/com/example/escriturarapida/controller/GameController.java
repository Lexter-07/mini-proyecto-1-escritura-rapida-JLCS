package com.example.escriturarapida.controller;

import com.example.escriturarapida.model.Levels;
import com.example.escriturarapida.model.Words;
import com.example.escriturarapida.view.Path;
import com.example.escriturarapida.view.SceneManager;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Controller for the main game view.
 * .
 * This class manages user interaction, game logic, and UI updates.
 * It handles word validation, level progression, time control,
 * and transitions between different game states.
 * .
 * Responsibilities:
 * - Shows words to the player
 * - Validate user input
 * - Manage levels and score
 * - Control countdown timer
 * - Handle game over conditions
 *
 * @autor Jorge Luis Castro Scarpetta - 2517065
 * @version 1.0
 */
public class GameController {

    /**
     * Label used to display feedback (correct/incorrect).
     */
    @FXML
    private Label signLabel;
    /**
     * Label that displays the word the user must type.
     */
    @FXML
    private Label wordLabel;
    /**
     * ID. Input field where the user types the word.
     */
    @FXML
    private TextField wordTextField;
    /**
     * ID. Button used to validate the typed word.
     */
    @FXML
    private Button validateButton;
    /**
     * ID. Button used to exit the game.
     */
    @FXML
    private Button exitGameButton;
    /**
     * Label that shows the remaining time.
     */
    @FXML
    private Label timeLabel;
    /**
     * Label that displays the current level.
     */
    @FXML
    private Label levelLabel;


    /**
     * Handles word generation and validation.
     */
    private Words words;
    /**
     * Handles level progression and difficulty.
     */
    private Levels levels;


    /**
     * Timeline used as a countdown timer.
     */
    private Timeline timeline;
    /**
     * Initial time for the game (in seconds).
     */
    private final int InitialTime = 20;
    /**
     * Remaining time for the current round.
     */
    private int TimeLeft = InitialTime;
    /**
     * Final message displayed when the game ends.
     */
    public String message;

    /**
     * Indicates whether the player has won the game.
     * This variable remains true while the player continues progressing without failing
     * It is set to false when the player makes a mistake or loses the game.
     *
     * It is used to determine the final game outcome (win or loss).
     */
    public boolean isPlayerWinner = true;



    /**
     * Initializes the controller after the FXML is loaded.
     *
     * This method sets up the game state, initializes models,
     * displays the first word, starts the timer, and configures
     * button actions.
     */
    @FXML
    public void initialize() {
        words = new Words();
        levels = new Levels();

        wordLabel.setText(words.generateWord(levels.ActualLevel));
        levels.resetGame();
        startTimer();
        exitGameButton.setOnAction(e -> exitGame());
    }

    /**
     * This method starts the countdown timer.
     * .
     * The timer decreases every second and updates the UI.
     * When time is low, the label turns red.
     * If time runs out, it automatically triggers validation.
     */
    public void startTimer() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            TimeLeft--;
            timeLabel.setText("" + TimeLeft);
            if (TimeLeft <= 5) {
                timeLabel.setTextFill(Color.RED);
            }

            if (TimeLeft <= 0) {
                validateButton.fire();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * This method resets the timer based on the current level difficulty
     * and restores the original color of time.
     * .
     * The available time may decrease as the player progresses.
     */
    public void resetTimer() {
        TimeLeft = levels.timeForLevel();
        timeLabel.setTextFill(Color.web("#eeff00"));
        timeLabel.setText("" + TimeLeft);
    }

    /**
     * This Method shows temporary feedback after validation.
     * .
     * Shows a message (correct/incorrect) for a short duration
     * and then hides it automatically.
     */
    public void transitionValidateWord() {
        signLabel.setVisible(true);
        PauseTransition pausa = new PauseTransition(Duration.seconds(2));

        pausa.setOnFinished(ActionEvent -> {
            signLabel.setVisible(false);
        });
        pausa.play();
    }

    /**
     * Triggered when the user presses ENTER in the text field.
     * .
     * This method simulates a button click for validation.
     *
     * @param event the action event triggered by pressing ENTER
     */
    @FXML
    public void onHandleEnter(ActionEvent event) {
        validateButton.fire();
    }

    /**
     * This method Handles the validation of the typed word.
     * .
     * This triggered when the user submits a word (via button or ENTER).
     * It validates the input and updates the game state accordingly.
     * .
     * Behavior:
     * - If the word is correct:
     *   - Displays success feedback
     *   - Checks if the player has reached the maximum level (45)
     *     - If NOT: increases level, resets timer, and generates a new word
     *     - If YES: stops the game and triggers the win condition
     *
     * - If the word is incorrect or empty:
     *   - Displays error feedback (if applicable)
     *   - Marks the player as having lost
     *   - Stops the game and triggers the end condition
     * .
     * The game ends in two cases:
     * - Player loses (incorrect input or timeout)
     * - Player wins (reaches level 45)
     *
     * @param event the action event triggered by the validate button
     * @throws IOException if the scene transition fails
     */
    @FXML  // Event generated when the button has clicked
    public void onHandleValidate(ActionEvent event) throws IOException {

        String text = wordTextField.getText();

        System.out.println("Validando...");


        if (words.validateWord(text)) {
            signLabel.setText(" CORRECTO ");
            signLabel.setTextFill(Color.web("#00ff4d"));
            transitionValidateWord();


            if (levels.ActualLevel != levels.MAX_LEVEL) {
                levelLabel.setText("NIVEL " + levels.levelUp());
                resetTimer();
                wordTextField.clear();
                wordLabel.setText(words.generateWord(levels.ActualLevel));
            } else {
                timeline.stop();
                messageFinal();
                finishGame();
            }

        } else {
            if (!text.isEmpty()) {
                signLabel.setText(" INCORRECTO ");
                signLabel.setTextFill(Color.RED);
                transitionValidateWord();
                isPlayerWinner = false;
            } else if (text.isEmpty()) {isPlayerWinner = false;}

            timeline.stop();
            messageFinal();
            finishGame();
        }

    }

    /**
     * This method Determines the final message displayed at the end of the game.
     * .
     * evaluates the game state and assigns a message based on the outcome:
     *
     * - Victory: The player reaches the maximum level (45) and has not failed
     * - Time out: The player runs out of time
     * - Incorrect input: The player fails to type the correct word
     * .
     * The result is stored in the {@code message} variable, which is later
     * displayed in the results screen.
     */
    void messageFinal(){
        if (levels.ActualLevel >= levels.MAX_LEVEL && isPlayerWinner) {
            message = "Llegaste al nivel Máximo";
        } else if (TimeLeft <= 0) {
            message = "¡El tiempo se agotó! :(";
        } else {
            message = "Has fallado la palabra";
        }
    }

    /**
     * This Method ends the game and transitions to the results screen.
     * .
     * This method is responsible for passing the final game data to the
     * results controller, including:
     * - Whether the player won or lost
     * - The final score (levels completed)
     * - The final message describing the outcome
     *
     * After setting this data, it triggers a scene change to the results view
     * with a short delay, allowing any final UI feedback to be displayed.
     */
    public void finishGame() {
        ResultsController.isPlayerWinner = isPlayerWinner;
        ResultsController.setScore(levels.score);
        ResultsController.setMessageFinal(message);
        SceneManager.changeSceneWithDelay(Path.EscrituraRapidaResultsView, 750);
    }

    /**
     * This method handles the reset action triggered by the user.
     * .
     * Resets game state, clears input, and returns to the main menu.
     *
     * @param event the action event triggered by the reset button
     * @throws IOException if scene transition fails
     */
    @FXML
    public void onHandleReset(ActionEvent event) throws IOException {
        levels.resetGame();
        resetTimer();
        timeline.stop();
        wordTextField.clear();
        levelLabel.setText("NIVEL " + levels.ActualLevel);

        SceneManager.changeScene(Path.EscrituraRapidaMenuView);

    }

    /**
     * Closes the application.
     */
    private void exitGame(){System.exit(0);}

}


