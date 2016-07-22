package core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class compare images for pixel.
 *
 * @autor Bruno Vasquez
 */
public class ComparePixel implements CompareStrategy {

    private int widthImageSource;
    private int heightImageSource;
    private int widthImageToCompare;
    private int heightImageToCompare;

    private BufferedImage imageSource;
    private BufferedImage imageToCompare;

    /**
     * Compare a image with other image for pixel.
     *
     * @param imageOfTheList The file object to compare.
     * @param input          The Object input to compare.
     * @return true if they are duplicates or false if they are not.
     */
    @Override
    public boolean compare(File imageOfTheList, Object input) {
        String pathString = (String) input;
        File imageInput = new File(pathString);

        try {
            if (compareWidthAndHeight(imageOfTheList, imageInput))
                return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Compare a image with other image for width and height.
     *
     * @param imageOfTheList the file object of the list to compare.
     * @param imageInput     the File object of input to compare.
     * @return true if they are duplicates or false if they are not.
     */
    private boolean compareWidthAndHeight(File imageOfTheList, File imageInput) throws IOException {
        imageSource = ImageIO.read(imageOfTheList);
        widthImageSource = imageSource.getWidth();
        heightImageSource = imageSource.getHeight();

        imageToCompare = ImageIO.read(imageInput);
        widthImageToCompare = imageToCompare.getWidth();
        heightImageToCompare = imageToCompare.getHeight();

        if (widthImageSource == widthImageToCompare && heightImageSource == heightImageToCompare) {
            return compareTwoImageByHeight();
        }
        return false;
    }

    /**
     * Compare images by Height of the image.
     *
     * @return true if they are duplicates or false if they are not.
     */
    private boolean compareTwoImageByHeight() {
        for (int pixelY = 0; pixelY < heightImageSource; pixelY++) {
            if (compareTwoImageByWidth(pixelY)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compare images by Width of the image.
     *
     * @param pixelY the number that indicates the position on the Y axis.
     * @return true if they are duplicates or false if they are not.
     */
    private boolean compareTwoImageByWidth(int pixelY) {
        for (int pixelX = 0; pixelX < widthImageSource; pixelX++) {
            int colorImageSource = imageSource.getRGB(pixelX, pixelY);
            int colorImageToCompare = imageToCompare.getRGB(pixelX, pixelY);
            if (colorImageSource == colorImageToCompare) {
                return true;
            }
        }
        return false;
    }
}