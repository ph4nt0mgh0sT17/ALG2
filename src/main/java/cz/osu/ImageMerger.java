package cz.osu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ImageMerger {

    /**
     * Path of images.
     */
    private String path;

    /**
     * Path where to copy the images.
     */
    private String destination;

    /**
     * The collection of images.
     */
    private ArrayList<File> images;

    /**
     * Creates a image merger.
     * @param path
     * @param destination
     * @param extensions
     */
    public ImageMerger(String path, String destination, String[] extensions) {
        this.path =path;
        this.destination = destination;
        this.images = new FileManager().getFiles(path, extensions);
        sortImagesByLastModified();
        printImages();
    }

    /**
     * Prints all images to the console output.
     */
    private void printImages() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        for (File image : images) {
            System.out.println(image.getName() + ", " + sdf.format(image.lastModified()));
        }
    }

    /**
     * Sorts files using extended Bubble Sort algorithm.
     */
    private void sortImagesByLastModified() {

        int lastPosition = images.size() - 1;
        boolean isSwap = false;

        do {
            int currentPosition = 0;
            isSwap = false;

            // Checks all files to the last position
            for (int j = 0; j < lastPosition; j++) {

                // Swaps files if there is some last
                if (images.get(j).lastModified() > images.get(j + 1).lastModified()) {

                    swapFiles(j, j+1);
                    currentPosition = j;
                    isSwap = true;
                }
            }

            lastPosition = currentPosition;

            // Checks if last position is not 0 (there are still some values to be checked)
            // and there was swap (if there is no swap than the collection is sorted)
        } while (lastPosition != 0 && isSwap);
    }

    /**
     * Saves (copies) all images to given destination.
     */
    public void saveImages() throws IOException {
        File directory = new File(destination);
        directory.mkdirs();

        int iterationFile = 0;
        for (File file : images) {
            File newFile = new File(destination + "/" + String.valueOf(++iterationFile) + FileManager.getExtension(file));
            Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    /**
     * Swap files (images) in the ArrayList
     * @param j The first index.
     * @param i The second index.
     */
    private void swapFiles(int j, int i) {
        File temp = images.get(j);
        images.set(j, images.get(j+1));
        images.set(j+1, temp);
    }
}
