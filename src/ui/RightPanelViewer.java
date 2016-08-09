package ui;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * this class is in charge to Show the selected images and contain the operation for the same
 */
public class RightPanelViewer extends JPanel {
    private MenuBarRigthPanel menuBarRigthPanel;
    private ImageIcon imageIcon;
    private JLabel jlabel;
    private ImageIconToCharge imageIconToCharge;

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
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

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
        menuBarRigthPanel = new MenuBarRigthPanel(this);
        imageNameTextLabel = new JLabel("NAME:");
        imageHighTextLabel = new JLabel("HIGHT:");
        imageWidthTexLabel = new JLabel("WIDTH:");
        imageExtensionTextLabel = new JLabel("EXTENSION:");
        imageNameLabel = new JLabel();
        imageHighLabel = new JLabel();
        imageWidthLabel = new JLabel();
        imageExtensionLabel = new JLabel();
        rigthToolBar = new ToolBarOperationWhitImages(this);
        imageIcon = new ImageIcon(getClass().getResource("../img/IMAGO.jpg"));
        jlabel = new JLabel("");
        jlabel.setIcon(imageIcon);
        scrollPaneImage = new JScrollPane(jlabel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setLayout(new BorderLayout());
        this.add(scrollPaneImage, BorderLayout.CENTER);
        menuBarRigthPanel = new MenuBarRigthPanel(this);
    }

    /**
     * add the components to the Jpanel
     */
    public void addComponents() {

        this.add(rigthToolBar, BorderLayout.EAST);
        this.add(menuBarRigthPanel, BorderLayout.NORTH);
        this.add(Box.createRigidArea(new Dimension(50, 50)), BorderLayout.WEST);
    }

    /**
     * this methods is in charge to change the image that will be selected in the left panel
     *
     * @param imagePath is a String  and carries the address of the image
     */
    public void changeImage(String imagePath) {
        this.remove(scrollPaneImage);
        imageIcon = new ImageIcon(imagePath);
        jlabel = new JLabel("");
        jlabel.setIcon(imageIcon);
        scrollPaneImage = new JScrollPane(jlabel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPaneImage, BorderLayout.CENTER);
        this.repaint();
    }

    /**
     * THi method is in charge to do a Zoom in or a Zoom out to the image
     *
     * @param sliderValue this value is a Int and is sended by the Slider
     * @param imageIcon   this is an object ImageIcon that contains the values of the image
     */
    public void zoomImage(Integer sliderValue, ImageIcon imageIcon) {
        try {
            this.remove(scrollPaneImage);
            ImageIcon imageIcon2 =
                    new ImageIcon(imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth() + sliderValue,
                            imageIcon.getIconHeight() + sliderValue,
                            Image.SCALE_DEFAULT));
            jlabel = new JLabel("");
            jlabel.setIcon(imageIcon2);
            scrollPaneImage = new JScrollPane(jlabel,
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            this.add(scrollPaneImage, BorderLayout.CENTER);
            this.repaint();
            this.updateUI();

        } catch (Exception e) {
            LOGGER.setLevel(Level.WARNING);
            LOGGER.warning("" + e);
        }

    }

    /**
     * this method returns the an image icon
     *
     * @return
     */
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    /**
     * change the value of the slider
     */
    public void changeSliderValue() {
        rigthToolBar.setSlider();
    }

}
