package com.example.escriturarapida.model;

/**
 * Defines the contract for managing game levels and progression.
 * .
 * This interface provides methods to handle level advancement,
 * game reset, and time management based on player performance.
 */
public interface ILevels {

    /**
     * Increases the current level of the player.
     * .
     * This method is typically called after a successful action
     * (like typing a word correctly).
     *
     * @return the updated level after increment
     */
    int levelUp();

    /**
     * Resets the game state to its initial values.
     * This includes resetting the level, time, and progress-related variables.
     */
    void resetGame();

    /**
     * Calculates the available time for the current level.
     * .
     * The time may decrease as the player progresses,
     * increasing the difficulty of the game.
     *
     * @return the time (in seconds) allowed for the level
     */
    int timeForLevel();
}
