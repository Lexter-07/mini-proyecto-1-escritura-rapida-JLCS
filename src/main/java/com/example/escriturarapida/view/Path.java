package com.example.escriturarapida.view;

/**
 * Utility class that stores the paths to all FXML views used in the application.
 * .
 * This class centralizes the location of UI resources, making it easier
 * to manage and update scene paths without hardcoding them throughout
 * the project.
 * .
 * Each constant represents a specific view of the typing game:
 * - Game view
 * - Main menu view
 * - Results view
 */

public class Path {

    /**
     * Path to the main game view where the typing activity takes place.
     */
    public static final String EscrituraRapidaGameView = "/com/example/escriturarapida/game-view.fxml";

    /**
     * Path to the main menu view where the user starts the game.
     */
    public static final String EscrituraRapidaMenuView = "/com/example/escriturarapida/startGame-view.fxml";

    /**
     * Path to the results view displaying the user's performance.
     */
    public static final String EscrituraRapidaResultsView = "/com/example/escriturarapida/resultsGame-view.fxml";
}
