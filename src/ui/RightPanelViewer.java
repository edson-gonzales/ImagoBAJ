package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 7/5/2016.
 */
public class RightPanelViewer extends JPanel {

    private ImageIcon imageIcon;
    private JLabel jImage;
    private JPanel rigthPanelViewer;

    public RightPanelViewer(String title) {
        super();
        //setBackground(Color.RED);
        initCOmponents();
        addComponents();

    }

    public void initCOmponents() {
        imageIcon = new ImageIcon("../img/android_vs_iphone.jpg");
        jImage = new JLabel();
        jImage.setIcon(imageIcon);

        //rigthPanelViewer = new JPanel();
        this.setLayout(new BorderLayout());
        this.add(jImage, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void addComponents() {


    }


//    Image image=GenerateImage.toImage(true);  //this generates an image file
//    ImageIcon icon = new ImageIcon(image);
//    JLabel thumb = new JLabel();
//    thumb.setIcon(icon);
}
