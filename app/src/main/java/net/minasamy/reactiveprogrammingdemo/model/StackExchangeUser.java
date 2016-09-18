package net.minasamy.reactiveprogrammingdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mina.Samy on 9/8/2016.
 */
public class StackExchangeUser {
    @SerializedName("display_name")
    public String name;

    @SerializedName("profile_image")
    public String profileImageUrl;

    @SerializedName("link")
    public String profileLink;

    @SerializedName("reputation")
    public int reputation;

    @SerializedName("badge_counts")
    public BadgeCounts badgeCounts;
}
