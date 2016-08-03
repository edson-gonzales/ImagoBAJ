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
    DefaultListModel list = new DefaultListModel();

    /**
     * THIS METHOD IS ONLY TO TEST HOW THE IMAGE ICONS ARE CHARGED
     * ONCE APPROVED CODE REVIEW THIS METHOD WILL BE REPLACED BY BRUNO'S METHOD
     *
     * this method returns the default model to the LeftPanel
     * this DefaulModelList will be loaded for a JList
     *
     * @return returns the  variable  listModel filled whit imagesIcon
     */
    public DefaultListModel listModel(String path) {
        try {
            listIMag = chargeFilesToList(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listIMag;
    }

    /**
     * this method is in charge to fill all ImageIcons to be shown
     *
     * @param path is a String It is the address of the directory
     * @return return a Default model list
     */
    public DefaultListModel chargeFilesToList(String path) {
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
                list.add(index++, imageIconToCharge.getScaledImage(100, 100));
            }
        }
        return list;
    }
}





