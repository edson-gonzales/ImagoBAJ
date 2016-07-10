package core;

import java.io.File;

/**
 * Created by hp-bruno on 09/07/2016.
 */
public class SearchSize implements SearchStrategy{

    @Override
    public boolean search(File image, String input) {
        long sizeLong = image.length();
        String sizeString = String.valueOf(sizeLong);
        if(sizeString.equals(input))
        {    return true; }
        else
        {    return false; }
    }
}
