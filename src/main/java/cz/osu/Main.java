package cz.osu;

public class Main {

    /**
     * The main entry of the console application.
     * @param args Arguments that can be passed by command-line.
     */
    public static void main(String[] args) {
        System.out.println(getWelcomeText());
    }

    /**
     * Gets the welcome text in the console.
     * @return The welcome text
     */
    private static String getWelcomeText() {
        return  "==================== 7ALG2 ====================\n" +
                "|                02. 03. 2020                 |\n" +
                "|                 David Miko                  |\n" +
                "===============================================\n";
    }
}
