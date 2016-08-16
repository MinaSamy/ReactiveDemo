package net.minasamy.reactiveprogrammingdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import net.minasamy.reactiveprogrammingdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minsamy on 7/30/2016.
 */
public class ObservableConcept implements Parcelable {


    static public enum ConceptLevel {
        BASIC, MEDIUM, ADVANCED
    }

    public enum ConceptType {
        BASIC_OBSERVABLE,
        OBSERVABLE_FROM,
        OBSERVABLE_JUST,
        PUBLISH_SUBJECT,
        BEHAVIOR_SUBJECT,
        REPLAY_SUBJECT,
        ASYNC_SUBJECT,
        REPEAT,
        DEFER,
        RANGE,
        INTERVAL,
        TIMER,
        FILTER,
        TAKE,
        TAKE_LAST,
        DISTINCT,
        DISTINCT_UNTIL_CHANGED,
        FIRST,
        LAST,
        SKIP,
        SKIP_LAST
    }

    private int titleResourceId;
    private int descriptionResourceId;


    private int shortDescriptionResourceId;
    private ConceptLevel level;

    public ConceptType getDemoItemType() {
        return demoItemType;
    }

    private ConceptType demoItemType;

    public ObservableConcept(int titleResourceId, int descriptionResourceId, int shortDescriptionResourceId, ConceptLevel level, ConceptType type) {
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


    private ObservableConcept(Parcel in) {
        titleResourceId = in.readInt();
        descriptionResourceId = in.readInt();
        shortDescriptionResourceId = in.readInt();
        level = (ConceptLevel) in.readSerializable();
        demoItemType = (ConceptType) in.readSerializable();
    }


    public static final Creator<ObservableConcept> CREATOR = new Creator<ObservableConcept>() {
        @Override
        public ObservableConcept createFromParcel(Parcel in) {
            return new ObservableConcept(in);
        }

        @Override
        public ObservableConcept[] newArray(int size) {
            return new ObservableConcept[size];
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

    static public List<ObservableConcept> getSampleData() {
        return new ArrayList<ObservableConcept>() {
            {
                add(new ObservableConcept(R.string.observable, R.string.observable_desc, R.string.observable_short_desc, ConceptLevel.BASIC, ConceptType.BASIC_OBSERVABLE));
                add(new ObservableConcept(R.string.observable_from, R.string.observable_from_desc, R.string.observable_from_short_desc, ConceptLevel.BASIC, ConceptType.OBSERVABLE_FROM));
                add(new ObservableConcept(R.string.observable_just, R.string.observable_just_desc, R.string.observable_just_short_desc, ConceptLevel.BASIC, ConceptType.OBSERVABLE_JUST));
                add(new ObservableConcept(R.string.publish_subject, R.string.publish_subject_desc, R.string.publish_subject_short_desc, ConceptLevel.MEDIUM, ConceptType.PUBLISH_SUBJECT));
                add(new ObservableConcept(R.string.behavior_subject, R.string.behavior_subject_desc, R.string.behavior_subject_short_desc, ConceptLevel.MEDIUM, ConceptType.BEHAVIOR_SUBJECT));
                add(new ObservableConcept(R.string.replay_subject, R.string.replay_subject_desc, R.string.replay_subject_short_desc, ConceptLevel.MEDIUM, ConceptType.REPLAY_SUBJECT));
                add(new ObservableConcept(R.string.async_subject, R.string.async_subject_desc, R.string.async_subject_short_desc, ConceptLevel.MEDIUM, ConceptType.ASYNC_SUBJECT));
                add(new ObservableConcept(R.string.repeat, R.string.repeat_desc, R.string.repeat_short_desc, ConceptLevel.MEDIUM, ConceptType.REPEAT));
                add(new ObservableConcept(R.string.defer, R.string.defer_desc, R.string.defer_short_desc, ConceptLevel.MEDIUM, ConceptType.DEFER));
                add(new ObservableConcept(R.string.range, R.string.range_desc, R.string.range_short_desc, ConceptLevel.MEDIUM, ConceptType.RANGE));
                add(new ObservableConcept(R.string.interval, R.string.interval_desc, R.string.interval_short_desc, ConceptLevel.MEDIUM, ConceptType.INTERVAL));
                add(new ObservableConcept(R.string.timer,R.string.timer_desc,R.string.timer_short_desc,ConceptLevel.MEDIUM,ConceptType.TIMER));
                add(new ObservableConcept(R.string.filter,R.string.filter_desc,R.string.filter_short_desc,ConceptLevel.MEDIUM,ConceptType.FILTER));
                add(new ObservableConcept(R.string.take,R.string.take_desc,R.string.take_short_desc,ConceptLevel.MEDIUM,ConceptType.TAKE));
                add(new ObservableConcept(R.string.take_last,R.string.take_last_desc,R.string.take_last_short_desc,ConceptLevel.MEDIUM,ConceptType.TAKE_LAST));
                add(new ObservableConcept(R.string.distinct,R.string.distinct_desc,R.string.distinct_short_desc,ConceptLevel.MEDIUM,ConceptType.DISTINCT));
                add(new ObservableConcept(R.string.distinct_until_changed,R.string.distinct_until_changed_desc,R.string.distinct_until_changed_short_desc,ConceptLevel.MEDIUM,ConceptType.DISTINCT_UNTIL_CHANGED));
                add(new ObservableConcept(R.string.first,R.string.first_desc,R.string.first_short_desc,ConceptLevel.MEDIUM,ConceptType.FIRST));
                add(new ObservableConcept(R.string.last,R.string.last_desc,R.string.last_short_desc,ConceptLevel.MEDIUM,ConceptType.LAST));
                add(new ObservableConcept(R.string.skip,R.string.skip_desc,R.string.skip_short_desc,ConceptLevel.MEDIUM,ConceptType.SKIP));
                add(new ObservableConcept(R.string.skip_last,R.string.skip_last,R.string.skip_last_desc,ConceptLevel.MEDIUM,ConceptType.SKIP_LAST));
            }
        };
    }
}
