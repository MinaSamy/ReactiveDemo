package net.minasamy.reactiveprogrammingdemo.model;

import net.minasamy.reactiveprogrammingdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minsamy on 7/30/2016.
 */
public class DemoItem {

    static public enum ConceptLevel {
        BASIC, MEDIUM, ADVANCED
    }

    private int titleResourceId;
    private int descriptionResourceId;
    private ConceptLevel level;

    public DemoItem(int titleResourceId, int descriptionResourceId, ConceptLevel level) {
        this.titleResourceId = titleResourceId;
        this.descriptionResourceId = descriptionResourceId;
        this.level = level;
    }


    public int getTitleResourceId() {
        return titleResourceId;
    }

    public int getDescriptionResourceId() {
        return descriptionResourceId;
    }

    public ConceptLevel getLevel() {
        return level;
    }


    static public List<DemoItem>getSampleData(){
        return new ArrayList<DemoItem>(){
            {
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable,R.string.observable_desc,ConceptLevel.BASIC));
            }
        };
    }
}
