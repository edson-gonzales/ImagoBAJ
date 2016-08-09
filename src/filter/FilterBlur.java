package filter;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

/**
 * This class Filters a Buffered of a image.
 *
 * @autor Bruno Vasquez
 */
public class FilterBlur implements Filter {

    /**
     * Filters a Buffered of a image to apply blur filter.
     *
     * @param bufferedImage the Object BufferedImage to filter.
     * @return a Object BufferedImage filtered with blur filter.
     */
    @Override
    public BufferedImage filter(BufferedImage bufferedImage) {
        float ninth = 1.0f / 9.0f;
        float[] blurKernel = {
                ninth, ninth, ninth,
                ninth, ninth, ninth,
                ninth, ninth, ninth
        };
        BufferedImageOp blurFilter = new ConvolveOp(new Kernel(3, 3, blurKernel));
        return blurFilter.filter(bufferedImage, null);

    }
}
