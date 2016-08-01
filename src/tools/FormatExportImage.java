package tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * This class export a image with other format.
 *
 * @autor Bruno Vasquez
 */
public class FormatExportImage {
    private String format;
    private File fileImage;

    /**
     * It is the constructor to create a new format for the image.
     *
     * @param formatImage an String to set the new format
     * @param fileImage   an Object file
     */
    public FormatExportImage(String formatImage, File fileImage) {
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

            ImageIO.write(newBufferImage, format, new File(pathExport + nameExport + "." + format));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
