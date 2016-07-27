package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.awt.Image;

/**
 * THis class are in charge of create and send the list model
 * and will be responsible for configuring the direccionde which the images are loaded
 * the path
 * the path we are now using is a fixed C: IMAGES this path will be a variable that implement search methods in the future
 */
public class ImageListModel {

    String path = "C:/IMAGENES";
    File folder = new File(path);
    File[] listOfFiles = folder.listFiles();
    DefaultListModel listIMag = new DefaultListModel();

    /**
     * this method is in charge of filling the list model which ImageIcons
     * which will return to the LeftPanel class for her to be loaded
     *
     * @return returns the  variable  listModel filled whit imagesIcon
     */
    public DefaultListModel listModel() {
        try {
            int count = 0;
            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.println("check path" + listOfFiles[i]);
                String name = listOfFiles[i].toString();
                if (name.endsWith("jpg")) {
                    ImageIcon imageIcon = new ImageIcon(ImageIO.read(listOfFiles[i]));
                    Image image = imageIcon.getImage();
                    Image neWing = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                    ImageIcon image2 = new ImageIcon(neWing);
                    listIMag.add(count++, image2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listIMag;
    }


}





