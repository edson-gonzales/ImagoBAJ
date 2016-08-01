package Imago;


import tools.FormatExportImage;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestFormat {

    @Test
    public void testExportImageAnotherFormat() {
        String nameImage = "myIMagePng";
        String pathExport = "test/Format/Export/";
        File fileImage = new File("test/Format/bites422.png");
        FormatExportImage format = new FormatExportImage("bmp", fileImage);
        format.fileImageWithNewFormat(pathExport, nameImage);
        File imageExport = new File(pathExport + nameImage + ".bmp");

        assertEquals(nameImage + ".bmp", imageExport.getName());
    }
}
