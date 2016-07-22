package ui;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * This class contains the elements that are in charge of loading
 * the images as thumbnails, tools and functionality as search folder
 */
public class LeftSearchPanel extends JPanel {


    private Toolbar toolbar;
    private JList imagesList;
    private JLabel label;
    private ImageListModel imageListModel;


    /**
     * The constructor initializes the components and add the items to the frame
     */
    public LeftSearchPanel() {

        initComponents();
        addComponents();
    }

    /**
     *this method initialize  UI components
     */
    public void initComponents() {

        toolbar = new Toolbar();
        imageListModel = new ImageListModel();

        imagesList = new JList(imageListModel.listModel());
        imagesList.setVisibleRowCount(-1);
        imagesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        imagesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        setLayout(new BorderLayout());
        imagesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int imageHeight = ((ImageIcon)imagesList.getSelectedValue()).getIconHeight();
                int imageWidt=((ImageIcon)imagesList.getSelectedValue()).getIconHeight();
            }
        });
    }
    /**
     * adds the items to the panel
     */
    public void addComponents() {
        this.add(toolbar, BorderLayout.NORTH);
        add(imagesList, BorderLayout.CENTER);
        add(new JScrollPane(imagesList));


    }



}
