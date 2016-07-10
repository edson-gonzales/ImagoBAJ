package core;

/**
 * Created by Pc- Bruno on 7/10/2016.
 */
public class TypePng implements TypeStrategy{
    @Override
    public boolean searchType(String name) {
        if(name.endsWith(".PNG") || name.endsWith(".png"))
        {    return true; }
        else
        {    return false; }
    }
}
