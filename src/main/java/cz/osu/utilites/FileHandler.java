package cz.osu.utilites;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileHandler {

    /**
     * Creates the file with given path
     * @param path The path of the file.
     * @return The state of successful creating the file.
     * @throws IOException Throws the IO exception if there is some problems with access rights or the file itself.
     */
    public static boolean createFile(String path) throws IOException {

        // Gets all directories of the path
        String[] directories = path.split("/");

        // Gets directories except the file that is created
        directories = Arrays.copyOf(directories,directories.length-1);

        // Get directory path
        String directoryPath = String.join("/", directories);

        // creates all directories
        createDirectory(directoryPath);

        // Creates the file
        return new File(path).createNewFile();
    }

    /**
     * Checks if current directory even exists.
     * @param directoryPath The given directory path.
     * @return State of its existence.
     */
    public static boolean directoryExists(String directoryPath) {
        return new File(directoryPath).exists();
    }

    /**
     * Creates directories by given directory path.
     * @param directoryPath The given directory path.
     * @return Returns the state if directories were created or not.
     */
    public static boolean createDirectory(String directoryPath) {
        return new File(directoryPath).mkdirs();
    }
}
