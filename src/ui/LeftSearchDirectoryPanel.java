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
 * Created by AlvaroDaza on 8/4/2016.
 */
public class LeftSearchDirectoryPanel extends JPanel implements ActionListener {

    private JTable informationTable;
    private RightPanelViewer rightPanelViewer;
    private LeftSearchPanel leftSearchPanel;
    private ImageListModel imageListModel;
    private ImageInformationPanel imageInformationPanel;
    private JPopupMenu popupMenu;
    private JScrollPane scrollPaneJlist;
    private File selectedFile;
    private JMenuItem searchBySize;
    private JMenuItem searchByName;
    private JMenuItem searchByPixel;
    private String searchPath;
    private long searchSize;
    private String searchPixel;
    private static final String FILENAME = "ui/LabelsBundle";
    ResourceBundle labels;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * Constructor
     *
     * @param rightPanelViewer object Jpanel
     * @param leftSearchPanel  object Jpanel
     */
    public LeftSearchDirectoryPanel(RightPanelViewer rightPanelViewer, LeftSearchPanel leftSearchPanel) {
        labels = labels.getBundle(FILENAME);
        this.leftSearchPanel = leftSearchPanel;
        this.rightPanelViewer = rightPanelViewer;
        this.setLayout(new BorderLayout());
        popUpMenuIcons();
    }

    /**
     * create and set the Context Menu
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
     * repaint the panel
     *
     * @param file file
     */
    public void updateDirectoryPanel(File file) {
        this.removeAll();
        Folder files = new Folder();
        files.listImageDirectory(file);
        ArrayList<File> listFileImage = files.getListImageFiles();
        fillInformationDirectory(listFileImage);

        imageInformationPanel = new ImageInformationPanel();
        this.add(imageInformationPanel, BorderLayout.SOUTH);
        this.updateUI();
    }

    /**
     * this methos creates a Jtable which show the files
     *
     * @param filesImage array list of files to be displayed
     */
    public void fillInformationDirectory(ArrayList<File> filesImage) {
        imageListModel = new ImageListModel();
        informationTable = new JTable(imageListModel.setDefaultTableModel(filesImage));
        informationTable.setGridColor(Color.gray);
        informationTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    super.mouseClicked(e);
                    int row = informationTable.getSelectedRow();
                    String path = (String) informationTable.getValueAt(row, 4);
                    searchPath = (String) informationTable.getValueAt(row, 0);
                    double size = (double) (informationTable.getValueAt(row, 1));
                    searchSize = (long) (size * 1000);
                    searchPixel = (String) informationTable.getValueAt(row, 4);
                    imageInformationPanel.imageProperties(path);
                    rightPanelViewer.changeImage(path);
                    rightPanelViewer.changeSliderValue();
                    rightPanelViewer.updateUI();

                } catch (Exception l) {
                    LOGGER.setLevel(Level.WARNING);
                    LOGGER.warning("" + l);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        scrollPaneJlist = new JScrollPane(informationTable,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPaneJlist, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchByName) {
            searchDuplicatesBySize("Name", searchPath);
        }
        if (e.getSource() == searchBySize) {
            searchDuplicatesBySize("Size", searchSize);
        }
        if (e.getSource() == searchByPixel) {
            searchDuplicatesBySize("Pixel", searchPixel);
        }
    }

    /**
     * this method is in charge to search duplicates which an criteria
     *
     * @param strategyDuplicate string that represent the kind of search
     * @param dateComparete     the object taht will be compare
     */
    private void searchDuplicatesBySize(String strategyDuplicate, Object dateComparete) {
        Folder files = new Folder();
        files.listImageDirectory(selectedFile);

        Duplicate duplicate = new Duplicate(strategyDuplicate, dateComparete);
        duplicate.searchDuplicate(files);
        ArrayList<File> duplicates = duplicate.getListDuplicate();
        repaintPanel(duplicates);
        leftSearchPanel.repaintPanel(duplicates);
    }

    /**
     * this method repaint the panel adding the new files
     *
     * @param files Array of files tah will be displayed
     */
    public void repaintPanel(ArrayList<File> files) {
        this.removeAll();
        fillInformationDirectory(files);
        imageInformationPanel = new ImageInformationPanel();
        this.add(imageInformationPanel, BorderLayout.SOUTH);
        this.updateUI();
    }

    /**
     * set the file selected
     *
     * @param selectedFile file selected
     */
    public void setFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

}
