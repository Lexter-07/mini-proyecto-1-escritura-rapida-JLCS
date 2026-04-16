package com.example.escriturarapida;

import com.example.escriturarapida.view.Path;
import com.example.escriturarapida.view.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Entry point of the Typing Speed Game application.
 * .
 * This class initializes the JavaFX application and sets up
 * the primary stage. It is responsible for launching the UI,
 * initializing the {@link SceneManager}, and loading the main menu scene.
 * .
 * The application allows users to practice and improve their typing speed
 * through a minigame with progressive difficulty and an interactive graphical interface.
 * .
 * MiniProject1: Fast Typing Game
 *
 * @author Jorge Luis Castro Scarpetta - 2517065
 * @version 1.0
 * @since 2026
 */

public class Main extends Application {

    /**
     * Main application window (primary stage).
     */
    public static Stage stageWindow;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes and starts the main application window.
     * .
     * This method is automatically called by the JavaFX runtime.
     * It sets up the scene manager, loads the main menu view,
     * configures the window title, and defines the behavior when closing the app.
     *
     * @param primaryStage the primary stage provided by JavaFX
     * @throws IOException if the scene resources cannot be loaded
     */
    @Override
    public void start(Stage primaryStage) throws IOException {

        new SceneManager(primaryStage);

        SceneManager.changeScene(Path.EscrituraRapidaMenuView);
        primaryStage.setTitle("Escritura Rápida");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
    }

}
