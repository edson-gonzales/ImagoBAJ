package core;

import java.io.File;

/**
 * This class compare images for name.
 *
 * @autor Bruno Vasquez
 */
public class CompareName implements CompareStrategy {
    /**
     * Compare a image with other image for name.
     *
     * @param image The file object to compare.
     * @param input The Object input to compare.
     * @return true if they are duplicates or false if they are not.
     */
    @Override
    public boolean compare(File image, Object input) {
        String name = image.getName();
        if (name.equals((String) input)) {
            return true;
        } else {
            return false;
        }
    }

}