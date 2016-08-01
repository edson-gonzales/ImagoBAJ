package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * this class is the tool bar loaded in the leftPanel
 */
public class ToolBar extends JToolBar {
    private ImageIcon iconPath;
    private Action actionPath;
    private File selectedFile;


    /**
     * Contructor load the frame components
     */
    public ToolBar() {
        initComponents();
        addComponents();
    }

    /**
     * initilize the components and set the action performed to the button in the tool bar
     */
    public void initComponents() {
        iconPath = new ImageIcon(ToolBar.class.getResource("../img/folderOpen.gif"));
        actionPath = new AbstractAction("Path", iconPath) {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser();
            }
        };
    }

    /**
     * add the components in the bar
     */
    public void addComponents() {
        JButton JBPath = add(actionPath);
        JBPath.setToolTipText("Path");
    }

    /**
     * this method is in charge to select the directory of the images
     *
     * @return return a file
     */
    public File fileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setCurrentDirectory(new java.io.File("."));
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }
        if (returnValue == JFileChooser.CANCEL_OPTION) {
            fileChooser.cancelSelection();
        }
        return selectedFile;
    }
}
