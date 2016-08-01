package ui;
import javax.swing.*;
import java.awt.*;

/**
 * This class is responsible for allowing the user to set and apply different filters to apply image
 */
public class FiltersPanel extends JFrame {
    private JPanel filtersPanel;
    private JPanel buttonsPanel;
    private JButton filterButton1;
    private JButton filterButton2;
    private JButton filterButton3;
    private JButton filterButton4;
    private JButton acceptButton;
    private JButton cancelButton;

    /**
     * the frame builder instance methods responsible for drawing the frame
     */
    public FiltersPanel() {
        super("FILTERS");
        initComponents();
        addComponents();
    }

    /**
     * instance all components of the frame
     */
    public void initComponents() {
        setSize(400, 200);
        filterButton1 = new JButton("Filter1");
        filterButton2 = new JButton("Filter2");
        filterButton3 = new JButton("Filter3");
        filterButton4 = new JButton("Filter4");
        acceptButton = new JButton("ACCEPT");
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
        filtersPanel.add(filterButton1);
        filtersPanel.add(filterButton2);
        filtersPanel.add(filterButton3);
        filtersPanel.add(filterButton4);
        buttonsPanel.add(acceptButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(10, 75)));
        buttonsPanel.add(cancelButton);
        this.add(filtersPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);
        this.add(Box.createRigidArea(new Dimension(10, 10)), BorderLayout.EAST);
        this.add(Box.createRigidArea(new Dimension(10, 10)), BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(20, 35)), BorderLayout.NORTH);
        this.getContentPane().add(filtersPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }


}
