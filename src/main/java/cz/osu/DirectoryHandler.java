package cz.osu;

import java.io.File;

public class DirectoryHandler {

    /**
     * Checks if a directory with given pathname exists.
     * @param pathname The pathname of the directory.
     * @return The state of it's existing.
     */
    public boolean fileExists(String pathname) {
        return new File(pathname).exists();
    }

    public boolean createDirectory(String pathname) {
        return new File(pathname).mkdir();
    }

    public boolean createDirectories(String pathname) {
        return new File(pathname).mkdirs();
    }
}
