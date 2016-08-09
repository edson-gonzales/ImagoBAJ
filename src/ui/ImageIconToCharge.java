package ui;

import javax.swing.*;
import java.awt.*;

/**
 * this class is the object which will contain the images that will be displayed in the
 * Jpanels
 */
public class ImageIconToCharge extends ImageIcon {

    private long sizeOfImage;
    private String nameOfImage;
    private String pathOfImage;

    /**
     * Constructor recive values that will be displayed lately
     *
     * @param sizeOfImage this is the real size of the image
     * @param nameOfImage this is the name of the image
     * @param pathOfImage this is teh path were the images is located
     */
    public ImageIconToCharge(long sizeOfImage, String nameOfImage, String pathOfImage) {
        super(pathOfImage);
        this.sizeOfImage = sizeOfImage;
        this.nameOfImage = nameOfImage;
        this.pathOfImage = pathOfImage;
    }

    /**
     * set the size of the image
     *
     * @param sizeOfImage size of the image
     */
    public void setSizeOfImage(long sizeOfImage) {
        this.sizeOfImage = sizeOfImage;
    }

    /**
     * set the name of the image
     *
     * @param nameOfImage this is the nameof the image
     */
    public void nameOfImage(String nameOfImage) {
        this.nameOfImage = nameOfImage;
    }

    /**
     * set the path of the image
     *
     * @param pathOfImage this is the absolute path were the image is located
     */
    public void pathOfImage(String pathOfImage) {
        this.pathOfImage = pathOfImage;
    }

    /**
     * get the size
     *
     * @return return the size of the image
     */
    public long getSizeOfImage() {
        return this.sizeOfImage;
    }

    /**
     * get the name of the image
     *
     * @return return the name of the image
     */
    public String getNameOfImage() {
        return this.nameOfImage;
    }

    /**
     * get the path of the image
     *
     * @return retirn the absolute path of the image
     */
    public String getPathOfImage() {
        return this.pathOfImage;
    }

    /**
     * scale the image whit the values of width and height
     *
     * @param width  this is the width with which it will scale the image
     * @param height this is the height with which it will scale the image
     * @return return a image icon scaled like a thumbnail
     */
    public ImageIcon getScaledImage(int width, int height) {
        ImageIcon imageIcon = new ImageIcon(this.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        imageIcon.setDescription(this.pathOfImage);

        return imageIcon;
    }


}
