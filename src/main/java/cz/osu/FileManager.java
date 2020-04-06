package cz.osu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileManager {

    /**
     * Gets all file content (lines) from the file.
     * @param fileName A name of the file.
     * @return The collection of all string lines from the file.
     */
    public static ArrayList<String> getFileContent(String fileName) {
        ArrayList<String> lines = new ArrayList<String>();

        // Gets the file
        File file = new File(FileManager.class.getClassLoader().getResource(fileName).getFile());

        // Adds all lines to the collection.
        try {
            lines.addAll(Files.readAllLines(file.toPath()));
        }

        catch (IOException e) {

            e.printStackTrace();
        }

        // Removes the header line
        lines.remove(0);

        return lines;
    }
}
