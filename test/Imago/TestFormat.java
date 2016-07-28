package Imago;

import core.Format;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;

public class TestFormat {

    @Test
    public void testExportImageAnotherFormat() {
        String nameImage = "myIMagePng";
        String pathExport = "test/Format/Export/";
        File fileImage = new File("test/Format/bites422.png");
        Format format = new Format("bmp", fileImage);
        format.fileImageWithNewFormat(pathExport, nameImage);
        File imageExport = new File(pathExport+nameImage+".bmp");

        assertEquals(nameImage+".bmp",imageExport.getName());
    }
}
