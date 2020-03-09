package cz.osu;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(getWelcomeText());

        Localizer localizer = new Localizer(Language.ENG);

        localizer.printWords();

        Localizer localizer1 = new Localizer();

        localizer1.printWords();

        MainWindow window = new MainWindow();

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
