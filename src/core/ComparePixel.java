package core;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class compare images for pixel.
 *
 * @autor Bruno Vasquez
 */
public class ComparePixel implements CompareStrategy {

    private int widthImageOne;
    private int heightImageOne;
    private int widthImageTwo;
    private int heightImageTwo;

    private BufferedImage imageImagoOne;
    private BufferedImage imageImagoTwo;

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
        imageImagoOne = ImageIO.read(imageOfTheList);
        widthImageOne = imageImagoOne.getWidth();
        heightImageOne = imageImagoOne.getHeight();

        imageImagoTwo = ImageIO.read(imageInput);
        widthImageTwo = imageImagoTwo.getWidth();
        heightImageTwo = imageImagoTwo.getHeight();

        if (widthImageOne == widthImageTwo && heightImageOne == heightImageTwo) {
            return compareTwoImagePixelY();
        }
        return false;
    }

    /**
     * It moves through the image pixels on the Y axis.
     *
     * @return true if they are duplicates or false if they are not.
     */
    private boolean compareTwoImagePixelY() {
        for (int pixelY = 0; pixelY < heightImageOne; pixelY++) {
            if (compareTwoImagePixelX(pixelY)) {
                return true;
            }
        }
        return false;
    }

    /**
     * It moves through the image pixels on the X axis.
     *
     * @param pixelY the number that indicates the position on the Y axis.
     * @return true if they are duplicates or false if they are not.
     */
    private boolean compareTwoImagePixelX(int pixelY) {
        for (int pixelX = 0; pixelX < widthImageOne; pixelX++) {
            Color colorImageOne = new Color(imageImagoOne.getRGB(pixelX, pixelY));
            Color colorImageTwo = new Color(imageImagoTwo.getRGB(pixelX, pixelY));
            if (compareTwoColor(colorImageOne, colorImageTwo)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Compare a image with other image for color.
     *
     * @param colorImageOne the Color object of the list to compare.
     * @param colorImageTwo the Color object of input to compare.
     * @return true if they are duplicates or false if they are not.
     */
    private boolean compareTwoColor(Color colorImageOne, Color colorImageTwo) {
        if (colorImageOne.equals(colorImageTwo)) {
            return true;
        }
        return false;
    }
}