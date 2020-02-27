package cz.osu;

/**
 * The basic interface for all ciphers.
 */
public interface Cipher {

    /**
     * Basic method for encrypting.
     * @param message The message to be encrypted.
     * @return The encrypted message.
     */
    String encrypt(String message);

    /**
     * Basic method for decrypting.
     * @param encodedMessage The encoded message to be decrypted.
     * @return The decrypted message.
     */
    String decrypt(String encodedMessage);
}
