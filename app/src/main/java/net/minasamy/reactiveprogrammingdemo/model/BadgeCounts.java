package net.minasamy.reactiveprogrammingdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mina.Samy on 9/18/2016.
 */
public class BadgeCounts {
    @SerializedName("gold")
    public int gold;
    @SerializedName("silver")
    public int silver;
    @SerializedName("bronze")
    public int bronze;
}
