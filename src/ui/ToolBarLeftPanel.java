package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is responsible for create a JToolBar
 * whish will contain the mechanism to load images
 */
public class ToolBarLeftPanel extends JToolBar implements ActionListener {

    private ImageIcon iconPath;
    private JButton chooseFileButton;
    private File selectedFile;
    private LeftSearchPanel leftSearchPanel;
    private LeftSearchDirectoryPanel leftSearchDirectoryPanel;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * The Constructor
     *
     * @param leftSearchPanel          this is an object of the kind Left search panel
     * @param leftSearchDirectoryPanel this is an object of the kind Left Search Directory Panel
     */
    public ToolBarLeftPanel(LeftSearchPanel leftSearchPanel, LeftSearchDirectoryPanel leftSearchDirectoryPanel) {
        initComponents();
        addComponents();
        this.leftSearchPanel = leftSearchPanel;
        this.leftSearchDirectoryPanel = leftSearchDirectoryPanel;
    }

    /**
     * Initialize the components
     */
    public void initComponents() {
        iconPath = new ImageIcon(getClass().getResource("../img/folderOpen.gif"));
        chooseFileButton = new JButton();
        chooseFileButton.setIcon(iconPath);
        chooseFileButton.addActionListener(this);
    }

    /**
     * add the file chooser
     */
    public void addComponents() {
        this.add(chooseFileButton);
    }

    /**
     * this File chooser
     *
     * @return returns a File
     */

    public File fileChooser() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
            }
            if (returnValue == JFileChooser.CANCEL_OPTION) {
                fileChooser.cancelSelection();
            }
        } catch (Exception e) {
            LOGGER.setLevel(Level.INFO);
            LOGGER.info("The file was not sensed" + e);

        }
        return selectedFile;
    }

    /**
     * the action to the file chooser
     *
     * @param e event to launch the file chooser
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseFileButton) {
            File selection = fileChooser();
            leftSearchPanel.updatePanel(selection);
            leftSearchPanel.setFile(selectedFile);
            leftSearchDirectoryPanel.updateDirectoryPanel(selection);
            leftSearchDirectoryPanel.setFile(selectedFile);
        }
    }
}
