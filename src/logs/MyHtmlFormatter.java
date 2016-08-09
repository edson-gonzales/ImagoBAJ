package logs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * This custom formatter formats parts of a log record to a single line.
 *
 * @autor Bruno Vasquez
 */

class MyHtmlFormatter extends Formatter {
    /**
     * this method is called for every log records.
     *
     * @param toRegister an Object LogRecord to log records
     */
     public String format(LogRecord toRegister) {
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.append("<tr>\n");

       if (toRegister.getLevel().intValue() >= Level.WARNING.intValue()) {
            stringBuffer.append("\t<td style=\"color:red\">");
            stringBuffer.append("<b>");
            stringBuffer.append(toRegister.getLevel());
            stringBuffer.append("</b>");
        } else {
            stringBuffer.append("\t<td>");
            stringBuffer.append(toRegister.getLevel());
        }

        stringBuffer.append("</td>\n");
        stringBuffer.append("\t<td>");
        stringBuffer.append(calcDate(toRegister.getMillis()));
        stringBuffer.append("</td>\n");
        stringBuffer.append("\t<td>");
        stringBuffer.append(formatMessage(toRegister));
        stringBuffer.append("</td>\n");
        stringBuffer.append("</tr>\n");

        return stringBuffer.toString();
    }

    /**
     * This method set a format of a date.
     *
     * @param milliSecs an long to set format
     * @return a String whit a date
     */
    private String calcDate(long milliSecs) {
        SimpleDateFormat date_format = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultDate = new Date(milliSecs);
        return date_format.format(resultDate);
    }

    /**
     * This method is called just after the handler using this formatter is created
     *
     * @param handler a object Handler
     * @return a String whit html.
     */
    public String getHead(Handler handler) {
        return "<!DOCTYPE html>\n<head>\n<style>\n"
                + "table { width: 100% }\n"
                + "th { font:bold 10pt Tahoma; }\n"
                + "td { font:normal 10pt Tahoma; }\n"
                + "h1 {font:normal 11pt Tahoma;}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>" + (new Date()) + "</h1>\n"
                + "<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n"
                + "<tr align=\"left\">\n"
                + "\t<th style=\"width:10%\">Loglevel</th>\n"
                + "\t<th style=\"width:15%\">Time</th>\n"
                + "\t<th style=\"width:75%\">Log Message</th>\n"
                + "</tr>\n";
    }

    /**
     * This method is called just after the handler using this formatter is closed.
     *
     * @param handler a object Handler
     * @return a String whit html.
     */
    public String getTail(Handler handler) {
        return "</table>\n</body>\n</html>";
    }
}