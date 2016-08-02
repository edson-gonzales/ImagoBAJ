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
        int expectedImageLength = 89196;

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

    @Test
    public void testSizeNewImageFilterInvert() {
        File pathSourceImage = new File("test/Filters/header-bg.jpg");
        File pathDestinyFile = new File("test/Filters/Filter");
        int expectedImageLength = 96807;

        Filters filters = new Filters(pathSourceImage, EnumFilter.INVERT);
        filters.loadFileToBufferedImage(pathDestinyFile);
        File imageGray = new File(pathDestinyFile + "/header-bg.jpg");
        assertEquals(expectedImageLength, imageGray.length());
    }

    @Test
    public void testSizeNewImageFilterColor() {
        File pathSourceImage = new File("test/Filters/header-bg.jpg");
        File pathDestinyFile = new File("test/Filters/Filter");
        int expectedImageLength = 150032;

        Filters filters = new Filters(pathSourceImage, EnumFilter.COLOR);
        filters.loadFileToBufferedImage(pathDestinyFile);
        File imageGray = new File(pathDestinyFile + "/header-bg.jpg");
        assertEquals(expectedImageLength, imageGray.length());
    }

    @Test
    public void testSizeNewImageFilterSharpen() {
        File pathSourceImage = new File("test/Filters/header-bg.jpg");
        File pathDestinyFile = new File("test/Filters/Filter");
        int expectedImageLength = 132246;

        Filters filters = new Filters(pathSourceImage, EnumFilter.SHARPEN);
        filters.loadFileToBufferedImage(pathDestinyFile);
        File imageGray = new File(pathDestinyFile + "/header-bg.jpg");
        assertEquals(expectedImageLength, imageGray.length());
    }

    @Test
    public void testSizeNewImageFilterBlur() {
        File pathSourceImage = new File("test/Filters/header-bg.jpg");
        File pathDestinyFile = new File("test/Filters/Filter");
        int expectedImageLength = 91519;

        Filters filters = new Filters(pathSourceImage, EnumFilter.BLUR);
        filters.loadFileToBufferedImage(pathDestinyFile);
        File imageGray = new File(pathDestinyFile + "/header-bg.jpg");
        assertEquals(expectedImageLength, imageGray.length());
    }

    @Test
    public void testSizeNewImageFilterEdge() {
        File pathSourceImage = new File("test/Filters/header-bg.jpg");
        File pathDestinyFile = new File("test/Filters/Filter");
        int expectedImageLength = 87513;

        Filters filters = new Filters(pathSourceImage, EnumFilter.EDGE);
        filters.loadFileToBufferedImage(pathDestinyFile);
        File imageGray = new File(pathDestinyFile + "/header-bg.jpg");
        assertEquals(expectedImageLength, imageGray.length());
    }

    @Test
    public void testSizeNewImageFilterBlueInvert() {
        File pathSourceImage = new File("test/Filters/header-bg.jpg");
        File pathDestinyFile = new File("test/Filters/Filter");
        int expectedImageLength = 106525;

        Filters filters = new Filters(pathSourceImage, EnumFilter.BLUEINVERT);
        filters.loadFileToBufferedImage(pathDestinyFile);
        File imageGray = new File(pathDestinyFile + "/header-bg.jpg");
        assertEquals(expectedImageLength, imageGray.length());
    }

    @Test
    public void testSizeNewImageFilterPosterize() {
        File pathSourceImage = new File("test/Filters/header-bg.jpg");
        File pathDestinyFile = new File("test/Filters/Filter");
        int expectedImageLength = 102759;

        Filters filters = new Filters(pathSourceImage, EnumFilter.POSTERIZE);
        filters.loadFileToBufferedImage(pathDestinyFile);
        File imageGray = new File(pathDestinyFile + "/header-bg.jpg");
        assertEquals(expectedImageLength, imageGray.length());
    }

    @Test
    public void testSizeNewImageFilterIdentity() {
        File pathSourceImage = new File("test/Filters/header-bg.jpg");
        File pathDestinyFile = new File("test/Filters/Filter");
        int expectedImageLength = 104609;

        Filters filters = new Filters(pathSourceImage, EnumFilter.IDENTITY);
        filters.loadFileToBufferedImage(pathDestinyFile);
        File imageGray = new File(pathDestinyFile + "/header-bg.jpg");
        assertEquals(expectedImageLength, imageGray.length());
    }
}

