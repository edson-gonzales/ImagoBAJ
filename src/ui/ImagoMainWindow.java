package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 7/5/2016.
 */
public class ImagoMainWindow extends JFrame{

    private JPanel containerCenterPanel;
    private RightPanelViewer rightPanel;
    private LeftSearchPanel leftPanel;

    private JMenuBar JMBLeftMenu;
    private JMenu JMArchivo;
    private JMenu JMEdit;

    private JMenuItem JMIOpen;
    private JMenuItem JMISave;
    private JMenuItem JMIExit;

    /**
     * This is the class constructor charging methods instance and add the components
       recive the "title" of the frame of the Main class
     * @param title
     */
    public ImagoMainWindow(String title)
    {
        super(title);
        initComponents();
        addComponents();

    }
    /**
     * This method instance the UI objects
     */

    public void initComponents()
    {

        JMIOpen=new JMenuItem("Open File");
        JMISave=new JMenuItem("Save File");
        JMIExit=new JMenuItem("Exit");

        JMBLeftMenu= new JMenuBar();
        JMArchivo=new JMenu("Archivo");
        JMEdit=new JMenu("Edit");

        leftPanel= new LeftSearchPanel();
        rightPanel=new RightPanelViewer("");
        containerCenterPanel=new JPanel();

    }

    /**
     * This method adds the components to the main frame
     */
    public void addComponents()
    {   //Menu Item
        JMArchivo.add(JMIOpen);
        JMArchivo.add(JMISave);
        JMArchivo.add(JMIExit);
        //Menu
        JMBLeftMenu.add(JMArchivo);
        JMBLeftMenu.add(JMEdit);
        this.setJMenuBar(JMBLeftMenu);

        containerCenterPanel.setLayout(new GridLayout(1,2));
        containerCenterPanel.add(leftPanel);
        containerCenterPanel.add(rightPanel);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(containerCenterPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300,800);
    }
}
