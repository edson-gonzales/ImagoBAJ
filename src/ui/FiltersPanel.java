package ui;


import filter.EnumFilter;
import filter.Filters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * This class is responsible for allowing the user to set and
 * apply different filters to apply image
 * This is done through a Drop Down List in which the type of
 * filter that will be applied will be chosen
 */
public class FiltersPanel extends JFrame implements ActionListener {
    private JPanel filtersPanel;
    private JButton applyButton;
    private JButton closeButton;
    private JComboBox filtersComboBox;
    private RightPanelViewer rightPanelViewer;
    private String pathSourceImage;

    /**
     * the frame builder instance methods responsible for drawing the frame
     */
    public FiltersPanel(RightPanelViewer rightPanelViewer) {
        super("FILTERS");
        setSize(250, 150);
        initComponents();
        addComponents();
        this.rightPanelViewer = rightPanelViewer;
        pathSourceImage = this.rightPanelViewer.getImageIcon().getDescription();
    }

    /**
     * instance all components of the frame
     */
    public void initComponents() {
        String[] filters = {"Gray", "Edge", "Blur", "Blue Invert",
                "Identity", "Invert", "Posterize", "Sharpen", "Color"};
        filtersComboBox = new JComboBox(filters);
        filtersComboBox.addActionListener(this);
        applyButton = new JButton("Apply");
        applyButton.addActionListener(this);
        closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        filtersPanel = new JPanel();
        filtersPanel.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());
        this.setLocation(((getToolkit().getScreenSize().width) - (this.getWidth())) / 2,
                ((getToolkit().getScreenSize().height) - (this.getHeight())) / 2);
    }

    /**
     * add all components to the frame
     */
    public void addComponents() {
        filtersPanel.add(filtersComboBox);
        filtersPanel.add(applyButton);
        filtersPanel.add(closeButton);
        this.add(filtersPanel, BorderLayout.CENTER);
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

        if (e.getSource() == filtersComboBox) {

        }
        if (e.getSource() == applyButton) {
            System.out.println(filtersComboBox.getSelectedItem());
            filter(filtersComboBox.getSelectedIndex());
        }
        if (e.getSource() == closeButton) {
            this.dispose();
        }
    }

    /**
     * this method apply the selected filter
     *
     * @param selectedIndex
     */
    private void filter(int selectedIndex) {
        EnumFilter strategyFilter = EnumFilter.GRAY;
        File fileImageSource = new File(pathSourceImage);
        String nameImage = fileImageSource.getName();
        String nameDirectory = "";
        switch (selectedIndex) {
            case 0:
                strategyFilter = EnumFilter.GRAY;
                nameDirectory = "src/img/filters/gray/";
                break;
            case 1:
                strategyFilter = EnumFilter.EDGE;
                nameDirectory = "src/img/filters/edge/";
                break;
            case 2:
                strategyFilter = EnumFilter.BLUR;
                nameDirectory = "src/img/filters/blur/";
                break;
            case 3:
                strategyFilter = EnumFilter.BLUEINVERT;
                nameDirectory = "src/img/filters/blueInvert/";
                break;
            case 4:
                strategyFilter = EnumFilter.IDENTITY;
                nameDirectory = "src/img/filters/identity/";
                break;
            case 5:
                strategyFilter = EnumFilter.INVERT;
                nameDirectory = "src/img/filters/invert/";
                break;
            case 6:
                strategyFilter = EnumFilter.POSTERIZE;
                nameDirectory = "src/img/filters/posterize/";
                break;
            case 7:
                strategyFilter = EnumFilter.SHARPEN;
                nameDirectory = "src/img/filters/sharpen/";
                break;
            case 8:
                strategyFilter = EnumFilter.COLOR;
                nameDirectory = "src/img/filters/color/";
                break;
        }
        Filters filters = new Filters(fileImageSource, strategyFilter);
        filters.loadFileToBufferedImage(new File(nameDirectory));
        rightPanelViewer.changeImage(nameDirectory + nameImage);
        rightPanelViewer.updateUI();
    }
}
