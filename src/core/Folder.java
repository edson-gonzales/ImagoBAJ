package core;

import java.util.*;
import java.io.File;

/**
 * This class create a list of images according a path.
 *
 * @autor Bruno Vasquez
 */
public class Folder {

    private ArrayList<File> files;

    /**
     * It is the constructor  to create an list of image.
     */
    public Folder() {
        files = new ArrayList<>();
    }

    /**
     * Returns the size of a Image list.
     *
     * @return size Image List.
     */
    public int sizeFileImage() {
        return files.size();
    }

    /**
     * Returns a list of Duplicate Images.
     *
     * @return a list Image.
     */
    public ArrayList getListImageFiles() {
        return files;
    }

    /**
     * Search of the files in a directory according to a path.
     *
     * @param path an object File to get the files.
     */
    public void listImageDirectory(File path) {
        File[] listOfFiles = path.listFiles();

        for (int position = 0; position < listOfFiles.length; position++) {

            if (listOfFiles[position].isDirectory()) {
                listImageDirectory(listOfFiles[position]);
            } else {
                addFile(listOfFiles[position]);
            }
        }
    }

    /**
     * Setting a list of images.
     *
     * @param file an object Folder to get the image type.
     */
    public void addFile(File file) {
        String name = file.getName();
        if (name.endsWith(".PNG") || name.endsWith(".png") ||
                name.endsWith(".JPG") || name.endsWith(".jpg") ||
                name.endsWith(".BMP") || name.endsWith(".bmp"))
            files.add(file);
    }
}
