package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * this class is in charge to capture de values of the width and high which the image
 * will be resized
 */
public class ResizePanel extends JFrame {
    private JPanel southPanel;
    private JPanel resizePanel;
    private JLabel horizontalLabel;
    private JLabel verticalLabel;
    private JTextField horizontaltextField;
    private JTextField verticalTextField;
    private JButton acceptButton;
    private JButton cancelButton;
    private static final String FILENAME = "ui/LabelsBundle";
    ResourceBundle labels;

    /**
     * Constructor
     */
    public ResizePanel() {
        super("RESIZE PANEL");
        labels = labels.getBundle(FILENAME);
        this.setSize(300, 175);
        initComponents();
        addComponents();
    }

    /**
     * init the  components to captured values
     * button, textfields and labels
     */
    public void initComponents() {
        acceptButton = new JButton(labels.getString("Resize.Panel.buttonAccept"));
        acceptButton.addActionListener(new ActionAcceptButton());
        cancelButton = new JButton(labels.getString("Resize.Panel.buttonCancel"));
        cancelButton.addActionListener(new ActionCancelButton());
        horizontalLabel = new JLabel(labels.getString("Resize.Panel.labelHorizontal"));
        verticalLabel = new JLabel(labels.getString("Resize.Panel.labelVertical"));
        horizontaltextField = new JTextField();
        verticalTextField = new JTextField();

        resizePanel = new JPanel();
        southPanel = new JPanel();
        this.setLayout(new BorderLayout());
        resizePanel.setLayout(new GridLayout(2, 2, 15, 15));
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

    /**
     * this is the action listener to the Accept button
     */
    static class ActionAcceptButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        }
    }

    /**
     * this is the action listener to the cancel button
     */
    static class ActionCancelButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        }
    }

}
