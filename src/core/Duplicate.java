package core;

import java.io.File;
import java.util.ArrayList;
import java.util.*;

/**
 * Created by Administrator on 7/8/2016.
 */
public class Duplicate
{
    private ArrayList<File> duplicate;
    private ArrayList<File> litImage;

    private String strategy;
    private String imput;

    HashMap<String, SearchStrategy> strategyAvailable;
    public Duplicate(String strategy, String imput)
    {
        strategyAvailable = new HashMap<String, SearchStrategy>();
        this.strategy = strategy;
        this.imput = imput;

        duplicate = new ArrayList<>();
    }

    public void searchDuplicate(Folder list)
    {
        strategyAvailable.put("Name", new SearchName());
        strategyAvailable.put("Size", new SearchSize());
        SearchStrategy strategyUsed =  strategyAvailable.get(strategy);
        litImage = list.getListFiles();

        for (File image : litImage) {
            if(strategyUsed.search(image, imput))
             duplicate.add(image);
        }
    }

    public void searchTypeDuplicate(Folder list)
    {
        HashMap<String, TypeStrategy> strategyTypeAvailable = new HashMap<String, TypeStrategy>();
        strategyTypeAvailable.put("Png", new TypePng());
        strategyTypeAvailable.put("Jpeg", new TypeJpeg());
        strategyTypeAvailable.put("Bmp", new TypeBmp());
        TypeStrategy strategyUsed =  strategyTypeAvailable.get(strategy);
        litImage = list.getListFiles();

        for (File image : litImage) {
            String name = image.getName();
            if(strategyUsed.searchType(name))
                duplicate.add(image);
        }
    }

    public int size() {
        return duplicate.size();
    }

    public ArrayList getListDuplicate(){
        return duplicate;
    }
}
