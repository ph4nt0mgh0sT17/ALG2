package cz.osu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileManager {

    public static String getFileContent(String fileName) {
        File file;

        try {
            file = new File(FileManager.class.getClassLoader().getResource(fileName).getFile());
        }

        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        try {
            return Files.readAllLines(file.toPath()).get(0);
        }

        catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
}
