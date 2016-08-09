package ui;

import tools.ResizeImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * this class is in charge to capture de values of the width and high which the image
 * will be resized
 */
public class ResizePanel extends JFrame implements ActionListener {
    private JPanel southPanel;
    private JPanel resizePanel;
    private JLabel horizontalLabel;
    private JLabel verticalLabel;
    private JTextField horizontaltextField;
    private JTextField verticalTextField;
    private JButton acceptButton;
    private JButton cancelButton;
    private static final String FILENAME = "ui/LabelsBundle";
    private RightPanelViewer rightPanelViewer;
    private String pathSourceImage;
    ResourceBundle labels;

    /**
     * Constructor
     */
    public ResizePanel(RightPanelViewer rightPanelViewer) {
        super("RESIZE PANEL");
        labels = labels.getBundle(FILENAME);
        this.setSize(300, 175);
        initComponents();
        addComponents();
        this.rightPanelViewer = rightPanelViewer;
        pathSourceImage = this.rightPanelViewer.getImageIcon().getDescription();
    }

    /**
     * init the  components to captured values
     * button, textfields and labels
     */
    public void initComponents() {
        acceptButton = new JButton(labels.getString("Resize.Panel.buttonAccept"));
        acceptButton.addActionListener(this);
        cancelButton = new JButton(labels.getString("Resize.Panel.buttonCancel"));
        cancelButton.addActionListener(this);
        horizontalLabel = new JLabel(labels.getString("Resize.Panel.labelVertical"));

        verticalLabel = new JLabel(labels.getString("Resize.Panel.labelHorizontal"));
        horizontaltextField = new JTextField();
        horizontaltextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character = e.getKeyChar();
                if (!((Character.isDigit(character) || (character == KeyEvent.VK_BACK_SPACE)
                        || (character == KeyEvent.VK_DELETE)))) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        verticalTextField = new JTextField();
        verticalTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char character = e.getKeyChar();
                if (!((Character.isDigit(character) || (character == KeyEvent.VK_BACK_SPACE)
                        || (character == KeyEvent.VK_DELETE)))) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        resizePanel = new JPanel();
        southPanel = new JPanel();
        this.setLayout(new BorderLayout());
        resizePanel.setLayout(new GridLayout(2, 2, 15, 15));
        this.setLocation(((getToolkit().getScreenSize().width) - (this.getWidth())) / 2,
                ((getToolkit().getScreenSize().height) - (this.getHeight())) / 2);
    }

    /**
     * add components to the frame an JPanels
     */
    public void addComponents() {
        resizePanel.add(horizontalLabel);
        resizePanel.add(horizontaltextField);
        resizePanel.add(verticalLabel);
        resizePanel.add(verticalTextField);

        southPanel.add(cancelButton);
        southPanel.add(Box.createRigidArea(new Dimension(45, 55)));
        southPanel.add(acceptButton);

        this.add(southPanel, BorderLayout.SOUTH);
        this.add(Box.createRigidArea(new Dimension(30, 30)), BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(15, 30)), BorderLayout.EAST);
        this.add(Box.createRigidArea(new Dimension(15, 20)), BorderLayout.NORTH);
        this.getContentPane().add(resizePanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acceptButton) {
            if (verticalTextField.getText().equals("") || horizontaltextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fields can not be empty", "Empty fields", JOptionPane.WARNING_MESSAGE);
            } else {
                int newWidth = Integer.parseInt(verticalTextField.getText());
                int newHeigth = Integer.parseInt(horizontaltextField.getText());
                File fileImageSource = new File(pathSourceImage);
                File fileImageDestiny = new File("src/img/resize/");
                String nameImage = fileImageSource.getName();
                String newName = dateName() + "-" + nameImage;
                ResizeImage resize = new ResizeImage(fileImageSource, newWidth, newHeigth);
                resize.resizeImage(fileImageDestiny);
                File imageResized = new File("src/img/resize/" + nameImage);
                File imageResizedWithNewName = new File("src/img/resize/" + newName);
                imageResized.renameTo(imageResizedWithNewName);
                rightPanelViewer.changeImage("src/img/resize/" + newName);
                rightPanelViewer.updateUI();
                this.dispose();
            }

        }
        if (e.getSource() == cancelButton) {
            this.dispose();
        }
    }

    /**
     * this method generates the new name to the new file
     *
     * @return return a string that is repaced in the name
     */
    public String dateName() {
        Calendar date = Calendar.getInstance();
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH) + 1;
        int day = date.get(Calendar.DAY_OF_MONTH);
        int hour = date.get(Calendar.HOUR_OF_DAY);
        int minute = date.get(Calendar.MINUTE);
        int second = date.get(Calendar.SECOND);
        return year + "-" + month + "-" + day + "-" + hour + "-" + minute + "-" + second;
    }
}