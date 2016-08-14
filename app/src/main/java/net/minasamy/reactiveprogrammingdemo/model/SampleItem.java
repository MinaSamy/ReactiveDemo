package net.minasamy.reactiveprogrammingdemo.model;

import android.content.Context;

import net.minasamy.reactiveprogrammingdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mina.Samy on 8/14/2016.
 */
public class SampleItem {
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public SampleItem(String description, String title) {
        this.description = description;
        this.title = title;
    }


    public static List<SampleItem> getData(final Context context) {
        List<SampleItem> items = new ArrayList<SampleItem>() {
            {
                add(new SampleItem(context.getString(R.string.apps_list), context.getString(R.string.apps_list_desc)));
            }
        };
        return items;
    }
}
