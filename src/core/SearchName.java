package core;

import java.io.File;

/**
 * Created by hp-bruno on 09/07/2016.
 */
public class SearchName implements SearchStrategy{

    @Override
    public boolean search(File image, String input) {
        String name = image.getName();
        if(name.equals(input))
        {    return true; }
        else
        {    return false; }
    }

}