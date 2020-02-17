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

    /**
     * Creates a directory with given pathname.
     * @param pathname The pathname of directory.
     * @return The success of the creation.
     */
    public boolean createDirectory(String pathname) {
        return new File(pathname).mkdir();
    }

    /**
     * Creates a directory with given pathname. If there are a few parent directories that do not exist then they will be created too.
     * @param pathname The pathname of directory.
     * @return The success of the creation.
     */
    public boolean createDirectories(String pathname) {
        return new File(pathname).mkdirs();
    }
}
