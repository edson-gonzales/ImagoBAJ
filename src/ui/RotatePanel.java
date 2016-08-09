package ui;

import tools.RotateImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Arc2D;
import java.io.File;
import java.util.Calendar;

/**
 * This class is responsible for obtaining the value of the rotation of the image
 */
public class RotatePanel extends JFrame implements ActionListener {

    private JLabel degreesLabel;
    private JButton acceptButton;
    private JButton cancelButton;
    private TextField degreesTextField;
    private JPanel degreesPanel;
    private JPanel buttonPanel;
    private RightPanelViewer rightPanelViewer;
    private String pathSourceImage;

    /**
     * Constructor load the methods
     */
    public RotatePanel(RightPanelViewer rightPanelViewer) {
        super("ROTATE IMAGE");
        initComponents();
        addComponents();
        this.rightPanelViewer = rightPanelViewer;
        pathSourceImage = this.rightPanelViewer.getImageIcon().getDescription();
    }

    /**
     * initialize the components of the frame
     */
    public void initComponents() {
        setSize(300, 175);
        degreesLabel = new JLabel("GRADOS");
        degreesTextField = new TextField();
        degreesTextField.addKeyListener(new KeyListener() {
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
        acceptButton = new JButton("APPLY");
        acceptButton.addActionListener(this);

        cancelButton = new JButton("CANCEL");
        cancelButton.addActionListener(this);
        degreesPanel = new JPanel();
        buttonPanel = new JPanel();
        this.setLayout(new BorderLayout());
        degreesPanel.setLayout(new GridLayout(1, 2, 25, 25));
        this.setLocation(((getToolkit().getScreenSize().width) - (this.getWidth())) / 2,
                ((getToolkit().getScreenSize().height) - (this.getHeight())) / 2);
    }

    /**
     * add the frame components
     */
    public void addComponents() {
        degreesPanel.add(degreesLabel);
        degreesPanel.add(degreesTextField);
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(50, 60)));
        buttonPanel.add(acceptButton);
        this.add((Box.createRigidArea(new Dimension(20, 20))), BorderLayout.EAST);
        this.add((Box.createRigidArea(new Dimension(20, 20))), BorderLayout.WEST);
        this.add((Box.createRigidArea(new Dimension(20, 45))), BorderLayout.NORTH);
        this.add(degreesPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(degreesPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acceptButton) {
            if (degreesTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "The degrees field can not be empty", "Empty field", JOptionPane.WARNING_MESSAGE);
            } else {
                double angle = Double.parseDouble(degreesTextField.getText());
                System.out.println(angle);
                File fileImageSource = new File(pathSourceImage);
                File fileImageDestiny = new File("src/img/rotate/");
                RotateImage rotate = new RotateImage(fileImageSource, angle);
                rotate.rotateImage(fileImageDestiny);
                String nameImage = fileImageSource.getName();
                String[] imageName = fileImageSource.getName().split("\\.");
                String newName = dateName() + "." + imageName[imageName.length - 1];
                File imageRotated = new File("src/img/rotate/" + nameImage);
                File imageRotatedWithNewName = new File("src/img/rotate/" + newName);
                imageRotated.renameTo(imageRotatedWithNewName);
                rightPanelViewer.changeImage("src/img/rotate/" + newName);
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
