package net.minasamy.reactiveprogrammingdemo.model;

import android.content.Context;

import net.minasamy.reactiveprogrammingdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mina.Samy on 8/14/2016.
 */
public class Sample {
    private String title;
    private String description;
    private int id;

    public static final int APPS_LIST_ID=0;
    public static final int STACK_EXCHANGE_ID=1;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Sample(int id, String description, String title) {
        this.description = description;
        this.title = title;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public static List<Sample> getData(final Context context) {
        List<Sample> items = new ArrayList<Sample>() {
            {
                add(new Sample(APPS_LIST_ID,context.getString(R.string.apps_list), context.getString(R.string.apps_list_desc)));
                add(new Sample(STACK_EXCHANGE_ID,context.getString(R.string.stack_exchange),context.getString(R.string.stack_exchange_desc)));
            }
        };
        return items;
    }
}
