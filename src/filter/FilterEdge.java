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
public class FilterEdge implements Filter {
    /**
     * Filters a Buffered of a image to apply edge filter.
     *
     * @param bufferedImage the Object BufferedImage to filter.
     * @return a Object BufferedImage filtered with edge filter.
     */
    @Override
    public BufferedImage filter(BufferedImage bufferedImage) {
        float[] edgeKernel = {
                0.0f, -1.0f, 0.0f,
                -1.0f, 4.0f, -1.0f,
                0.0f, -1.0f, 0.0f
        };

        BufferedImageOp edgeFilter = new ConvolveOp(new Kernel(3, 3, edgeKernel));
        return edgeFilter.filter(bufferedImage, null);
    }
}
