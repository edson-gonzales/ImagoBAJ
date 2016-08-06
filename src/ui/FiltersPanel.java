package ui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for allowing the user to set and
 * apply different filters to apply image
 * This is done through a Drop Down List in which the type of
 * filter that will be applied will be chosen
 */
public class FiltersPanel extends JFrame implements ActionListener {
    private JPanel filtersPanel;
    private JPanel buttonsPanel;
    private JButton acceptButton;
    private JButton cancelButton;
    private JButton applyButton;
    private JComboBox filtersComboBox;

    /**
     * the frame builder instance methods responsible for drawing the frame
     */
    public FiltersPanel() {
        super("FILTERS");
        setSize(300, 200);
        initComponents();
        addComponents();
    }

    /**
     * instance all components of the frame
     */
    public void initComponents() {
        String[] filters = {"filter1", "filter2", "filter3", "filter4"};
        filtersComboBox = new JComboBox(filters);
        filtersComboBox.addActionListener(this);
        applyButton = new JButton("Apply");
        applyButton.addActionListener(this);
        acceptButton = new JButton("ACCEPT");
        acceptButton.addActionListener(this);
        cancelButton = new JButton("CANCEL");
        filtersPanel = new JPanel();
        buttonsPanel = new JPanel();
        filtersPanel.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());
    }

    /**
     * add all components to the frame
     */
    public void addComponents() {
        filtersPanel.add(filtersComboBox);
        filtersPanel.add(applyButton);
        buttonsPanel.add(cancelButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(10, 75)));
        buttonsPanel.add(acceptButton);
        this.add(filtersPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(Box.createRigidArea(new Dimension(10, 10)), BorderLayout.EAST);
        this.add(Box.createRigidArea(new Dimension(10, 10)), BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(20, 35)), BorderLayout.NORTH);
        this.getContentPane().add(filtersPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * This the Action performed that will execute the operation
     * set filter to the image
     *
     * @param e recive the Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acceptButton) {

        }
        if (e.getSource() == filtersComboBox) {

        }
        if (e.getSource() == applyButton) {

        }
    }
}
