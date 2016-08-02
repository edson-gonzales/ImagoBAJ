package filter;

import java.awt.image.BandCombineOp;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/**
 * This class Filters a Buffered of a image.
 *
 * @autor Bruno Vasquez
 */
public class FilterColor implements Filter {
    /**
     * Filters a Buffered of a image to apply color filter.
     *
     * @param bufferedImage the Object BufferedImage to filter.
     * @return a Object BufferedImage filtered with color filter.
     */
    @Override
    public BufferedImage filter(BufferedImage bufferedImage) {
        float[][] colorMatrix = {{1f, 0f, 0f}, {0.5f, 1.0f, 0.5f}, {0.2f, 0.4f, 0.6f}};
        BandCombineOp changeColors = new BandCombineOp(colorMatrix, null);
        Raster sourceRaster = bufferedImage.getRaster();
        WritableRaster displayRaster = sourceRaster.createCompatibleWritableRaster();
        changeColors.filter(sourceRaster, displayRaster);
        return new BufferedImage(bufferedImage.getColorModel(), displayRaster, true, null);
    }
}
