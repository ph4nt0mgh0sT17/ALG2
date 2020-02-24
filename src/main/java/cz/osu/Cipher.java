package cz.osu;

public interface Cipher {
    String encrypt(String message);
    String decrypt(String encodedMessage);
}
