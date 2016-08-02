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
public class FilterIdentity implements Filter {
    /**
     * Filters a Buffered of a image to apply identity filter.
     *
     * @param bufferedImage the Object BufferedImage to filter.
     * @return a Object BufferedImage filtered with identity filter.
     */
    @Override
    public BufferedImage filter(BufferedImage bufferedImage) {
        float[] identityKernel = {
                0.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 0.0f, 0.0f
        };
        BufferedImageOp identityFilter = new ConvolveOp(new Kernel(3, 3, identityKernel));
        return identityFilter.filter(bufferedImage, null);
    }
}
