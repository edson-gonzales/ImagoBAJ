package core;

import java.io.File;

/**
 * Created by Pc- Bruno on 7/10/2016.
 */
public class TypeBmp implements TypeStrategy{

    @Override
    public boolean searchType(String name) {
        if(name.endsWith(".BMP") || name.endsWith(".bmp"))
        {    return true; }
        else
        {    return false; }
    }
}
