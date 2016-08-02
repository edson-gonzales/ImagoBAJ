package filter;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.LookupOp;
import java.awt.image.ShortLookupTable;

/**
 * This class Filters a Buffered of a image.
 *
 * @autor Bruno Vasquez
 */
public class FilterPosterize implements Filter {
    /**
     * Filters a Buffered of a image to apply posterize filter.
     *
     * @param bufferedImage the Object BufferedImage to filter.
     * @return a Object BufferedImage filtered with posterize filter.
     */
    @Override
    public BufferedImage filter(BufferedImage bufferedImage) {
        short[] posterize = new short[256];
        for (int i = 0; i < 256; i++)
            posterize[i] = (short) (i - (i % 32));
        BufferedImageOp posterizeOp = new LookupOp(new ShortLookupTable(0, posterize), null);
        return posterizeOp.filter(bufferedImage, null);
    }
}
