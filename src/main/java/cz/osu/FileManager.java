package cz.osu;

import java.io.File;
import java.util.ArrayList;

public class FileManager {

    /**
     * Collection of files that are accessed.
     */
    private ArrayList<File> files;

    /**
     * Creates a file manager.
     */
    public FileManager() {
        this.files = new ArrayList<>();
    }

    /**
     * Clears the list before every access to the files
     */
    private void clearList() {
        this.files = new ArrayList<>();
    }

    /**
     * Gets all files in given path
     * @param path The pathname where are files and directories
     * @return The ArrayList of all files in the pathname.
     */
    public ArrayList<File> getFiles(String path) {

        clearList();

        File rootDirectory = new File(path);

        getFiles(rootDirectory);

        return files;
    }

    /**
     * Recursively look for all files in given directory/file.
     * @param rootDirectory The searched directory.
     */
    private void getFiles(File rootDirectory) {
        for (File file : rootDirectory.listFiles()) {

            // If file is directory open the directory
            if (file.isDirectory()) {
                getFiles(file);
            }

            // If file is not directory then add it to the array list
            else if (file.isFile()) {
                files.add(file);
            }
        }
    }

    /**
     * Gets all files in given path with given extensions
     * @param path The pathname where are files and directories
     * @param extensions Extensions that are allowed
     * @return The ArrayList of all files in the pathname.
     */
    public ArrayList<File> getFiles(String path, String[] extensions) {

        clearList();

        File rootDirectory = new File(path);

        getFiles(rootDirectory, extensions);

        return files;
    }

    /**
     * Recursively look for all files in given directory/file.
     * @param rootDirectory The searched directory.
     * @param extensions The extensions that are allowed
     */
    private void getFiles(File rootDirectory, String[] extensions) {
        for (File file : rootDirectory.listFiles()) {

            // If file is directory open the directory
            if (file.isDirectory()) {
                getFiles(file, extensions);
            }

            // If file is not directory then add it to the array list
            else if (file.isFile() && fileHasExtension(file, extensions)) {
                files.add(file);
            }
        }
    }

    /**
     * Checks if current file has given extension.
     * @param currentFile The current file.
     * @param extensions All extensions that can be used.
     * @return The state if the file has given extensions.
     */
    private boolean fileHasExtension(File currentFile, String[] extensions) {
        for (String extension : extensions) {
            String fileName = currentFile.getName();

            // Returns true if the filename has the given extension
            if (fileName.endsWith(extension)) {
                return true;
            }
        }

        // Extensions did not match
        return false;
    }

    /**
     * Gets the file list of all files.
     * @return The ArrayList<File>.
     */
    public ArrayList<File> getFileList() {
        return this.files;
    }

    public static String getExtension(File file) {
        String fileName = file.getName();
        int charIndex = fileName.lastIndexOf(".");
        return fileName.substring(charIndex, fileName.length());
    }
}
