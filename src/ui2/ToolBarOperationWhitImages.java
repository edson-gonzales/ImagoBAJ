package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class is the tool Bar which contains the operations that working with image
 */
public class ToolBarOperationWhitImages extends JToolBar {

    private ResizePanel resizePanel;
    private ImageIcon iconRotatePath;
    private Action actionRotatePath;
    private ImageIcon iconResizePath;
    private Action actionResizePath;

    /**
     * Constructor
     */
    public ToolBarOperationWhitImages() {
        initComponents();
        addComponents();
    }

    /**
     * init the components of the toolbar and add events
     */
    public void initComponents() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        iconRotatePath = new ImageIcon(Toolbar.class.getResource("../img/rotateIcon32.png"));
        actionRotatePath = new AbstractAction("ROTATE", iconRotatePath) {
            @Override
            public void actionPerformed(ActionEvent e) {
                resizePanel = new ResizePanel();
            }
        };
        iconResizePath = new ImageIcon(Toolbar.class.getResource("../img/resizeIcon32.png"));
        actionResizePath = new AbstractAction("RESIZE", iconResizePath) {
            @Override
            public void actionPerformed(ActionEvent e) {}
        };
    }

    /**
     * add the components to the toolbar
     */
    public void addComponents() {

        JButton rotateButton = add(actionRotatePath);
        rotateButton.setToolTipText("ROTATE");
        JButton resizeButton = add(actionResizePath);
        resizeButton.setToolTipText("RESIZE");
    }
}
