package Imago;

import core.Duplicate;
import core.Folder;
import core.Path;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.assertEquals;

/**
 * Created by hp-bruno on 09/07/2016.
 */
public class TestDuplicate {


    @Test
    public void testGetStrategyNameOneImage() {

        Folder files = new Folder();
        String path = "test/Files/directory/otherDirectory";
        File folder = new File(path);
        files.listFilesDirectory(folder);
        Duplicate duplicate = new Duplicate("Name", "img-sprite.png");
        duplicate.searchDuplicate(files);

        assertEquals(1, duplicate.size());
    }

    @Test
    public void testGetStrategyNameTwoImage() {

        Folder files = new Folder();
        String path = "test/Files/directory";
        File folder = new File(path);
        files.listFilesDirectory(folder);
        Duplicate duplicate = new Duplicate("Name", "link.png");
        duplicate.searchDuplicate(files);

        assertEquals(2, duplicate.size());
    }

    @Test
    public void testGetStrategySizeOneImage() {

        Folder files = new Folder();
        Path newPath = new Path();
        String path = newPath.getNewPath() + "test/Files";

        File folder = new File(path);
        files.listFilesDirectory(folder);
        Duplicate duplicate = new Duplicate("Size", "5519");
        duplicate.searchDuplicate(files);

        assertEquals(1, duplicate.size());
    }

    @Test
    public void testGetStrategySizeTwoImage() {

        Folder files = new Folder();
        String path = "test/Files";
        File folder = new File(path);
        files.listFilesDirectory(folder);
        Duplicate duplicate = new Duplicate("Size", "422");
        duplicate.searchDuplicate(files);

        assertEquals(2, duplicate.size());
    }

    @Test
    public void testGetStrategyTypePng() {

        Folder files = new Folder();
        String path = "test/Files";
        File folder = new File(path);
        files.listFilesDirectory(folder);
        Duplicate duplicate = new Duplicate("Png", ".png");
        duplicate.searchTypeDuplicate(files);

        assertEquals(6, duplicate.size());
    }

    @Test
    public void testGetStrategyTypeJpeg() {

        Folder files = new Folder();
        String path = "test/Files";
        File folder = new File(path);
        files.listFilesDirectory(folder);
        Duplicate duplicate = new Duplicate("Jpeg", ".jpeg");
        duplicate.searchTypeDuplicate(files);

        assertEquals(4, duplicate.size());
    }

}
