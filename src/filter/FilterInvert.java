package filter;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;

/**
 * This class Filters a Buffered of a image.
 *
 * @autor Bruno Vasquez
 */
public class FilterInvert implements Filter {
    /**
     * Filters a Buffered of a image to apply invert filter.
     *
     * @param bufferedImage the Object BufferedImage to filter.
     * @return a Object BufferedImage filtered with invert filter.
     */
    @Override
    public BufferedImage filter(BufferedImage bufferedImage) {
        byte[] invertArray = new byte[256];

        for (int counter = 0; counter < 256; counter++)
            invertArray[counter] = (byte) (255 - counter);

        BufferedImageOp invertFilter = new LookupOp(new ByteLookupTable(0, invertArray), null);
        return invertFilter.filter(bufferedImage, null);
    }
}
