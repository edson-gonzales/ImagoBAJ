package core;

import java.io.File;

/**
 * This class compare images for size.
 *
 * @autor Bruno Vasquez
 */
public class CompareSize implements CompareStrategy {
    /**
     * Compare a image with other image for size.
     *
     * @param image The file object to compare.
     * @param input The Object input to compare.
     * @return true if they are duplicates or false if they are not.
     */
    @Override
    public boolean compare(File image, Object input) {
        long sizeLong = image.length();
        Long inputLong = Long.parseLong(input.toString());

        if (sizeLong == inputLong) {
            return true;
        }
        return false;
     }
}
