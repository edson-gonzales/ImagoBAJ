package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 7/5/2016.
 */
public class LeftSearchPanel extends JPanel{


    private JScrollPane JScrollLeftPanel;
    private Toolbar toolbar;
    private JList imagesList;


    /**
     * The constructor initializes the components and add the items to the frame
     */
    public LeftSearchPanel()
    {

       initComponents();
        addComponents();
    }

    /**
     * starts UI components
     */
    public void initComponents()
    {
        toolbar = new Toolbar();
        imagesList = new JList();
        JScrollLeftPanel = new JScrollPane(imagesList);
        imagesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        imagesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        imagesList.setVisibleRowCount(-1);
        setLayout(new BorderLayout());
         new JPanel();

    }

    /**
     * adds the items to the panel
     */
    public void addComponents()
    {
        this.add(toolbar, BorderLayout.NORTH);
        add(JScrollLeftPanel);
        add(imagesList, BorderLayout.CENTER);
    }



}
