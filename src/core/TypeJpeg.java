package core;

/**
 * Created by Pc- Bruno on 7/10/2016.
 */
public class TypeJpeg implements TypeStrategy {

    @Override
    public boolean searchType(String name) {
        if(name.endsWith(".JPG") || name.endsWith(".jpg"))
        {    return true; }
        else
        {    return false; }
    }
}
