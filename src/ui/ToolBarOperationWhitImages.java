package ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * This class is the tool Bar which contains the operations that working with image
 */
public class ToolBarOperationWhitImages extends JToolBar implements ChangeListener {
    private FiltersPanel filtersPanel;
    private RotatePanel rotatePanel;
    private ResizePanel resizePanel;
    private ImageIcon iconRotatePath;
    private Action actionRotatePath;
    private ImageIcon iconResizePath;
    private Action actionResizePath;
    private ImageIcon iconFilterPath;
    private Action actionFilterPath;
    private JSlider jSliderResizeImage;
    private RightPanelViewer rightPanelViewer;


    /**
     * Constructor
     */
    public ToolBarOperationWhitImages(RightPanelViewer rightPanelViewer) {
        initComponents();
        addComponents();
        this.rightPanelViewer = rightPanelViewer;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    /**
     * init the components of the toolbar and add events
     */
    public void initComponents() {
        iconRotatePath = new ImageIcon(getClass().getResource("../img/rotateIcon32.png"));
        actionRotatePath = new AbstractAction("ROTATE", iconRotatePath) {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotatePanel = new RotatePanel(rightPanelViewer);
            }
        };
        iconResizePath = new ImageIcon(getClass().getResource("../img/resizeIcon32.png"));
        actionResizePath = new AbstractAction("RESIZE", iconResizePath) {
            @Override
            public void actionPerformed(ActionEvent e) {
                resizePanel = new ResizePanel(rightPanelViewer);
            }
        };
        iconFilterPath = new ImageIcon(getClass().getResource("../img/filterIcon32.png"));
        actionFilterPath = new AbstractAction("FILTER", iconFilterPath) {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtersPanel = new FiltersPanel(rightPanelViewer);
            }
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
        JButton filterButton = add(actionFilterPath);
        resizeButton.setToolTipText("FILTER");
        jSliderResizeImage = new JSlider(JSlider.VERTICAL, -200, 200, 0);
        jSliderResizeImage.addChangeListener(this);
        this.add(jSliderResizeImage);
    }

    /**
     * this is the action listener to the slide bar located in the tool bar
     *
     * @param e recive the event e
     */
    @Override
    public void stateChanged(ChangeEvent e) {


        int resizeValue;
        resizeValue = jSliderResizeImage.getValue();
        rightPanelViewer.zoomImage(resizeValue, rightPanelViewer.getImageIcon());


    }

    public void setSlider() {
        jSliderResizeImage.setValue(0);
    }
}
