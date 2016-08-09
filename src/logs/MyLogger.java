package logs;
import java.io.IOException;
import java.util.logging.*;
/**
 * This class set the global variable to logging .
 *
 * @autor Bruno Vasquez
 */
public class MyLogger {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static private FileHandler fileHTML;
    static private Formatter formatterHTML;
    /**
     * It is the method that set the variable global
     * to write in the files txt and html.
     */
    static public void setup() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }
        logger.setLevel(Level.INFO);
        fileTxt = new FileHandler("src/logs/Logging.txt");
        fileHTML = new FileHandler("src/logs/Logging.html");
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
        formatterHTML = new MyHtmlFormatter();
        fileHTML.setFormatter(formatterHTML);
        logger.addHandler(fileHTML);
    }
}

