package core;

import java.io.File;

/**
 * This interface compare images
 *
 * @autor Bruno Vasquez
 */
public interface CompareStrategy {
    /**
     * Compare a image with other image.
     *
     * @param image The file object to compare.
     * @param input The Object input to compare.
     * @return true if they are duplicates or false if they are not.
     */
    public boolean compare(File image, Object input);
}
