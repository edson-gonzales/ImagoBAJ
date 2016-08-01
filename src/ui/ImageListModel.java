package ui;
import javax.swing.*;
import java.io.File;

/**
 * THis class are in charge of create and send the list model
 * and will be responsible load the images that user choose
 */
public class ImageListModel {
    ImageIconToCharge imageIconToCharge;
    DefaultListModel listIMag = new DefaultListModel();

    /**
     * this method is in charge of filling the list model which ImageIcons
     * which will return to the LeftPanel class for her to be loaded
     * @return returns the  variable  listModel filled whit imagesIcon
     */
    public DefaultListModel listModel(String path) {
        try {
            File folder = new File(path);
            File[] listOfFiles = folder.listFiles();
            int index = 0;
            for (int i = 0; i < listOfFiles.length; i++) {
                String name = listOfFiles[i].toString();
                if (name.endsWith("jpg") || name.endsWith("bmp") || name.endsWith("png")) {
                    String pathOfImage = listOfFiles[i].getPath();
                    String nameOfImage = listOfFiles[i].getName();
                    long sizeOfImage = listOfFiles[i].length();
                    imageIconToCharge = new ImageIconToCharge(sizeOfImage, nameOfImage, pathOfImage);
                    imageIconToCharge.setDescription(pathOfImage);
                    listIMag.add(index++, imageIconToCharge.getScaledImage(100, 100));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listIMag;
    }
}





