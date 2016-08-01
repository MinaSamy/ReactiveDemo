package net.minasamy.reactiveprogrammingdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import net.minasamy.reactiveprogrammingdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minsamy on 7/30/2016.
 */
public class DemoItem implements Parcelable {


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


    private DemoItem(Parcel in) {
        titleResourceId = in.readInt();
        descriptionResourceId = in.readInt();
        level = (ConceptLevel) in.readSerializable();
    }


    public static final Creator<DemoItem> CREATOR = new Creator<DemoItem>() {
        @Override
        public DemoItem createFromParcel(Parcel in) {
            return new DemoItem(in);
        }

        @Override
        public DemoItem[] newArray(int size) {
            return new DemoItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(titleResourceId);
        dest.writeInt(descriptionResourceId);
        dest.writeSerializable(level);
    }

    static public List<DemoItem> getSampleData() {
        return new ArrayList<DemoItem>() {
            {
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
                add(new DemoItem(R.string.observable, R.string.observable_desc, ConceptLevel.BASIC));
            }
        };
    }
}
