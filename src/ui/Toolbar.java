package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Created by Administrator on 7/6/2016.
 */
public class Toolbar extends JToolBar {

    private ImageIcon iconPath;
    private Action actionPath;

    /**
     * The constructor initializes the components and add the items to the frame
     */
    public Toolbar() {
        initComponents();
        addComponents();
    }
    /**
     * start the components of the tool bar adding the icon and starting the FileChooser
     */
    public void initComponents() {
        iconPath = new ImageIcon(Toolbar.class.getResource("../img/folderOpen.gif"));
        actionPath = new AbstractAction("Path", iconPath) {
            public void actionPerformed(ActionEvent actionEvent) {
                fileChooser("");
            }
        };
    }
    /**
     * adds the listener action to the button to select the file
     */
    public void addComponents() {
        JButton JBPath = add(actionPath);
        JBPath.setToolTipText("Path");
    }
    /**
     * creates the folder finder which the images are loaded
     * "Path" variable will be the default address that will be used later
     *
     * @param Path
     */
    public void fileChooser(String Path) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setCurrentDirectory(new java.io.File("."));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
        }
        if (returnValue == JFileChooser.CANCEL_OPTION) {
            fileChooser.cancelSelection();
        }
    }
}
