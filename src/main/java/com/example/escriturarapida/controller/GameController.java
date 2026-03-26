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
     *
     * The available time may decrease as the player progresses.
     */
    public void resetTimer() {
        TimeLeft = levels.timeForLevel();
        timeLabel.setTextFill(Color.web("#eeff00"));
        timeLabel.setText("" + TimeLeft);
    }

    /**
     * This Method shows temporary feedback after validation.
     *
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
     *
     * This method simulates a button click for validation.
     *
     * @param event the action event triggered by pressing ENTER
     */
    @FXML
    public void onHandleEnter(ActionEvent event) {
        validateButton.fire();
    }

    /**
     * This method handles the validation of the typed word.
     *
     * If the word is correct:
     * - Displays success feedback
     * - Increases level and score
     * - Resets timer
     * - Generates a new word
     *
     * If the word is incorrect:
     * - Displays error feedback
     * - Stops the timer
     * - Ends the game
     *
     * @param event the action event triggered by the button
     * @throws IOException if scene transition fails
     */
    @FXML  // Event generated when the button has clicked
    public void onHandleValidate(ActionEvent event) throws IOException {

        String text = wordTextField.getText();

        System.out.println("Validando...");
        if (words.validateWord(text)) {
            signLabel.setText(" CORRECTO ");
            signLabel.setTextFill(Color.web("#00ff4d"));
            transitionValidateWord();

            levelLabel.setText("NIVEL " + levels.levelUp());
            resetTimer();
            wordTextField.clear();
            wordLabel.setText(words.generateWord(levels.ActualLevel));

        } else {
            if (!text.isEmpty()) {
                signLabel.setText(" INCORRECTO ");
                signLabel.setTextFill(Color.RED);
                transitionValidateWord();
            }
            timeline.stop();
            MessageFail();
            finishGame();
        }
    }

    /**
     * Determines the final message shown when the player loses.
     *
     * The message depends on whether the failure was due to
     * time running out or incorrect input.
     */
    void MessageFail(){
        if (TimeLeft <= 0) {
            message = "¡El tiempo se agotó! :(";
        } else {
            message = "Has fallado la palabra";
        }
    }

    /**
     * This Method ends the game and transitions to the results screen.
     *
     * Sends the final score and message to the controller results.
     */
    public void finishGame() {
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


