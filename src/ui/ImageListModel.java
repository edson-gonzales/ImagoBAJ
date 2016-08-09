package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.ArrayList;

/**
 * THis class are in charge of create and send the list model
 * and will be responsible load the images that user choose
 */
public class ImageListModel {
    private ImageIconToCharge imageIconToCharge;
    private DefaultListModel listIMag = new DefaultListModel();
    private DefaultListModel list = new DefaultListModel();
    private DefaultTableModel informationTableModel;
    private Object[] fileImage;

    /**
     * this method returns the default model to the LeftPanel
     * this DefaultModelList will be loaded for a JList
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

    /**
     * this method is in charge to load the imageIcons in the JList
     *
     * @param imagesFiles receive a array whit the files that will be charged
     * @return Return a default List model  to be charged bu the JList
     */
    public DefaultListModel setListModel(ArrayList<File> imagesFiles) {
        int index = 0;
        for (File image : imagesFiles) {
            String pathOfImage = image.getPath();
            String nameOfImage = image.getName();
            long sizeOfImage = image.length();
            imageIconToCharge = new ImageIconToCharge(sizeOfImage, nameOfImage, pathOfImage);
            imageIconToCharge.setDescription(pathOfImage);
            list.add(index++, imageIconToCharge.getScaledImage(100, 100));
        }
        return list;
    }

    /**
     * this class is in charge to load the  values of the table
     *
     * @param files is an array of files
     * @return return a DefaultTableModel to be load by the TableModel
     */
    public DefaultTableModel setDefaultTableModel(ArrayList<File> files) {

        String[] columnsName = {"Name", "Size [Bytes]", "Directory", "Owner", "Absolute Path"};
        informationTableModel = new DefaultTableModel(columnsName, 0);
        for (File imageinformation : files) {
            Path path = Paths.get(imageinformation.getAbsolutePath());
            FileOwnerAttributeView view = Files.getFileAttributeView(path,
                    FileOwnerAttributeView.class);
            String name = imageinformation.getName();
            long sizeOfImage = imageinformation.length();
            String parentFile = imageinformation.getParent();
            String absolutePath = imageinformation.getAbsolutePath();
            fileImage = new Object[5];
            fileImage[0] = name;
            fileImage[1] = (double) sizeOfImage / 1000;
            fileImage[2] = parentFile;
            try {
                fileImage[3] = view.getOwner();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileImage[4] = absolutePath;
            informationTableModel.addRow(fileImage);
        }
        return informationTableModel;
    }


}





