package tools;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class create a image with other heigth and width.
 *
 * @autor Bruno Vasquez
 */
public class ResizeImage {

    private File imageFile;
    private int newWidth;
    private int newHeigth;

    /**
     * It is the constructor to create a new heigth and width for the image.
     *
     * @param newHeigth an int to set the new heigth
     * @param newWidth  an String to set the new width
     * @param imageFile an Object file
     */
    public ResizeImage(File imageFile, int newWidth, int newHeigth) {
        this.imageFile = imageFile;
        this.newWidth = newWidth;
        this.newHeigth = newHeigth;
    }

    /**
     * Create an image with new size.
     *
     * @param directoryDestiny an object File that contain the directory destiny
     */
    public void resizeImage(File directoryDestiny) {
        try {

            BufferedImage originalImage = ImageIO.read(imageFile);
            int type = originalImage.getType() == 0 ?
                    BufferedImage.TYPE_INT_ARGB : originalImage.getType();

            String[] imageName = imageFile.getName().split("\\.");

            BufferedImage resizeImageJpg = resizeImage(originalImage, type);
            ImageIO.write(resizeImageJpg, imageName[imageName.length - 1],
                    new File(directoryDestiny + "/" + imageFile.getName()));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Sets a new width and heigth to a buffer image.
     *
     * @param originalImage an object File that contain the directory destiny
     * @param type          an integer that sets the type of resize
     * @return an object Buffered Image with a new width and heigth
     */
    private BufferedImage resizeImage(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeigth, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newWidth, newHeigth, null);
        g.dispose();

        return resizedImage;
    }


}