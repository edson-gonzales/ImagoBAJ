package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * this class is a tool bar that contains the file chooser
 * and possibles methos tah will be implemented
 */
public class ToolBarLeftPanel extends JToolBar implements ActionListener {

    private ImageIcon iconPath;
    private JButton chooseFileButton;
    private File selectedFile;
    private LeftSearchPanel leftSearchPanel;

    /**
     * Constructor
     *
     * @param leftSearchPanel this is an object left Panel
     */
    public ToolBarLeftPanel(LeftSearchPanel leftSearchPanel) {
        initComponents();
        addComponents();
        this.leftSearchPanel = leftSearchPanel;
    }

    /**
     * init the components
     */
    public void initComponents() {
        iconPath = new ImageIcon(getClass().getResource("../img/folderOpen.gif"));
        chooseFileButton = new JButton("");
        chooseFileButton.setIcon(iconPath);
        chooseFileButton.addActionListener(this);
    }

    /**
     * add the components to the tool Bar
     */

    public void addComponents() {
        this.add(chooseFileButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseFileButton) {
            leftSearchPanel.updatePanel(fileChooser());
        }
    }

    /**
     * this is the file chooser component
     *
     * @return return the choosed
     */
    public File fileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setCurrentDirectory(new File("."));
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
