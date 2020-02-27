package cz.osu;

import java.util.Random;

/**
 * The class for the Transposition cipher logic.
 */
public class TranspositionCipher implements Cipher {

    /**
     * The key of the transposition cipher.
     */
    private int key;

    /**
     * Constructs the cipher with given key.
     * @param key The key of the cipher.
     */
    public TranspositionCipher(int key) {
        this.key = key;
    }

    /**
     * Encodes given message to the encoded state.
     * @param message The message to be encrypted.
     * @return The encrypted message.
     */
    public String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder(message);

        // Random with given seed (key)
        Random random = new Random(key);

        int index;

        for (int i = 0; i < encryptedMessage.length(); i++) {

            // Get the random index where to swap the characters
            index = random.nextInt(encryptedMessage.length());

            // Swap chars in the String
            swapCharacters(encryptedMessage, i, index);
        }

        return encryptedMessage.toString();
    }

    /**
     * Swap the characters in given {@link StringBuilder} by given {@code firstIndex} and {@code secondIndex}.
     * @param text The {@link StringBuilder} to be swapped characters.
     * @param firstIndex The first index of the {@link Character} in the {@link StringBuilder}.
     * @param secondIndex The second index of the {@link Character} in the {@link StringBuilder}.
     */
    private void swapCharacters(StringBuilder text, int firstIndex, int secondIndex) {
        char temp = text.charAt(firstIndex);
        text.setCharAt(firstIndex, text.charAt(secondIndex));
        text.setCharAt(secondIndex, temp);
    }

    /**
     * Decrypts the encrypted message.
     * @param encryptedMessage The message to be decrypted.
     * @return The decrypted message.
     */
    public String decrypt(String encryptedMessage) {
        StringBuilder decryptedMessage = new StringBuilder(encryptedMessage);

        // Gets indexes used to encrypt the message
        int[] indexes = getIndexes(decryptedMessage);

        // Decrypts the message using the indexes
        decryptMessage(decryptedMessage, indexes);

        return decryptedMessage.toString();
    }

    /**
     * Decrypts the message using indexes.
     * @param decryptedMessage The decrypted message where to swap characters.
     * @param indexes The indexes of swap.
     */
    private void decryptMessage(StringBuilder decryptedMessage, int[] indexes) {
        for (int i = decryptedMessage.length() - 1; i >= 0 ; i--) {
            swapCharacters(decryptedMessage, i, indexes[i]);
        }
    }

    /**
     * Gets indexes of the encryption.
     * @param decryptedMessage The decrypted message where to swap characters.
     * @return The indexes of swap.
     */
    private int[] getIndexes(StringBuilder decryptedMessage) {
        int[] indexes = new int[decryptedMessage.length()];

        Random random = new Random(key);
        for (int i = 0; i < decryptedMessage.length(); i++) {
            indexes[i] = random.nextInt(decryptedMessage.length());
        }

        return indexes;
    }

}
