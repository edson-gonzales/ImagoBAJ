package filter;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 * Handles the structure of the strategies filters.
 *
 * @autor Bruno Vasquez
 */
public class Filters {
    private File fileImage;
    private EnumFilter filter;
    private File imageFilter;
    HashMap<EnumFilter, Filter> strategyAvailableEnum;
    /**
     * Filters a Buffered of a image to filter with color gray.
     *
     * @param filter   an EnumFilter to set the type strategy to apply a filter.
     * @param fileImage an Object File to sets the image to filter
     */
    public Filters(File fileImage, EnumFilter filter) {
        this.fileImage = fileImage;
        this.filter = filter;
        this.strategyAvailableEnum = new HashMap<EnumFilter, Filter>();
        strategyAvailableEnum.put(filter, new FilterGray());
    }

    /**
     * Load a Object file to Object BufferedImage.
     *
     * @param directoryDestiny the Object File to save the image.
     */
    public void loadFileToBufferedImage(File directoryDestiny){
        try {
            Image imageLoad = Toolkit.getDefaultToolkit().getImage(fileImage.getAbsolutePath());
            imageLoad = new ImageIcon(imageLoad).getImage();

            BufferedImage bufferedImage = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration()
                                          .createCompatibleImage(imageLoad.getWidth(null), imageLoad.getHeight(null), Transparency.OPAQUE);
            bufferedImage.getGraphics().drawImage(imageLoad, 0, 0, null);

            Filter strategyUsedEnum = this.strategyAvailableEnum.get(filter);
            bufferedImage = strategyUsedEnum.filter(bufferedImage);

            loadBufferedImageToFile(bufferedImage,directoryDestiny);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Load a Object BufferedImage to Object File.
     *
     * @param directoryDestiny the Object File that contains the directory destiny.
     * @param bufferedImage the Object BufferedImage to load to a file.
     */
    private void loadBufferedImageToFile(BufferedImage bufferedImage, File directoryDestiny) {
        String[] imageName = fileImage.getName().split("\\.");
        try {
            ImageIO.write(bufferedImage, imageName[imageName.length-1], new File(directoryDestiny + "/" + fileImage.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


 }