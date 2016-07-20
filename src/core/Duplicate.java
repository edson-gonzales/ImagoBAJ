package core;

import java.io.File;
import java.util.ArrayList;
import java.util.*;

/**
 * This class create a list of images duplicates.
 *
 * @autor Bruno Vasquez
 */
public class Duplicate {
    private ArrayList<File> duplicateImage;
    private ArrayList<File> listImage;

    private String strategy;
    private Object imageInput;


    /**
     * It is the constructor to create an list of image duplicate.
     *
     * @param strategy   an String to set the type strategy of search
     * @param imageInput an Object to sets the image to compare
     */
    public Duplicate(String strategy, Object imageInput) {
        this.strategy = strategy;
        this.imageInput = imageInput;
        duplicateImage = new ArrayList<>();
    }

    /**
     * Setting a list of duplicate images
     *
     * @param folder an object Folder to get the Image list.
     */
    public void searchDuplicate(Folder folder) {
        HashMap<String, CompareStrategy> strategyAvailable = new HashMap<String, CompareStrategy>();
        strategyAvailable.put("Name", new CompareName());
        strategyAvailable.put("Size", new CompareSize());

        CompareStrategy strategyUsed = strategyAvailable.get(strategy);
        listImage = folder.getListImageFiles();

        for (File image : listImage) {
            if (strategyUsed.compare(image, imageInput))
                duplicateImage.add(image);
        }
    }

    /**
     * Returns the size of a Image Duplicate list.
     *
     * @return size Image duplicate List .
     */
    public int sizeImage() {
        return duplicateImage.size();
    }

    /**
     * Returns a list of duplicate images.
     *
     * @return a list Image.
     */
    public ArrayList getListDuplicate() {
        return duplicateImage;
    }
}
