package cz.osu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileManager {

    public static ArrayList<String> getFileContent(String fileName) {

        File file = new File(FileManager.class.getClassLoader().getResource(fileName).getFile());


        ArrayList<String> lines = new ArrayList<>();

        try {
            lines.addAll(Files.readAllLines(file.toPath()));
        }

        catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        // Removes the head
        lines.remove(0);

        return lines;
    }
}
