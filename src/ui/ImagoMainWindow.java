package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ResourceBundle;

/**
 * THis class is the container of the left and right panel
 */
public class ImagoMainWindow extends JFrame implements ActionListener {

    private JPanel panelTool;
    private ToolBarLeftPanel toolBarLeftPanel;
    public JTabbedPane leftPanels;
    public RightPanelViewer rightPanelViewer;
    public JPanel centerPanel;
    public JMenu jMenuFile, jMenuHelp;
    public JMenuItem jMenuAbout, jMenuExit, jMenuOpen;
    public JMenuBar optionsMenuBar;
    public LeftSearchPanel leftSearchPanel;
    public LeftSearchDirectoryPanel leftSearchDirectoryPanel;
    private static final String FILENAME = "ui/LabelsBundle";
    ResourceBundle labels;

    /**
     * Contructor init the methods that are in charge of drawing the frame
     */
    public ImagoMainWindow() {
        super("IMAGO");
        labels = labels.getBundle(FILENAME);
        initComponents();
        addComponents();
        menuOption();
    }

    /**
     * this is the Menu in the top of the Frame
     */
    public void menuOption() {
        optionsMenuBar = new JMenuBar();
        jMenuFile = new JMenu(labels.getString("Imago.MainWindow.MenuFileFile"));
        jMenuFile.setFont(new Font("Segoe Print", Font.BOLD, 15));
        jMenuHelp = new JMenu(labels.getString("Imago.MainWindow.MenuFileHelp"));
        jMenuHelp.setFont(new Font("Segoe Print", Font.BOLD, 15));
        jMenuOpen = new JMenuItem(labels.getString("Imago.MainWindow.MenuFileItemOpenFile"));
        jMenuOpen.addActionListener(this);
        jMenuExit = new JMenuItem(labels.getString("Imago.MainWindow.MenuFileItemExit"));
        jMenuExit.addActionListener(this);
        jMenuAbout = new JMenuItem(labels.getString("Imago.MainWindow.MenuHelpItemAbout"));
        jMenuAbout.addActionListener(this);
        jMenuHelp.add(jMenuAbout);
        jMenuFile.add(jMenuOpen);
        jMenuFile.add(jMenuExit);
        optionsMenuBar.add(jMenuFile);
        optionsMenuBar.add(jMenuHelp);
        this.add(optionsMenuBar, BorderLayout.NORTH);
    }

    /**
     * here the components are initialized
     * Jpanels left and right
     */
    public void initComponents() {

        panelTool = new JPanel();
        panelTool.setLayout(new BoxLayout(panelTool, BoxLayout.Y_AXIS));
        rightPanelViewer = new RightPanelViewer();
        leftPanels = new JTabbedPane();
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));
        leftSearchPanel = new LeftSearchPanel(rightPanelViewer);
        leftSearchDirectoryPanel = new LeftSearchDirectoryPanel(rightPanelViewer, leftSearchPanel);
        leftSearchPanel.setLeftSearchDirectoryPanel(leftSearchDirectoryPanel);
        leftPanels.addTab("Icons View", leftSearchPanel);
        leftPanels.setFont(new Font("Segoe Print", Font.BOLD, 15));
        leftPanels.addTab("Directory View", leftSearchDirectoryPanel);
        toolBarLeftPanel = new ToolBarLeftPanel(leftSearchPanel, leftSearchDirectoryPanel);
    }

    /**
     * this method adds the component to the Frame and set de size
     */
    public void addComponents() {
        centerPanel.add(leftPanels);
        centerPanel.add(rightPanelViewer);
        panelTool.add(toolBarLeftPanel);

        this.getContentPane().setLayout(new BorderLayout());
        this.add(panelTool, BorderLayout.WEST);
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 1000);
    }

    /**
     * this is the  action performed of the button about located in the menu in the Help button
     *
     * @param eventoMenu this is the event of the action listener
     */
    @Override
    public void actionPerformed(ActionEvent eventoMenu) {

        if (eventoMenu.getSource() == jMenuOpen) {

            File selection = toolBarLeftPanel.fileChooser();
            leftSearchPanel.updatePanel(selection);
            leftSearchPanel.setFile(selection);

            leftSearchDirectoryPanel.updateDirectoryPanel(selection);
            leftSearchDirectoryPanel.setFile(selection);
        }
        if (eventoMenu.getSource() == jMenuExit) {
            System.exit(0);
        }
        if (eventoMenu.getSource() == jMenuAbout) {
            JOptionPane.showMessageDialog(null, "Develop by: Alvaro Daza and Bruno Vasquez \n" +
                    "Imago is a simple application which performs the basic functions \n" +
                    " resize, rotate and apply to an image flters");
        }
    }
}
