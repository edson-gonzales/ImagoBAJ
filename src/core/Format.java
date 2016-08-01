package core;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * This class export a image with other format.
 *
 * @autor Bruno Vasquez
 */
public class Format {
    private String format;
    private File fileImage;

    /**
     * It is the constructor to create a new format for the image.
     *
     * @param formatImage   an String to set the new format
     * @param fileImage an Object file
     */
    public Format(String formatImage, File fileImage) {
        this.format = formatImage;
        this.fileImage = fileImage;
    }

    /**
     * Create an image with new format.
     *
     * @param pathExport an String to sets the path to export
     * @param nameExport an String to sets the name to export
     */
    public void fileImageWithNewFormat(String pathExport, String nameExport) {
        try {
            BufferedImage bufferRead = ImageIO.read(fileImage);
            BufferedImage newBufferImage = new BufferedImage(bufferRead.getWidth(), bufferRead.getHeight(), BufferedImage.TYPE_INT_RGB);
            newBufferImage.createGraphics().drawImage(bufferRead, 0, 0, Color.white, null);

            switch (format) {
                case "jpg":
                    ImageIO.write(newBufferImage, "jpg", new File(pathExport + nameExport + ".jpg"));
                    break;
                case "bmp":
                    ImageIO.write(newBufferImage, "bmp", new File(pathExport + nameExport + ".bmp"));
                    break;
                case "png":
                    ImageIO.write(newBufferImage, "png", new File(pathExport + nameExport + ".png"));
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
