package net.minasamy.reactiveprogrammingdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mina.Samy on 9/8/2016.
 */
public class StackExchangeUser {
    @SerializedName("display_name")
    private String name;

    @SerializedName("profile_image")
    private String profileImageUrl;

    @SerializedName("link")
    private String profileLink;

    @SerializedName("reputation")
    private int reputation;
}
