package filter;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/**
 * This class Filters a Buffered of a image.
 *
 * @autor Bruno Vasquez
 */
public class FilterGray implements Filter {

    /**
     * Filters a Buffered of a image to filter with color gray.
     *
     * @param bufferedImage the Object BufferedImage to filter.
     * @return a Object BufferedImage filtered with color gray.
     */
    public BufferedImage filter(BufferedImage bufferedImage) {

        BufferedImage bufferedImageDestiny = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().
                getDefaultConfiguration().createCompatibleImage(bufferedImage.getWidth(), bufferedImage.getHeight(), Transparency.OPAQUE);

        for (int widthX = 0; widthX < bufferedImage.getWidth(); widthX++) {
            for (int heightY = 0; heightY < bufferedImage.getHeight(); heightY++) {

                Color colorImage = new Color(bufferedImage.getRGB(widthX, heightY));
                int averageTonality = (colorImage.getRed() + colorImage.getGreen() + colorImage.getBlue()) / 3;
                bufferedImageDestiny.setRGB(widthX, heightY, new Color(averageTonality, averageTonality, averageTonality).getRGB());
            }
        }
        return bufferedImageDestiny;
    }
}