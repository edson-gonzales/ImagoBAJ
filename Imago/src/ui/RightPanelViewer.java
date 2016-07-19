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
    private JLabel jImage;

    /**
     * constructor
     * @param title
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
        jImage = new JLabel(imageIcon);
        this.add(jImage, BorderLayout.CENTER);

    }

    /**
     * add the components to the panel
     */
    public void addComponents() {


    }

}
