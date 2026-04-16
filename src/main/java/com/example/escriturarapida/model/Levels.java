package com.example.escriturarapida.model;


/**
 * Implements the game level system and progression logic.
 * .
 * This class manages the player's current level, score, and difficulty scaling.
 * The difficulty increases by reducing the available time as the player
 * achieves consecutive successes.
 * .
 * Game mechanics:
 * - The player levels up after each correct input
 * - Score increases alongside the level
 * - After a certain number of successes, the available time decreases
 *
 *
 */
public class Levels implements ILevels {

    /**
     * Current level of the player.
     */
    public int ActualLevel = 1;
    /**
     * This constant indicates the maximum level that the player can reach in the game.
     */
    public final int MAX_LEVEL = 45;
    /**
     * Player score based on correct words
     */
    public int score = 0;
    /**
     * Base time (in seconds) available per level.
     */
    private int baseTime = 20;
    /**
     * Counter of consecutive correct words for difficulty progression.
     */
    private int successes = 0;


    /**
     * This method increases the player's level and updates progress variable (score).
     * .
     * Each successful action increases the level and score.
     * Also, it tracks consecutive successes to adjust difficulty (time).
     *
     * @return the updated level
     */
    @Override
    public int levelUp() {
        ActualLevel += 1;
        score += 1;
        if (successes < 5) {
            successes += 1;
        } else {
            successes = 0;
        }

        return ActualLevel;
    }

    /**
     * This method resets the game to its initial state.
     * restores the starting level, time, and success counter. */
    @Override
    public void resetGame() {
        ActualLevel = 1;
        baseTime = 20;
        successes = 0;

    }

    /**
     * This method determines the time available for the current level.
     * .
     * If the player reaches a streak of 5 successes:
     * the available time is reduced to increase difficulty.
     *
     * @return the time (in seconds) for the level
     */
    @Override
    public int timeForLevel(){
        if (successes == 5){
            baseTime -= 2;
            successes = 0;
        }
        return baseTime;
    }

}