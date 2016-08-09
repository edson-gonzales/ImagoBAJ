package ui;

import tools.FormatExportImage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ResourceBundle;

/**
 * This is the Menu Bar that contains the export option
 */
public class MenuBarRigthPanel extends JMenuBar implements ActionListener {
    private RightPanelViewer rightPanelViewer;
    private JButton exportButton;
    private ImageIcon exportImageButton;
    private static final String FILENAME = "ui/LabelsBundle";
    ResourceBundle labels;

    /**
     * the constructor
     *
     * @param rightPanelViewer recive an object right panel
     */
    public MenuBarRigthPanel(RightPanelViewer rightPanelViewer) {
        labels = labels.getBundle(FILENAME);
        initComponents();
        addComponents();
        this.rightPanelViewer = rightPanelViewer;
    }

    /**
     * initialize the components
     */
    public void initComponents() {
        exportButton = new JButton(labels.getString("MenuBar.right.panel.exportImage"));
        exportButton.setFont(new Font("Segoe Print", Font.BOLD, 17));
        exportImageButton = new ImageIcon(getClass().getResource("/img/exportIcon32.png"));
        exportButton.setIcon(exportImageButton);
        exportButton.addActionListener(this);
    }

    /**
     * add the components to the Panel
     */
    public void addComponents() {
        this.add(exportButton);
    }

    /**
     * this method is in charge to save the image
     */
    public void saveImageInFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setApproveButtonText("Save Image");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileFilter(new FileNameExtensionFilter("JPG File", ".jpg"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("BMP File", ".bmp"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("PNG File", ".png"));
        fileChooser.setDialogTitle("Save Image As");
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getFileFilter().getDescription() == "JPG File") {
                File pathExport = fileChooser.getSelectedFile();
                exportImage("jpg", pathExport);

            }
            if (fileChooser.getFileFilter().getDescription() == "BMP File") {
                System.out.println("BMP");

                File pathExport = fileChooser.getSelectedFile();
                exportImage("bmp", pathExport);
            }
            if (fileChooser.getFileFilter().getDescription() == "PNG File") {
                System.out.println("PNG");

                File pathExport = fileChooser.getSelectedFile();
                exportImage("png", pathExport);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exportButton) {
            saveImageInFile();
        }
    }

    /**
     * this method export the image to the different formats
     *
     * @param type       this is  a String the extension
     * @param pathExport the path of the file to export
     */
    public void exportImage(String type, File pathExport) {
        File fileImage = new File(rightPanelViewer.getImageIcon().getDescription());
        FormatExportImage format = new FormatExportImage(type, fileImage);
        format.fileImageWithNewFormat(pathExport);
    }
}
