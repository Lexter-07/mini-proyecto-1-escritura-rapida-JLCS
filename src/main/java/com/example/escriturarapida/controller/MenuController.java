package com.example.escriturarapida.controller;

import com.example.escriturarapida.Main;
import com.example.escriturarapida.view.Path;
import com.example.escriturarapida.view.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button playButton;

    @FXML
    private Button exitButton;


    @FXML
    private void initialize() {
        playButton.setOnAction(e -> goToGame());
        exitButton.setOnAction(e -> exitGame());
    }

    private void goToGame() {
        try {
            SceneManager.changeScene(Path.EscrituraRapidaGameView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exitGame() {
        System.exit(0);
    }

}
