package filter;
import java.awt.image.BufferedImage;
/**
 * This class Filters a Buffered of a image.
 *
 * @autor Bruno Vasquez
 */
public interface Filter {
    /**
     * Filters a Buffered of a image to filter with some color.
     *
     * @param bufferedImage the Object BufferedImage to filter.
     * @return a Object BufferedImage filtered with some color.
     */
    public BufferedImage filter(BufferedImage bufferedImage);
}