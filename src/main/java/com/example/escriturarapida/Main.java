package com.example.escriturarapida;

import com.example.escriturarapida.view.Path;
import com.example.escriturarapida.view.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static Main main;
    public static Stage stageWindow;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        new SceneManager(primaryStage);

        SceneManager.changeScene(Path.EscrituraRapidaMenuView);
        primaryStage.setTitle("Escritura Rápida");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
    }

}
