package cz.osu;

public class Main {
    public static void main(String[] args) {
        System.out.println(getWelcomeText());

        System.out.println("Type your name: ");
        String playerName = new Scanner(System.in).nextLine();

        Hangman hangmanGame = new Hangman(playerName);
        hangmanGame.startGame();
    }

    /**
     * Gets the welcome text in the console.
     * @return The welcome text
     */
    private static String getWelcomeText() {
        return "==================== 7ALG2 ====================\n" +
               "|                17. 02. 2020                 |\n" +
               "|                 David Miko                  |\n" +
               "===============================================\n";
    }

}
