package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ResourceBundle;


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
    private JMenuItem searchByLength;
    private JMenuItem searchByPixel;

    private static final String FILENAME = "ui/LabelsBundle";
    ResourceBundle labels;

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
     * this is the popUp menu that will show the option of search by size, name and pixels
     */
    public void popUpMenuIcons() {
        popupMenu = new JPopupMenu();
        searchBySize = new JMenuItem(labels.getString("PopUpMenu.searchBy.size"));
        popupMenu.add(searchBySize);
        searchByLength = new JMenuItem(labels.getString("PopUpMenu.searchBy.Length"));
        popupMenu.add(searchByLength);
        searchByPixel = new JMenuItem(labels.getString("PopUpMenu.searchBy.Pixel"));
        popupMenu.add(searchByPixel);
        searchBySize.addActionListener(this);
        searchByLength.addActionListener(this);
        searchByPixel.addActionListener(this);
    }


    /**
     * this methods instance the Jlist and contains the event mouse clicked who
     * is in charge to select the image that will be displayed
     *
     * @param path This parameter is the address of the folder where the images
     *             are loaded is a string and contains an absolute path
     */
    public void initComponents(String path) {
        imageListModel = new ImageListModel();
        imagesList = new JList((imageListModel.listModel(path)));
        imagesList.setVisibleRowCount(-1);
        imagesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        imagesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        imagesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
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
     * the update panel re paint the Jpanel showing the result search
     * @param pathFile this is a file that contains the file was changed
     */
    public void updatePanel(File pathFile) {
        this.removeAll();
        initComponents(pathFile.getAbsolutePath());
        imageInformationPanel = new ImageInformationPanel();
        this.add(imageInformationPanel, BorderLayout.SOUTH);
        this.updateUI();
    }

    /**
     * this is the action performed to the button File located in the toolbar
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == searchBySize) {
            String testJlistMenucontext = ((ImageIcon) (imagesList.getSelectedValue())).getDescription();
        }
        if (e.getSource() == searchByLength) {
            String testJlistMenucontext = ((ImageIcon) (imagesList.getSelectedValue())).getDescription();
        }
        if (e.getSource() == searchByPixel) {
            String testJlistMenucontext = ((ImageIcon) (imagesList.getSelectedValue())).getDescription();
        }
    }


}
