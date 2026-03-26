package com.example.escriturarapida.model;

/**
 * Defines the contract for word management in the game.
 * .
 * This interface specifies the methods required for generating
 * words based on difficulty level and validating user input.
 * .
 * Any class that implements this interface must provide logic
 * for word selection and correctness validation.
 */
public interface IWords {

    /**
     * Generates a word according to the current difficulty level.
     *
     * @param ActualLevel the current level of the player
     * @return a word that the user must type
     */
    String generateWord(int ActualLevel);

    /**
     * Validates if the given word matches the expected word.
     *
     * @param word the word entered by the user
     * @return 'true' if the word is correct, 'false' otherwise
     */
    Boolean validateWord(String word);

}