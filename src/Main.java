import logs.MyLogger;
import ui.ImagoMainWindow;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            MyLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }

        JFrame frame = new ImagoMainWindow();
        frame.setVisible(true);
    }
}
