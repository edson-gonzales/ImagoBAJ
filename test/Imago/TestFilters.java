package Imago;

import filter.EnumFilter;
import filter.Filters;
import org.junit.Test;
import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Administrator on 7/26/2016.
 */
public class TestFilters {
    @Test
    public void testSizeNewImageFilterGray() {
        File pathSourceImage = new File("test/Filters/header-bg.jpg");
        File pathDestinyFile = new File("test/Filters/Filter");
        int expectedImageLength =  89196;

        Filters filters = new Filters(pathSourceImage, EnumFilter.GRAY);
        filters.loadFileToBufferedImage(pathDestinyFile);
        File imageGray = new File(pathDestinyFile + "/header-bg.jpg");
        assertEquals(expectedImageLength, imageGray.length());
    }

    @Test
    public void testOriginNotEqualsWithImageFilterGray() {
        File pathSourceImage = new File("test/Filters/header-bg.jpg");
        File pathDestinyFile = new File("test/Filters/Filter");


        Filters filters = new Filters(pathSourceImage, EnumFilter.GRAY);
        filters.loadFileToBufferedImage(pathDestinyFile);
        File imageGray = new File(pathDestinyFile + "/header-bg.jpg");
        assertNotEquals(pathSourceImage.length(), imageGray.length());
    }
}

