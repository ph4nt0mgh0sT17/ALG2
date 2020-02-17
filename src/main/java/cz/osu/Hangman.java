package cz.osu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The hangman game
 */
public class Hangman {

    /**
     * Current player of the Hagman game.
     */
    private Player currentPlayer;

    /**
     * Current guessed word by player.
     */
    private String currentWord;

    /**
     * Already guessed characters by a Player.
     */
    private ArrayList<Character> guessedCharacters;

    /**
     * Scanner for scanning player's input.
     */
    Scanner scanner;

    /**
     * Constant words
     */
    private ArrayList<String> hangmanWords;

    /**
     * Creates a Hangman game with given player name.
     * @param playerName The name of the player.
     */
    public Hangman(String playerName) {
        createPlayer(playerName);

        scanner = new Scanner(System.in);
        guessedCharacters = new ArrayList<>();

        // Generates the words list
        generateWords();

        // Generates a new random word from words list
        generateNewWord();
    }

    /**
     * Generates all words that the game can pick.
     * TODO: Should implement with reading from file.
     */
    private void generateWords() {
        hangmanWords = new ArrayList<>();
        hangmanWords.add("Radar");
        hangmanWords.add("Martin");
        hangmanWords.add("Lukas");
    }

    /**
     * Generates random word
     */
    private void generateNewWord() {
        Random random = new Random();
        currentWord = hangmanWords.get(random.nextInt(hangmanWords.size()));
    }

    /**
     * Starts the game; The whole logic.
     */
    public void startGame() {

        // When the word is not guessed and player is still alive
        while(isGameOn()) {

            // Process the current round of guessing
            processRound();
        }

        // When the player is alive after guessing word it means he guessed the word
        if (currentPlayer.isAlive()) {
            System.out.println("You have guessed the word " + currentWord);
            System.out.println("You have won!");
        }

        // Player has no lives and didn't guess the word
        else {
            System.out.println("Sorry, you lost all your lives.");
        }

        System.out.println(currentPlayer);

    }

    /**
     * Process the round of Hangman game.
     * User types the character and game checks if it's correct.
     */
    private void processRound() {

        // Prints current state of the word and asks for player's input
        System.out.println(getCurrentResult());
        System.out.println("Type your character: ");

        // Player writes his guess
        String input = scanner.nextLine();

        // Checks if the input is only 1 character
        if (input.length() > 1) {
            System.out.println("You have to type only 1 character!");
            return;
        }

        // Player input gets converted to character variable
        char playerInput = input.charAt(0);

        // Process current guessed character
        processCharacter(playerInput);
    }

    /**
     * Process the guessed character.
     * @param playerInput The character by player.
     */
    private void processCharacter(char playerInput) {

        // Guessed character is in the word
        if (wordContainsCharacter(playerInput)) {

            // Process the correct character
            processCorrectCharacter(playerInput);
        }

        // Guessed character is not found in the word
        else {

            // Process the wrong character
            processWrongCharacter();
        }
    }

    /**
     * Checks if character is in the word
     * @param playerInput The player guessed character.
     * @return The state if the character is present.
     */
    private boolean wordContainsCharacter(char playerInput) {

        // Converts the word to lower case so it gets all types of chars
        String lowerCaseWord = currentWord.toLowerCase();

        return lowerCaseWord.contains(String.valueOf(playerInput).toLowerCase());
    }

    /**
     * Process the wrong character -> decrements life of player.
     */
    private void processWrongCharacter() {

        // Decrements the life because of wrong guess and inform the player
        currentPlayer.decrementLife();
        System.out.println("Wrong character!");
    }

    /**
     * Process the correct character
     * @param correctInput The character by user.
     */
    private void processCorrectCharacter(char correctInput) {

        // Player's input character was already guessed
        if (isCharacterAlreadyGuessed(correctInput)) {
            System.out.println("You have already guessed this character.");
        }

        // The guessed character wasn't yet guessed
        else {
            char lowerCaseCharacter = convertCharacterToLowerCase(correctInput);
            guessedCharacters.add(lowerCaseCharacter);
        }
    }

    /**
     * Converts given character to lower case.
     * @param character The given character.
     * @return The character in lower case.
     */
    private char convertCharacterToLowerCase(char character) {
        // Converts the character to String so it can be converted into LowerCase
        String characterString = String.valueOf(character).toLowerCase();

        // Returns the character in LowerCase
        return characterString.charAt(0);
    }

    /**
     * Checks if the guessed character is already in guessed characters
     * @param guessedCharacter The given guessed character.
     * @return The state if it's present.
     */
    private boolean isCharacterAlreadyGuessed(char guessedCharacter) {
        return guessedCharacters.contains(guessedCharacter);
    }

    /**
     * Checks if the hangman game should still continue.
     * @return State if the game should be still continued.
     */
    public boolean isGameOn() {
        return ((currentPlayer.isAlive()) && (!isWordGuessed()));
    }

    /**
     * Removes all whitespaces in given String.
     * @param text The given String.
     * @return Result String without all whitespaces.
     */
    private String removeWhitespaces(String text) {
        String currentResult = "";

        // Goes through whole String and records only characters that are not whitespaces
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                currentResult += text.charAt(i);
            }
        }

        return currentResult;
    }

    /**
     * Checks if the word is already guessed.
     * @return The state if the word is guessed.
     */
    public boolean isWordGuessed() {

        // Removes all whitespaces from current result because it generates whitespaces between characters
        String currentResult = removeWhitespaces(getCurrentResult());

        // Checks if current result is the same as current word
        return currentResult.equals(currentWord);
    }

    /**
     * Gets the current result within guessed characters
     * @return
     */
    private String getCurrentResult() {
        StringBuilder currentResult = new StringBuilder();

        // Goes through whole current word
        for (int i = 0; i < currentWord.length(); i++) {

            // Checks if there is some guessed character that is in the current word
            // Than adds it to the current result
            if (guessedCharacters.contains(currentWord.toLowerCase().charAt(i)))
                currentResult
                        .append(currentWord.charAt(i))
                        .append(" ");

            // If there is no guessed character in current index then adds only hidden character
            else
                currentResult.append("_ ");
        }

        return currentResult.toString();
    }

    /**
     * Creates a player with given player name and 3 lives.
     * @param playerName The name of the current player.
     */
    private void createPlayer(String playerName) {
        currentPlayer = new Player(playerName, 3);
    }
}
