package ui;

import javax.swing.*;
import java.awt.*;

/**
 * this class is in charge to Show the selected images and contain the operation for the same
 */
public class RightPanelViewer extends JPanel {
    private ImageIcon imageIcon;
    private JLabel jlabel;
    private JPanel imageInformationPanel;
    private ToolBarOperationWhitImages rigthToolBar;
    private JLabel imageNameTextLabel;
    private JLabel imageHighTextLabel;
    private JLabel imageWidthTexLabel;
    private JLabel imageExtensionTextLabel;
    private JLabel imageNameLabel;
    private JLabel imageHighLabel;
    private JLabel imageWidthLabel;
    private JLabel imageExtensionLabel;
    private JScrollPane scrollPaneImage;

    /**
     * Constructor load the methods
     */
    public RightPanelViewer() {
        initComponents();
        addComponents();
    }

    /**
     * initialize and set the components of the Jpanel
     */
    public void initComponents() {
        imageNameTextLabel = new JLabel("NAME:");
        imageHighTextLabel = new JLabel("HIGHT:");
        imageWidthTexLabel = new JLabel("WIDTH:");
        imageExtensionTextLabel = new JLabel("EXTENSION:");
        imageNameLabel = new JLabel();
        imageHighLabel = new JLabel();
        imageWidthLabel = new JLabel();
        imageExtensionLabel = new JLabel();
        rigthToolBar = new ToolBarOperationWhitImages();
        imageIcon = new ImageIcon(getClass().getResource("../img/IMAGO.jpg"));
        jlabel = new JLabel("");
        jlabel.setIcon(imageIcon);
        scrollPaneImage = new JScrollPane(jlabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        imageInformationPanel = new JPanel();
        this.setLayout(new BorderLayout());
        this.add(scrollPaneImage, BorderLayout.CENTER);
    }

    /**
     * add the components to the Jpanel
     */
    public void addComponents() {
        this.add(rigthToolBar, BorderLayout.EAST);
        this.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.NORTH);
        this.add(imageInformationPanel, BorderLayout.SOUTH);
        this.add(Box.createRigidArea(new Dimension(50, 50)), BorderLayout.WEST);
    }

    /**
     * this methods is in charge to change the image that will be selected in the left panel
     *
     * @param imagePath is a String  and carries the address of the image
     */
    public void changeImage(String imagePath) {
        this.remove(scrollPaneImage);
        System.out.println(imagePath);
        imageIcon = new ImageIcon(imagePath);
        jlabel = new JLabel("");
        jlabel.setIcon(imageIcon);
        scrollPaneImage = new JScrollPane(jlabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPaneImage, BorderLayout.CENTER);
        this.repaint();
    }

    /**
     * this method charge the attributes of the image selected
     *
     * @param item recive an object this object contains the attributes of the image
     */
    public void setImageProperties(Object item) {
        imageInformationPanel.remove(imageNameLabel);
        imageInformationPanel.add(imageNameTextLabel);
        imageNameLabel = new JLabel();
        imageNameLabel.setText(((ImageIcon) (item)).getDescription());
        imageInformationPanel.add(imageNameLabel);
        imageInformationPanel.add(imageExtensionTextLabel);
        imageInformationPanel.add(imageHighTextLabel);
        imageInformationPanel.add(imageWidthTexLabel);
        this.repaint();
    }
}
