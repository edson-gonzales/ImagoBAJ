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
        File directoryOrigin = new File("test/Filters/header-bg.jpg");
        File directoryDestiny = new File("test/Filters/Filter");


        Filters filters = new Filters(directoryOrigin, EnumFilter.GRAY);
        filters.loadFileToBufferedImage(directoryDestiny);
        File imageGray = new File(directoryDestiny + "/header-bg.jpg");
        assertEquals(89196, imageGray.length());
    }

    @Test
    public void testOriginNotEqualsWithImageFilterGray() {
        File directoryOrigin = new File("test/Filters/header-bg.jpg");
        File directoryDestiny = new File("test/Filters/Filter");


        Filters filters = new Filters(directoryOrigin, EnumFilter.GRAY);
        filters.loadFileToBufferedImage(directoryDestiny);
        File imageGray = new File(directoryDestiny + "/header-bg.jpg");
        assertNotEquals(directoryOrigin.length(), imageGray.length());
    }
}

