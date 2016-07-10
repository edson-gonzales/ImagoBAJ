package core;
import java.util.*;
import java.io.File;

/**
 * Created by Administrator on 7/5/2016.
 */
public class Folder
{

    private ArrayList<File> files;

    public Folder()
    {
          files= new ArrayList<>();
    }


    public void addFile(File file)
    {
        files.add(file);
    }

    public int sizeFile()
    {
        return files.size();
    }

    public ArrayList getListFiles()
    {
        return files;
    }

    public ArrayList<File> listFilesDirectory(File path){
        File[] listOfFiles = path.listFiles();


        for (int position=0;position<listOfFiles.length;position++)
        {

            if (listOfFiles[position].isDirectory())
            {
                listFilesDirectory(listOfFiles[position]);
            }
            else
            {
                addFile(listOfFiles[position]);
            }
        }
        return files;
    }

}
