package net.minasamy.reactiveprogrammingdemo.model;

import android.graphics.drawable.Drawable;

/**
 * Created by mab on 8/15/16.
 */
public class AppInfo {
    private Drawable logo;
    private String label;

    public AppInfo(Drawable logo, String label) {
        this.logo = logo;
        this.label = label;
    }

    public Drawable getLogo() {
        return logo;
    }

    public String getLabel() {
        return label;
    }
}
