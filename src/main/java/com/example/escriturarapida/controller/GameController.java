package com.example.escriturarapida.controller;

import com.example.escriturarapida.model.ILevels;
import com.example.escriturarapida.model.IWord;
import com.example.escriturarapida.model.Levels;
import com.example.escriturarapida.model.Words;
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


public class GameController {

    @FXML  // Label ID check if the word was spelled correctly or not
    private Label signLabel;

    @FXML  // Label ID Word that must be written
    private Label wordLabel;

    @FXML  // ID textField
    private TextField wordTextField;

    @FXML  // ID Button
    private Button validateButton;

    @FXML  //ID timeLabel
    private Label timeLabel;

    @FXML  //ID NivelLabel;
    private Label levelLabel;

    private Words words;
    private Levels levels;

    private Timeline timeline;
    private final int InitialTime = 20;
    private int TimeLeft = InitialTime;


    @FXML
    public void initialize(){
        words = new Words();
        levels = new Levels();

        wordLabel.setText(words.generateWord());
        startTimer();
    }

    public void startTimer(){
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            TimeLeft--;timeLabel.setText("" + TimeLeft);
            if (TimeLeft <=5){
                timeLabel.setTextFill(Color.RED);
            }

            if (TimeLeft <= 0) {
                //timeline.stop();
                validateButton.fire();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void resetTimer(){
        TimeLeft = levels.timeForLevel();
        timeLabel.setTextFill(Color.web("#00e5ff"));
        timeLabel.setText("" + TimeLeft);
    }

    @FXML  // Event generated when enter is pressed in text field
    public void onHandleEnter(ActionEvent event) throws InterruptedException {
        validateButton.fire();
    }


    @FXML  // Event generated when the button has clicked
    public void onHandleValidate(ActionEvent event) throws InterruptedException {

        String text = wordTextField.getText();

        System.out.println("Validando...");
        if (words.validateWord(text)){
            signLabel.setText(" CORRECTO ");
            signLabel.setTextFill(Color.web("#00ff4d"));
            signLabel.setVisible(true);
            PauseTransition pausa = new PauseTransition(Duration.seconds(2));

            pausa.setOnFinished(ActionEvent -> {signLabel.setVisible(false);});
            pausa.play();
            levelLabel.setText("NIVEL " + levels.levelUp());

        } else {
            signLabel.setText("X INCORRECTO X");
            signLabel.setTextFill(Color.RED);
            signLabel.setVisible(true);
            PauseTransition pausa = new PauseTransition(Duration.seconds(2));

            pausa.setOnFinished(ActionEvent -> {signLabel.setVisible(false);});
            pausa.play();
            levels.resetGame();
            levelLabel.setText("Nivel "+ levels.ActualLevel);

        }

        resetTimer();
        wordTextField.clear();

        wordLabel.setText(words.generateWord());

    }
}

