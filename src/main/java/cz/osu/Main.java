package cz.osu;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Main {

    /**
     * The main entry of the console application.
     * @param args Arguments that can be passed by command-line.
     */
    public static void main(String[] args) throws IOException {
        System.out.println(getWelcomeText());

        FileManager fileManager = new FileManager();

        String[] extensions = new String[] {"PNG", "png", "jpg"};

        ImageMerger imageMerger = new ImageMerger("resources", "destination", extensions);

        imageMerger.saveImages();

        System.out.println(convertToAMPM("12:54"));

        System.out.println(convertToOurTime("3:43 AM"));
    }

    /**
     * Converts our given time to the AM/PM time format.
     * @param time The given time format.
     * @return The time in AM/PM time format.
     */
    private static String convertToAMPM(String time) {
        String[] times = time.split(":");

        int hours = Integer.parseInt(times[0]);
        int minutes = Integer.parseInt(times[1]);

        if ( (hours - 12) < 0 ) {
            return hours + ":" + minutes + " AM";
        }

        else {
            if (hours == 12) {
                return hours + ":" + minutes + " PM";
            }
            return hours-12 + ":" + minutes + " PM";
        }
    }

    /**
     * Converts the time in the AM/PM format to our 24hours format.
     * @param time The given time in AM/PM format.
     * @return The time in 24 hours format.
     */
    private static String convertToOurTime(String time) {

        boolean isPM = false;


        if (time.contains("PM")) {
            isPM = true;
        }

        String[] times = time.split(":");

        times[1] = times[1].substring(0,2);

        int hours = Integer.parseInt(times[0]);
        int minutes = Integer.parseInt(times[1]);



        if (!isPM) {
            if (hours == 12) {
                hours = 0;
            }
            return hours + ":" + minutes;
        }

        else {
            return hours+12 + ":" + minutes;
        }
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