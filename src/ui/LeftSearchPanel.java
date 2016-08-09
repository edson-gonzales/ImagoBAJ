package ui;

import core.Duplicate;
import core.Folder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the panel that all the images will be loaded in a small icons list
 */
public class LeftSearchPanel extends JPanel implements ActionListener {
    private ImageInformationPanel imageInformationPanel;

    private JList imagesList;
    private ImageListModel imageListModel;
    private JScrollPane scrollPaneJlist;
    private RightPanelViewer rightPanelViewer;
    private JPopupMenu popupMenu;
    private JMenuItem searchBySize;
    private JMenuItem searchByName;
    private JMenuItem searchByPixel;
    private File selectedFile;
    private static final String FILENAME = "ui/LabelsBundle";
    ResourceBundle labels;
    private LeftSearchDirectoryPanel leftSearchDirectoryPanel;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * the Constructor is in charge of load the methods JtoolBar and Set a Layout
     * also receive the Rigth Panel in which exist the methods are necessary to
     * change the image in the right panel
     *
     * @param rightPanelViewer this object is the rigth panel,
     *                         We instantiate it to use some methods of the panel
     */
    public LeftSearchPanel(RightPanelViewer rightPanelViewer) {
        labels = labels.getBundle(FILENAME);
        this.rightPanelViewer = rightPanelViewer;
        this.setLayout(new BorderLayout());
        popUpMenuIcons();
    }

    /**
     * this method create the the context menu
     */
    public void popUpMenuIcons() {
        popupMenu = new JPopupMenu();
        searchBySize = new JMenuItem(labels.getString("PopUpMenu.searchBy.size"));
        popupMenu.add(searchBySize);
        searchByName = new JMenuItem(labels.getString("PopUpMenu.searchBy.Name"));
        popupMenu.add(searchByName);
        searchByPixel = new JMenuItem(labels.getString("PopUpMenu.searchBy.Pixel"));
        popupMenu.add(searchByPixel);
        searchBySize.addActionListener(this);
        searchByName.addActionListener(this);
        searchByPixel.addActionListener(this);
    }

    /**
     * this methos refresh table
     *
     * @param pathFile recive a file that
     */

    public void updatePanel(File pathFile) {
        this.removeAll();
        Folder files = new Folder();
        files.listImageDirectory(pathFile);
        ArrayList<File> listFileImage = files.getListImageFiles();
        recursiveList(listFileImage);
        imageInformationPanel = new ImageInformationPanel();
        this.add(imageInformationPanel, BorderLayout.SOUTH);
        this.updateUI();
    }

    /**
     * this method
     *
     * @param filesImage
     */
    public void recursiveList(ArrayList<File> filesImage) {
        imageListModel = new ImageListModel();
        imagesList = new JList((imageListModel.setListModel(filesImage)));
        imagesList.setVisibleRowCount(-1);
        imagesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        imagesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        imagesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 1) {
                    Object item = imagesList.getSelectedValue();
                    String imageSelectedPath = ((ImageIcon) (item)).getDescription();
                    imageInformationPanel.imageProperties(imageSelectedPath);
                    rightPanelViewer.changeImage(imageSelectedPath);
                    rightPanelViewer.changeSliderValue();
                    rightPanelViewer.updateUI();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        scrollPaneJlist = new JScrollPane(imagesList,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPaneJlist, BorderLayout.CENTER);
    }

    /**
     * this is the action performed to the button File located in the toolbar
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == searchByName) {
                File fileImage = new File(((ImageIcon) (imagesList.getSelectedValue())).getDescription());
                String nameImage = fileImage.getName();
                searchDuplicatesBySize("Name", nameImage);
            }
            if (e.getSource() == searchBySize) {
                File fileImage = new File(((ImageIcon) (imagesList.getSelectedValue())).getDescription());
                Long lengthImage = fileImage.length();
                searchDuplicatesBySize("Size", lengthImage);
            }
            if (e.getSource() == searchByPixel) {
                File fileImage = new File(((ImageIcon) (imagesList.getSelectedValue())).getDescription());
                String pathImage = fileImage.getPath();
                searchDuplicatesBySize("Pixel", pathImage);
            }

        } catch (Exception ex) {
            LOGGER.setLevel(Level.WARNING);
            LOGGER.warning("The file was not selected " + e);
        }
    }

    /**
     * this method is in charge to earch duplicates according to the criteria
     *
     * @param strategyDuplicate
     * @param dateToCompare
     */
    private void searchDuplicatesBySize(String strategyDuplicate, Object dateToCompare) {
        try {
            Folder files = new Folder();
            File fileImage = new File(((ImageIcon) (imagesList.getSelectedValue())).getDescription());
            files.listImageDirectory(selectedFile);

            Duplicate duplicate = new Duplicate(strategyDuplicate, dateToCompare);
            duplicate.searchDuplicate(files);
            ArrayList<File> duplicates = duplicate.getListDuplicate();
            repaintPanel(duplicates);
            leftSearchDirectoryPanel.repaintPanel(duplicates);

        } catch (Exception e) {
            LOGGER.setLevel(Level.WARNING);
            LOGGER.warning("The file was not selected " + e);
        }
    }

    /**
     * this method is in charge to repaint the image in the panel
     *
     * @param files recive an array of files which they will be loaded to be displayed
     */
    public void repaintPanel(ArrayList<File> files) {
        this.removeAll();
        recursiveList(files);
        imageInformationPanel = new ImageInformationPanel();
        this.add(imageInformationPanel, BorderLayout.SOUTH);
        this.updateUI();
    }

    public void setFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    /**
     * this methos set the panel Left search Directory panel
     *
     * @param leftSearchDirectoryPanel recive an object  Jpanel
     */
    public void setLeftSearchDirectoryPanel(LeftSearchDirectoryPanel leftSearchDirectoryPanel) {
        this.leftSearchDirectoryPanel = leftSearchDirectoryPanel;
    }
}
