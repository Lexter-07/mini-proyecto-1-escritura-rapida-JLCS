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

    @FXML  // Label ID si la palabra fue correctamente escrita o no
    private Label signLabel;

    @FXML  // Label ID Palabra que debe ser escrita
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
    private int InitialTime = 10;
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
        TimeLeft = InitialTime;
        timeLabel.setTextFill(Color.web("#00e5ff"));
        timeLabel.setText("" + TimeLeft);
    }

    @FXML  // Event generado al dar enter en el textField
    public void onHandleEnter(ActionEvent event) throws InterruptedException {
        validateButton.fire();
    }


    @FXML  // Event generado al dar click en el boton
    public void onHandleValidate(ActionEvent event) throws InterruptedException {

        String text = wordTextField.getText();

        System.out.println("Validando...");
        if (words.validateWord(text)){
            signLabel.setText(" CORRECTO ");
            signLabel.setVisible(true);
            PauseTransition pausa = new PauseTransition(Duration.seconds(2));

            pausa.setOnFinished(ActionEvent -> {signLabel.setVisible(false);});
            pausa.play();

        } else {
            signLabel.setText("X INCORRECTO X");
            signLabel.setVisible(true);
            PauseTransition pausa = new PauseTransition(Duration.seconds(2));

            pausa.setOnFinished(ActionEvent -> {signLabel.setVisible(false);});
            pausa.play();
        }

        resetTimer();
        wordTextField.clear();


        levelLabel.setText("NIVEL " + levels.levelUp());
        wordLabel.setText(words.generateWord());

    }
}

