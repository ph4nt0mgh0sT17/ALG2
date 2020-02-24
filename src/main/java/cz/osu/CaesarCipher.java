package cz.osu;

/**
 * The class for the logic of cesar cipher
 */
public class CaesarCipher implements ICipher {

    /**
     * The offset of the Casar cipher.
     */
    private int offset;

    /**
     * The human alphabet in lower case.
     */
    private String smallAlphabet;

    /**
     * The human alphabet in capital case
     */
    private String capitalAlphabet;

    /**
     * The cesar cipher with default offset
     */
    public CaesarCipher() {
        this.offset = 3;
        this.initializeAlphabet();
    }

    /**
     * The cesar cipher with given offset.
     * @param offset The given offset
     */
    public CaesarCipher(int offset) {
        this();
        this.offset = offset;
    }

    /**
     * Initialize all alphabets.
     */
    private void initializeAlphabet() {
        this.smallAlphabet = "abcdefghijklmnopqrstuvwxyz";
        this.capitalAlphabet =   "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    /**
     * Encode the message.
     * @param message The message to be encoded.
     * @return The encoded message.
     */
    public String encrypt(String message) {

        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {

            // Gets the current symbol of searched char
            char currentSymbol = message.charAt(i);

            // Determines the current alphabet
            String currentAlphabet = determineAlphabet(currentSymbol);

            // Appends the encoded symbol
            encodedMessage.append(encodeSymbol(currentSymbol, currentAlphabet));
        }

        return encodedMessage.toString();
    }

    /**
     * Determines the current alphabet according to the current symbol.
     * @param currentSymbol The current symbol.
     * @return The alphabet.
     */
    private String determineAlphabet(char currentSymbol) {

        // Returns capital alphabet if the current symbol is capital
        if (isSymbolCapital(currentSymbol)) {
            return this.capitalAlphabet;
        }

        // Returns lowercase alphabet if the current symbol is lowercase
        else {
            return this.smallAlphabet;
        }
    }

    /**
     * Encodes current symbol to the encoded symbol.
     * @param currentSymbol The symbol to be encoded.
     * @param currentAlphabet The alphabet of the symbol.
     * @return The encoded symbol.
     */
    private char encodeSymbol(char currentSymbol, String currentAlphabet) {

        // Goes through whole capital alphabet trying to find the symbol
        for (int j = 0; j < currentAlphabet.length(); j++) {

            // If symbol was found we can encode the symbol
            if (currentAlphabet.charAt(j) == currentSymbol) {

                // Gets the encoded index of the symbol
                int encodedIndex = getEncodedIndex(j, currentAlphabet);
                return currentAlphabet.charAt(encodedIndex);
            }
        }

        // Appends the symbol anyway if the symbol was not found
        return currentSymbol;
    }

    /**
     * Decoded the symbol to the normal version.
     * @param currentSymbol The current symbol.
     * @param currentAlphabet The current alphabet.
     * @return The decoded symbol
     */
    private char decodeSymbol(char currentSymbol, String currentAlphabet) {

        // Goes through whole capital alphabet trying to find the symbol
        for (int j = 0; j < currentAlphabet.length(); j++) {

            // If symbol was found we can encode the symbol
            if (currentAlphabet.charAt(j) == currentSymbol) {

                // Gets the decoded index of the symbol
                int decodedIndex = getDecodedIndex(j, currentAlphabet);
                return currentAlphabet.charAt(decodedIndex);

            }
        }

        // Appends the symbol anyway if the symbol was not found
        return currentSymbol;
    }

    /**
     * Validates the encoded index.
     * @param encodedIndex The encoded index.
     * @param currentAlphabet The current alphabet.
     * @return The encoded index.
     */
    private int validateEncodedIndex(int encodedIndex, String currentAlphabet) {
        if (encodedIndex >= currentAlphabet.length()) {
            return encodedIndex - currentAlphabet.length();
        }

        return encodedIndex;
    }

    /**
     * Validates the decoded index.
     * @param decodedIndex The index of the decoded symbol.
     * @param currentAlphabet The current alphabet.
     * @return The decoded index.
     */
    private int validateDecodedIndex(int decodedIndex, String currentAlphabet) {
        if (decodedIndex < 0) {
            return decodedIndex + currentAlphabet.length();
        }

        return decodedIndex;
    }

    /**
     * Gets the index of encoded symbol.
     * @param index The index of current symbol.
     * @return The index of the encoded symbol.
     */
    private int getEncodedIndex(int index, String currentAlphabet) {
        return validateEncodedIndex(index + offset, currentAlphabet);
    }

    /**
     * Gets the index of decoded symbol.
     * @param index The index of current symbol.
     * @return The index of the decoded symbol.
     */
    private int getDecodedIndex(int index, String currentAlphabet) {
        return validateDecodedIndex(index - offset, currentAlphabet);
    }

    /**
     * Determines whether the symbol is capital or not.
     * @param symbol The symbol to be determined.
     */
    private boolean isSymbolCapital(char symbol) {
        return (int)symbol >= 65 && symbol <= 90;
    }

    /**
     * Decode encoded message to the normal version.
     * @param encodedMessage The encoded message.
     * @return The decoded message.
     */
    public String decrypt(String encodedMessage) {
        StringBuilder decodedMessage = new StringBuilder();

        for (int i = 0; i < encodedMessage.length(); i++) {

            // Gets the current symbol of searched char
            char currentSymbol = encodedMessage.charAt(i);

            // Gets the current alphabet
            String currentAlphabet = determineAlphabet(currentSymbol);

            // Appends the encoded symbol
            decodedMessage.append(decodeSymbol(currentSymbol, currentAlphabet));
        }

        return decodedMessage.toString();
    }
}
