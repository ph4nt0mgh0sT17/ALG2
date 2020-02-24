package cz.osu;

import java.util.ArrayList;

public class MorseCipher implements Cipher {

    /**
     * The alphabet of the human language.
     */
    private String[] humanAlphabet;

    /**
     * The alphabet founded by Morse.
     */
    private String[] morseAlphabet;

    /**
     * Initializes the morse cipher so the cipher can encrypt and decrypt text.
     */
    public MorseCipher() {
        initializeAlphabets();
    }

    /**
     * Initializes both human and morse alphabets.
     */
    private void initializeAlphabets() {
        humanAlphabet = new String[] {
                "a","b","c","d","e","f","g","h","i",
                "j","k","l","m","n","o","p","q",
                "r","s","t","u","v","w","x","y","z"
        };

        morseAlphabet = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--.","....",
                "..",".---","-.-",".-..","--","-.","---",".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.."
        };
    }

    /**
     * Encrypts the given text to the morse cipher.
     * @param message The message to be encrypted.
     * @return The encrypted message
     */
    @Override
    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {

            // Gets current symbol from the message to operate with it
            String currentSymbol = String.valueOf(message.charAt(i));

            encryptedMessage.append(getEncryptedSymbol(currentSymbol));
        }

        return encryptedMessage.toString();
    }

    private String getEncryptedSymbol(String currentSymbol) {

        // Searches through whole human alphabet if there is some symbol from the alphabet
        for (int j = 0; j < humanAlphabet.length; j++) {

            // Return equivalent morse symbol if the symbol was found
            if (currentSymbol.equals(humanAlphabet[j])) {
                return morseAlphabet[j] + "/";
            }
        }

        // If symbol was not found in the alphabet we can return the symbol as it is
        return currentSymbol + "/";

    }

    @Override
    public String decrypt(String encodedMessage) {
        StringBuilder decryptedMessage = new StringBuilder();

        // Gets all morse symbols from the encoded message
        String[] morseSymbols = encodedMessage.split("/");

        // Gets decrypted message
        decryptedMessage.append(decryptMessage(morseSymbols));

        return decryptedMessage.toString();
    }

    private String decryptMessage(String[] morseSymbols) {

        StringBuilder decryptedMessage = new StringBuilder();

        // Translates all morse symbols into our alphabet
        for (String currentMorseSymbol : morseSymbols) {

            // Adds currentMorseSymbol to the decrypted message if the current morse symbol is not morse symbol
            if (!(currentMorseSymbol.contains(".") || currentMorseSymbol.contains("-"))) {
                decryptedMessage.append(currentMorseSymbol);
            }

            // Tries to find the morse symbol in the alphabet and translate it
            for (int j = 0; j < morseAlphabet.length; j++) {
                if (currentMorseSymbol.equals(morseAlphabet[j])) {
                    decryptedMessage.append(humanAlphabet[j]);
                }
            }
        }

        return decryptedMessage.toString();
    }
}
