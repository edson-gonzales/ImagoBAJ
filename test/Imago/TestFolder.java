package Imago;

import core.Folder;
import org.junit.*;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 7/5/2016.
 */
public class TestFolder {
    @Test
    public void testNewImageListIsEmpty() {
        Folder files = new Folder();
        String path = "test/Files/Directory/DirectoryEmpty";
        File folder = new File(path);
        files.listFilesDirectory(folder);
        assertEquals(0, files.sizeFile());
    }

    @Test
    public void testGetListRecursive() {
        Folder files = new Folder();
        String path = "test/Files";
        File folder = new File(path);
        files.listFilesDirectory(folder);
        assertEquals(16, files.sizeFile());
    }
}
