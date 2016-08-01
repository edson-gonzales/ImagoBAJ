package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * THis class is the container of the left and right panel
 */
public class ImagoMainWindow extends JFrame implements ActionListener {
    public LeftSearchPanel leftPanel;
    public RightPanelViewer rightPanelViewer;
    public JPanel centerPanel;
    public JMenu jMenuFile, jMenuEdit, jMenuOpen, jMenuExit, jMenuHelp;
    public JMenuItem jMenuAbout;
    public JMenuBar optionsMenuBar;

    /**
     * Contructor init the methods that are in charge of drawing the frame
     */
    public ImagoMainWindow() {
        super("IMAGO");
        initComponents();
        addComponents();
        menuOption();
    }

    /**
     * this is the Menu in the top of the Frame
     */
    public void menuOption() {
        optionsMenuBar = new JMenuBar();
        jMenuFile = new JMenu("FILE");
        jMenuEdit = new JMenu("EDIT");
        jMenuHelp = new JMenu("HELP");

        jMenuOpen = new JMenu("Open File");
        jMenuExit = new JMenu("Exit");
        jMenuAbout = new JMenuItem("About");
        jMenuAbout.addActionListener(this);

        jMenuHelp.add(jMenuAbout);
        jMenuFile.add(jMenuOpen);
        jMenuFile.add(jMenuExit);

        optionsMenuBar.add(jMenuFile);
        optionsMenuBar.add(jMenuEdit);
        optionsMenuBar.add(jMenuHelp);
        this.add(optionsMenuBar, BorderLayout.NORTH);
    }

    /**
     * here the components are initialized
     * Jpanels left and right
     */
    public void initComponents() {
        rightPanelViewer = new RightPanelViewer();
        leftPanel = new LeftSearchPanel(rightPanelViewer);
        centerPanel = new JPanel();
        centerPanel.setBackground(Color.blue);
        centerPanel.setLayout(new GridLayout(1, 2));
    }

    /**
     * this method adds the component to the Frame and set de size
     */
    public void addComponents() {
        centerPanel.add(leftPanel);
        centerPanel.add(rightPanelViewer);
        this.getContentPane().setLayout(new BorderLayout());
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
        if (eventoMenu.getSource() == jMenuAbout) {
            JOptionPane.showMessageDialog(null, "Develop by: Alvaro Daza and Bruno Vasquez \n" +
                    "Imago is a simple application which performs the basic functions \n resize, rotate and apply to an image flters");
        }
    }
}
