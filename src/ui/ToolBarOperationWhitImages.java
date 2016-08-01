package ui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;

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
        iconRotatePath = new ImageIcon(ToolBar.class.getResource("../img/rotateIcon32.png"));
        actionRotatePath = new AbstractAction("ROTATE", iconRotatePath) {
            @Override
            public void actionPerformed(ActionEvent e) {

              rotatePanel=new RotatePanel();
            }
        };
        iconResizePath = new ImageIcon(ToolBar.class.getResource("../img/resizeIcon32.png"));
        actionResizePath = new AbstractAction("RESIZE", iconResizePath) {
            @Override
            public void actionPerformed(ActionEvent e) {
                resizePanel = new ResizePanel();
            }
        };
        iconFilterPath = new ImageIcon(ToolBar.class.getResource("../img/filterIcon32.png"));
        actionFilterPath = new AbstractAction("FILTER", iconFilterPath) {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtersPanel=new FiltersPanel();

            }
        };
        jSliderResizeImage=new JSlider(JSlider.VERTICAL,0,100,50);
        jSliderResizeImage.addChangeListener(this);

    }

    /**
     * add the components to the toolbar
     */
    public void addComponents() {

        JButton rotateButton = add(actionRotatePath);
        rotateButton.setToolTipText("ROTATE");
        JButton resizeButton = add(actionResizePath);
        resizeButton.setToolTipText("RESIZE");
        JButton filterButton= add(actionFilterPath);
        resizeButton.setToolTipText("FILTER");
        this.add(jSliderResizeImage);
    }

    /**
     * this is the action listener to the slide bar located in the tool bar
     * @param e recive the event e
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        int resizeValue;
        resizeValue=jSliderResizeImage.getValue();
        System.out.println(resizeValue);

    }
}
