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

    static public enum DemoItemType {
        BASIC_OBSERVABLE,
        OBSERVABLE_FROM,
        OBSERVABLE_JUST,
        PUBLISH_SUBJECT,
        BEHAVIOR_SUBJECT,
        REPLAY_SUBJECT,
        ASYNC_SUBJECT
    }

    private int titleResourceId;
    private int descriptionResourceId;


    private int shortDescriptionResourceId;
    private ConceptLevel level;

    public DemoItemType getDemoItemType() {
        return demoItemType;
    }

    private DemoItemType demoItemType;

    public DemoItem(int titleResourceId, int descriptionResourceId, int shortDescriptionResourceId, ConceptLevel level, DemoItemType type) {
        this.titleResourceId = titleResourceId;
        this.descriptionResourceId = descriptionResourceId;
        this.shortDescriptionResourceId = shortDescriptionResourceId;
        this.level = level;
        this.demoItemType = type;
    }


    public int getTitleResourceId() {
        return titleResourceId;
    }

    public int getDescriptionResourceId() {
        return descriptionResourceId;
    }

    public int getShortDescriptionResourceId() {
        return shortDescriptionResourceId;
    }

    public ConceptLevel getLevel() {
        return level;
    }


    private DemoItem(Parcel in) {
        titleResourceId = in.readInt();
        descriptionResourceId = in.readInt();
        shortDescriptionResourceId = in.readInt();
        level = (ConceptLevel) in.readSerializable();
        demoItemType = (DemoItemType) in.readSerializable();
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
        dest.writeInt(shortDescriptionResourceId);
        dest.writeSerializable(level);
        dest.writeSerializable(demoItemType);
    }

    static public List<DemoItem> getSampleData() {
        return new ArrayList<DemoItem>() {
            {
                add(new DemoItem(R.string.observable, R.string.observable_desc, R.string.observable_short_desc, ConceptLevel.BASIC, DemoItemType.BASIC_OBSERVABLE));
                add(new DemoItem(R.string.observable_from, R.string.observable_from_desc, R.string.observable_from_short_desc, ConceptLevel.BASIC, DemoItemType.OBSERVABLE_FROM));
                add(new DemoItem(R.string.observable_just, R.string.observable_just_desc, R.string.observable_just_short_desc, ConceptLevel.BASIC, DemoItemType.OBSERVABLE_JUST));
                add(new DemoItem(R.string.publish_subject,R.string.publish_subject_desc,R.string.publish_subject_short_desc,ConceptLevel.MEDIUM,DemoItemType.PUBLISH_SUBJECT));
                add(new DemoItem(R.string.behavior_subject,R.string.behavior_subject_desc,R.string.behavior_subject_short_desc,ConceptLevel.MEDIUM,DemoItemType.BEHAVIOR_SUBJECT));
                add(new DemoItem(R.string.replay_subject,R.string.replay_subject_desc,R.string.replay_subject_short_desc,ConceptLevel.MEDIUM,DemoItemType.REPLAY_SUBJECT));
                add(new DemoItem(R.string.async_subject,R.string.async_subject_desc,R.string.async_subject_short_desc,ConceptLevel.MEDIUM,DemoItemType.ASYNC_SUBJECT));
            }
        };
    }
}
