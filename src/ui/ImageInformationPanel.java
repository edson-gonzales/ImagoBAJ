package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
import java.util.ResourceBundle;

/**
 * This clas is in charge to display the information of the image
 */
public class ImageInformationPanel extends JPanel {
    private Border raisedBevel;
    private JLabel imageNameText, imageSizeText, imageHeightText, imageWidthText, imagePathText;
    private JLabel imageName, imageSize, imageHeight, imageWidth, imagePath;
    private static final String FILENAME = "ui/LabelsBundle";
    ResourceBundle labels;

    /**
     * the constructor initialize the methods
     */
    public ImageInformationPanel() {
        raisedBevel = BorderFactory.createRaisedBevelBorder();
        this.setBackground(Color.CYAN);
        this.setBorder(raisedBevel);
        labels = labels.getBundle(FILENAME);
        initComponents();
        addComponents();
    }

    /**
     * this method is in charge to initialize all fields
     * that will be displayed like JLabels
     */
    public void initComponents() {
        imageNameText = new JLabel(labels.getString("InformationPanel.label.Name"));
        imageNameText.setFont(new Font("Segoe Print", Font.BOLD, 15));
        imageSizeText = new JLabel(labels.getString("InformationPanel.label.Size"));
        imageSizeText.setFont(new Font("Segoe Print", Font.BOLD, 15));
        imageHeightText = new JLabel(labels.getString("InformationPanel.label.Height"));
        imageHeightText.setFont(new Font("Segoe Print", Font.BOLD, 15));
        imageWidthText = new JLabel(labels.getString("InformationPanel.label.Width"));
        imageWidthText.setFont(new Font("Segoe Print", Font.BOLD, 15));
        imageName = new JLabel();
        imageSize = new JLabel();
        imageHeight = new JLabel();
        imageWidth = new JLabel();
        imagePathText = new JLabel(labels.getString("InformationPanel.label.AbsolutePath"));
        imagePathText.setFont(new Font("Segoe Print", Font.BOLD, 15));
        imagePath = new JLabel();
        this.setLayout(new GridLayout(5, 3, 10, 5));
    }

    /**
     * this method add yhe Labels in the Panel
     */
    public void addComponents() {
        this.add(imageNameText);
        this.add(imageName);
        this.add(imageSizeText);
        this.add(imageSize);
        this.add(imageHeightText);
        this.add(imageHeight);
        this.add(imageWidthText);
        this.add(imageWidth);
        this.add(imagePathText);
        this.add(imagePath);
    }

    /**
     * this methos sets the information of the image
     *
     * @param imagePathFile receive an String, the path of the image
     */
    public void imageProperties(String imagePathFile) {
        File imageFile = new File(imagePathFile);
        ImageIcon imageIconInformation = new ImageIcon(imagePathFile);
        String nameImage = imageFile.getName();
        float sizeImage = imageFile.length();
        int imageHeightValue = imageIconInformation.getIconHeight();
        int imageWidthValue = imageIconInformation.getIconWidth();
        String imageAbsolutePath = imageFile.getAbsolutePath();
        imageName.setText(nameImage);
        imageSize.setText("" + Float.toString((sizeImage / 1000)) + " bytes");
        imageHeight.setText("" + Integer.toString(imageHeightValue) + " pixels");
        imageWidth.setText("" + Integer.toString(imageWidthValue) + " pixels");
        imagePath.setText(imageAbsolutePath);
        this.repaint();
    }
}
