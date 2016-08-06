package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ResourceBundle;

/**
 * this class show the options of save and export
 */
public class MenuBarRigthPanel extends JMenuBar implements ActionListener {
    private RightPanelViewer rightPanelViewer;
    private JMenu exportOption;
    private JButton saveOption;
    private JMenuItem exportAsJpg;
    private JMenuItem exportAsPng;
    private JMenuItem exportAsBmp;
    private ImageIcon exportImage;
    private ImageIcon saveImage;
    private static final String FILENAME = "ui/LabelsBundle";
    ResourceBundle labels;

    /**
     * the constructor initizlize the components
     *
     * @param rightPanelViewer this is and object right panel
     */
    public MenuBarRigthPanel(RightPanelViewer rightPanelViewer) {
        labels = labels.getBundle(FILENAME);
        initComponents();
        addComponents();
        this.rightPanelViewer = rightPanelViewer;

    }

    /**
     * this method init the components
     */

    public void initComponents() {
        exportOption = new JMenu(labels.getString("MenuBar.rigth.panel.exportImage"));
        exportOption.setFont(new Font("Segoe Print", Font.BOLD, 22));
        exportImage = new ImageIcon(getClass().getResource("/img/exportIcon32.png"));
        exportOption.setIcon(exportImage);
        saveOption = new JButton(labels.getString("MenuBar.rigth.panel.saveImage"));
        saveOption.setFont(new Font("Segoe Print", Font.BOLD, 22));
        saveImage = new ImageIcon(getClass().getResource("/img/saveIcon32.png"));
        saveOption.setIcon(saveImage);
        saveOption.addActionListener(this);
        exportAsJpg = new JMenuItem(labels.getString("MenuBar.rigth.panel.exportAsJpg"));
        exportAsJpg.addActionListener(this);
        exportAsPng = new JMenuItem(labels.getString("MenuBar.rigth.panel.exportAsPng"));
        exportAsPng.addActionListener(this);
        exportAsBmp = new JMenuItem(labels.getString("MenuBar.rigth.panel.exportAsBmp"));
        exportAsBmp.addActionListener(this);
    }

    /**
     * this method add the components to the Menu Bar
     */
    public void addComponents() {
        exportOption.add(exportAsJpg);
        exportOption.add(exportAsPng);
        exportOption.add(exportAsBmp);
        this.add(exportOption);
        this.add(saveOption);

    }

    /**
     * aqui esta el metodo para salvar el archivo pegaso!
     */
    public void saveImageInFile() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setDialogTitle("SAVE FILE");
        fileChooser.setCurrentDirectory(new File("."));
        int returnValue = fileChooser.showOpenDialog(null);
    }

    /**
     * this is the event  of the popUp menus
     * @param e this is the event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exportAsJpg) {
            System.out.println("JPG");
        }
        if (e.getSource() == exportAsPng) {
            System.out.println("PNG");
        }
        if (e.getSource() == exportAsBmp) {
            System.out.println("BMP");
        }
        if (e.getSource() == saveOption) {
            saveImageInFile();
            System.out.println("boton salvar !");
        }
    }
}
