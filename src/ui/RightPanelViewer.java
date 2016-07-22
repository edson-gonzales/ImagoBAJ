package ui;
import javax.swing.*;
import java.awt.*;

/**
 *IN CONSTRUCTION
 * this clas will be in charge for managing the tools for modifying
 * images such as resize, rotate ....
 *
 */
public class RightPanelViewer extends JPanel {

    private ImageIcon imageIcon;
    private JLabel imageToDisplay;

    /**
     * constructor
     * @param title this varible is a string and is the name of the JPanel
     */
    public RightPanelViewer(String title) {
        super();
        setBackground(Color.GRAY);
        initComponents();
        addComponents();
    }
    /**
     * initialize the components
     */
    public void initComponents() {
        this.setLayout(new BorderLayout());
        imageIcon = new ImageIcon("C:/IMAGENES/logo.jpg");
        imageToDisplay = new JLabel(imageIcon);
        this.add(imageToDisplay, BorderLayout.CENTER);
    }
    /**
     * add the components to the panel
     */
    public void addComponents() {


    }

}
