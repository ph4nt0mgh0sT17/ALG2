package cz.osu;

public class Main {
    public static void main(String[] args) {
        System.out.println(getWelcomeText());

        ICipher ICipher = new MorseCipher();

        String encodedMessage = ICipher.encrypt("maminka mele maso!!!!!");
        System.out.println(encodedMessage);

        System.out.println(ICipher.decrypt(encodedMessage));
    }

    /**
     * Gets the welcome text in the console.
     * @return The welcome text
     */
    private static String getWelcomeText() {
        return  "==================== 7ALG2 ====================\n" +
                "|                24. 02. 2020                 |\n" +
                "|                 David Miko                  |\n" +
                "===============================================\n";
    }

}