package cz.osu;

import java.util.Random;

/**
 * The class for the Transposition Cipher logic.
 */
public class TranspositionCipher implements Cipher {
    private int key;

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
        char temp;

        for (int i = 0; i < encryptedMessage.length(); i++) {
            index = random.nextInt(encryptedMessage.length());

            // Swap chars in the String
            swapCharacters(encryptedMessage, i, index);
        }

        return encryptedMessage.toString();
    }

    private void swapCharacters(StringBuilder text, int firstIndex, int secondIndex) {
        char temp = text.charAt(firstIndex);
        text.setCharAt(firstIndex, text.charAt(secondIndex));
        text.setCharAt(secondIndex, temp);
    }

    public String decrypt(String encryptedMessage) {
        StringBuilder decryptedMessage = new StringBuilder(encryptedMessage);

        int[] indexes = getIndexes(decryptedMessage);
        decryptMessage(decryptedMessage, indexes);

        return decryptedMessage.toString();
    }

    private void decryptMessage(StringBuilder decryptedMessage, int[] indexes) {
        for (int i = decryptedMessage.length() - 1; i >= 0 ; i--) {
            swapCharacters(decryptedMessage, i, indexes[i]);
        }
    }

    private int[] getIndexes(StringBuilder decryptedMessage) {
        int[] indexes = new int[decryptedMessage.length()];

        Random random = new Random(key);
        for (int i = 0; i < decryptedMessage.length(); i++) {
            indexes[i] = random.nextInt(decryptedMessage.length());
        }

        return indexes;
    }

}
