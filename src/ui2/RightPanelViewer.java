package ui;
import javax.swing.*;
import java.awt.*;

/**
 * this clas will be in charge for managing the tools for modifying
 * images such as resize, rotate ....
 */
public class RightPanelViewer extends JPanel {
    private ToolBarOperationWhitImages rigthToolBar;
    private ImageIcon imageIcon;
    private JLabel imageToDisplay;
    private String path;

    /**
     * recieve the absolute path of the image that will be displayed
     *
     * @Path this is the path of the image
     */
    public RightPanelViewer(String Path) {
        super();
        setBackground(Color.GRAY);
        initComponents();
        addComponents();
        this.path = Path;
    }

    /**
     * initialize the components like tool bar ,jlabel that will contain the image,and set layouts
     */
    public void initComponents() {
        rigthToolBar = new ToolBarOperationWhitImages();
        this.setLayout(new BorderLayout());
        imageIcon = new ImageIcon(path);
        imageToDisplay = new JLabel(imageIcon);
        this.add(imageToDisplay, BorderLayout.CENTER);
    }

    /**
     * add the rigth toolbar that which is in charge to contain the  tools to modify the image
     */
    public void addComponents() {this.add(rigthToolBar, BorderLayout.EAST);}
}
