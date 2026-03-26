package com.example.escriturarapida.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Manages scene transitions within the application.
 * .
 * This class provides utility methods to switch between different JavaFX scenes using FXML files.
 * It centralizes the navigation logic, allowing the application
 * to change views in a consistent and controlled way.
 * .
 * It supports:
 * - Immediate scene changes
 * - Delayed scene transitions (useful for effects or feedback screens)
 */
public class SceneManager {

    /**
     * Primary stage of the application where scenes are displayed.
     */
    private static Stage stage;

    /**
     * Initializes the SceneManager with the main application stage.
     *
     * @param primaryStage is the main window of the JavaFX application
     */
    public SceneManager(Stage primaryStage) {
        stage = primaryStage;
    }

    /**
     * Changes the current scene to the specified FXML view.
     * .
     * This method loads the given FXML file, and creates a new scene,
     * and sets it on the primary stage.
     *
     * @param fxmlFileName the path to the FXML file
     * @throws IOException in case the FXML file cannot be loaded
     */
    public static void changeScene(String fxmlFileName) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(
                com.example.escriturarapida.view.SceneManager.class.getResource(fxmlFileName)
        ));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes the current scene after a specified delay.
     * .
     * This method runs in a separate thread, waits for the given
     * amount of time, and then updates the scene on the JavaFX
     * Application Thread using {@code Platform.runLater()}.
     * .
     * It is useful for showing temporary feedback (correct/incorrect)
     * before transitioning to another view.
     *
     * @param fxmlFileName the path to the FXML file
     * @param delayMillis delay time in milliseconds before changing the scene
     */
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

}
