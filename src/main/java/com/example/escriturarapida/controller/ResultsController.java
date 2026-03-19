package com.example.escriturarapida.controller;

import com.example.escriturarapida.view.Path;
import com.example.escriturarapida.view.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ResultsController {

    @FXML
    private Label scoreLabel;

    @FXML
    private Button playAgainButton;

    @FXML
    private Button exitButton;

    private static int finalScore = 0;

    @FXML
    private void initialize() {
        scoreLabel.setText("Niveles Superados: " + finalScore);
        exitButton.setOnAction(e -> exitGame());
    }

    @FXML
    public void onHandlePlayAgain(ActionEvent event) throws IOException {
        SceneManager.changeScene(Path.EscrituraRapidaGameView);
    }

    @FXML
    public void onHandleGoMenu(ActionEvent event) throws InterruptedException, IOException {
        SceneManager.changeScene(Path.EscrituraRapidaMenuView);
    }

    private void exitGame(){System.exit(0);}

    public static void setScore(int score) {
        finalScore = score;
    }

}
