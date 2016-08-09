package tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * This class create a image with other heigth and width.
 *
 * @autor Bruno Vasquez
 */
public class RotateImage {
    private File fileImage;
    private double angle;

    /**
     * It is the constructor to create a new image rotated according an angle.
     *
     * @param angle     a double number to set the new angle
     * @param fileImage an Object file.
     */
    public RotateImage(File fileImage, double angle) {
        this.fileImage = fileImage;
        this.angle = Math.toRadians(angle);
    }

    /**
     * Create an image with new angle.
     *
     * @param directoryDestiny an Object file to sets the path to export
     */
    public void rotateImage(File directoryDestiny) {
        try {
            Image image = ImageIO.read(fileImage);
            BufferedImage bufImg = toBufferedImage(image);
            BufferedImage bufferReadRotated = imageBufferRotate(bufImg, angle);

            String[] imageName = fileImage.getName().split("\\.");
            ImageIO.write(bufferReadRotated, imageName[imageName.length - 1],
                    new File(directoryDestiny + "/" + fileImage.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method returns a buffered image with the draw of an image.
     *
     * @param image an object cannot be converted to a BufferedImage object
     * @return an object Buffered Image with the contents of an image
     */

    public BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        image = new ImageIcon(image).getImage();
        boolean hasAlpha = hasAlpha(image);

        BufferedImage bimage = bufferedImageCompatible(hasAlpha, image);
        if (bimage == null) {

            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }
        Graphics g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return bimage;
    }

    /**
     * Create a buffered image with a format that's compatible with the screen.
     *
     * @param hasAlpha that Determine the type of transparency of the new buffered image.
     * @param image    an object cannot be converted to a BufferedImage object
     * @return an object Buffered Image with the contents of an image
     */
    public BufferedImage bufferedImageCompatible(boolean hasAlpha, Image image) {

        BufferedImage bimage = null;
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }
            GraphicsDevice screenDevice = graphicsEnvironment.getDefaultScreenDevice();
            GraphicsConfiguration graphicsConfiguration = screenDevice.getDefaultConfiguration();
            bimage = graphicsConfiguration.createCompatibleImage(
                    image.getWidth(null), image.getHeight(null), transparency);
        } catch (HeadlessException e) {
            // The system does not have a screen
        }
        return bimage;
    }

    /**
     * Create a buffered image with a rotation.
     *
     * @param angle a double number to set the new angle
     * @param image an BufferedImage object
     * @return an object Buffered Image with the contents of an image
     */
    public BufferedImage imageBufferRotate(BufferedImage image, double angle) {
        double sin = Math.abs(Math.sin(angle));
        double cos = Math.abs(Math.cos(angle));
        int width = image.getWidth();
        int height = image.getHeight();
        int newWidth = (int) Math.floor(width * cos + height * sin);
        int newHeight = (int) Math.floor(height * cos + width * sin);

        GraphicsConfiguration graphicsConfiguration = getDefaultConfiguration();
        BufferedImage imageRotate = graphicsConfiguration.createCompatibleImage(newWidth, newHeight, Transparency.TRANSLUCENT);
        Graphics2D graphics = imageRotate.createGraphics();
        graphics.translate((newWidth - width) / 2, (newHeight - height) / 2);
        graphics.rotate(angle, width / 2, height / 2);
        graphics.drawRenderedImage(image, null);
        graphics.dispose();
        return imageRotate;
    }

    /**
     * Create the Graphics Configuration .
     *
     * @return the default configuration.
     */
    public GraphicsConfiguration getDefaultConfiguration() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
        return graphicsDevice.getDefaultConfiguration();
    }

    /**
     * Create the image color model.
     *
     * @param image an BufferedImage object
     * @return true if the specified image has transparent pixels.
     */
    public boolean hasAlpha(Image image) {
        if (image instanceof BufferedImage) {
            BufferedImage bimage = (BufferedImage) image;
            return bimage.getColorModel().hasAlpha();
        }

        PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, 1, 1, false);
        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException e) {
        }
        ColorModel colorModel = pixelGrabber.getColorModel();
        return colorModel.hasAlpha();
    }
}