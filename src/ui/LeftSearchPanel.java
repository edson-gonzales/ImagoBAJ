package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;


/**
 * This is the panel that all the images will be loaded in a small icons list
 */
public class LeftSearchPanel extends JPanel implements ActionListener {
    private ImageInformationPanel imageInformationPanel;
    private JToolBar jToolBar;
    private ImageIcon iconPath;
    private JButton chooseFileButton;
    private File selectedFile;
    private JList imagesList;
    private ImageListModel imageListModel;
    private JScrollPane scrollPaneJlist;
    private RightPanelViewer rightPanelViewer;


    /**
     * the Constructor is in charge of load the methods JtoolBar and Set a Layout
     * also receive the Rigth Panel in which exist the methods are necessary to
     * change the image in the right panel
     *
     * @param rightPanelViewer this object is the rigth panel,
     *                         We instantiate it to use some methods of the panel
     */
    public LeftSearchPanel(RightPanelViewer rightPanelViewer) {
        this.rightPanelViewer = rightPanelViewer;
        this.setLayout(new BorderLayout());
        toolbar();
    }

    /**
     * this method is the toolbar which will be able to choose the folders that images are loaded
     */
    public void toolbar() {
        iconPath = new ImageIcon(getClass().getResource("../img/folderOpen.gif"));
        chooseFileButton = new JButton(iconPath);
        chooseFileButton.addActionListener(this);
        jToolBar = new JToolBar();
        jToolBar.add(chooseFileButton);
        this.add(jToolBar, BorderLayout.NORTH);
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
                    int i = imagesList.getSelectedIndex();
                    String imageSelectedPath = ((ImageIcon) (item)).getDescription();
                    imageInformationPanel.imageProperties(imageSelectedPath);
                    rightPanelViewer.changeImage(imageSelectedPath);
                    rightPanelViewer.updateUI();
                }
            }
        });
        scrollPaneJlist = new JScrollPane(imagesList,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPaneJlist, BorderLayout.CENTER);
    }

    /**
     * this method is responsible for selecting the directory and send it
     * to the methods responsible for loading on the panel
     *
     * @return return the selected File
     */
    public File fileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setCurrentDirectory(new java.io.File("."));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            this.removeAll();
            toolbar();
            initComponents(selectedFile.getAbsolutePath());
            imageInformationPanel = new ImageInformationPanel();
            this.add(imageInformationPanel, BorderLayout.SOUTH);
            this.updateUI();
        }
        if (returnValue == JFileChooser.CANCEL_OPTION) {
            fileChooser.cancelSelection();
        }
        return selectedFile;
    }

    /**
     * this is the action performed to the button File located in the toolbar
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseFileButton) {
            fileChooser();
        }
    }

}
