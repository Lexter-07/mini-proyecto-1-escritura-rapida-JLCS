package com.example.escriturarapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneManager {

    private static Stage stage;

    public SceneManager(Stage primaryStage) {
        stage = primaryStage;
    }

    public static void changeScene(String fxmlFileName) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(
                com.example.escriturarapida.view.SceneManager.class.getResource(fxmlFileName)
        ));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void changeSceneWithDelay(String fxmlFileName, int delayMillis) {
        new Thread(() -> {
            try {
                Thread.sleep(delayMillis);

                javafx.application.Platform.runLater(() -> {
                    try {
                        Parent newRoot = FXMLLoader.load(Objects.requireNonNull(
                                SceneManager.class.getResource(fxmlFileName)
                        ));
                        Scene newScene = new Scene(newRoot);
                        stage.setScene(newScene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public static Stage getStage() {
        return stage;
    }



}
