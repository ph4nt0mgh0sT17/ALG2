package cz.osu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class that handles operation with files
 */
public class FileManager {

    /**
     * Gets the array list of lines from the given file
     * @param fileName The name of the file to be read.
     * @return The array list of the lines. If there was some problem the array list is found whether empty or filled with some values.
     */
    public static ArrayList<String> fileFromResources(String fileName) {
        ArrayList<String> lines = new ArrayList<>();

        // Gets the file from the resource file
        File file = new File(Objects.requireNonNull(FileManager.class.getClassLoader().getResource(fileName)).getFile());

        // Tries to add all lines in the file to the array list
        try {
            lines.addAll(Files.readAllLines(file.toPath()));
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return lines;

    }
}
