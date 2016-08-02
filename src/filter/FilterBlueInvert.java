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
public class FilterBlueInvert implements Filter {
    /**
     * Filters a Buffered of a image to apply blue invert filter.
     *
     * @param bufferedImage the Object BufferedImage to filter.
     * @return a Object BufferedImage filtered with blue invert filter.
     */
    @Override
    public BufferedImage filter(BufferedImage bufferedImage) {
        short[] invert = new short[256];
        short[] straight = new short[256];
        for (int i = 0; i < 256; i++) {
            invert[i] = (short) (255 - i);
            straight[i] = (short) i;
        }
        short[][] blueInvert = new short[][]{straight, straight, invert};
        BufferedImageOp blueInvertOp = new LookupOp(new ShortLookupTable(0, blueInvert), null);

        return blueInvertOp.filter(bufferedImage, null);
    }
}
