package ui;

import javax.swing.*;
import java.awt.*;

/**
 * This class is responsible for obtaining the value of the rotation of the image
 */
public class RotatePanel extends JFrame {

    private JLabel degreesLabel;
    private JButton acceptButton;
    private JButton cancelButton;
    private TextField degreesTextField;
    private JPanel degreesPanel;
    private JPanel buttonPanel;

    /**
     * Constructor load the methods
     */
    public RotatePanel() {
        super("ROTATE IMAGE");
        initComponents();
        addComponents();
    }

    /**
     * initialize the components of the frame
     */
    public void initComponents() {
        setSize(300, 175);
        degreesLabel = new JLabel("GRADOS");
        degreesTextField = new TextField();
        acceptButton = new JButton("ACCEPT");
        cancelButton = new JButton("CANCEL");
        degreesPanel = new JPanel();
        buttonPanel = new JPanel();
        this.setLayout(new BorderLayout());
        degreesPanel.setLayout(new GridLayout(1, 2, 25, 25));
    }

    /**
     * add the frame components
     */
    public void addComponents() {
        degreesPanel.add(degreesLabel);
        degreesPanel.add(degreesTextField);
        buttonPanel.add(acceptButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(50, 60)));
        buttonPanel.add(cancelButton);
        this.add((Box.createRigidArea(new Dimension(20, 20))), BorderLayout.EAST);
        this.add((Box.createRigidArea(new Dimension(20, 20))), BorderLayout.WEST);
        this.add((Box.createRigidArea(new Dimension(20, 45))), BorderLayout.NORTH);
        this.add(degreesPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(degreesPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
