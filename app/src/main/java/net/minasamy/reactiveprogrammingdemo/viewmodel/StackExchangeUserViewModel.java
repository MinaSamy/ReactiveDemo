package net.minasamy.reactiveprogrammingdemo.viewmodel;

import net.minasamy.reactiveprogrammingdemo.model.BadgeCounts;
import net.minasamy.reactiveprogrammingdemo.model.StackExchangeUser;

/**
 * Created by Mina.Samy on 9/18/2016.
 */
public class StackExchangeUserViewModel {

    private StackExchangeUser mUser;

    public StackExchangeUserViewModel(StackExchangeUser user){
        this.mUser=user;
    }

    public String getDisplayName(){
        return this.mUser.name;
    }

    public int getReputation(){
        return this.mUser.reputation;
    }

    public BadgeCounts getBadges(){
        return this.mUser.badgeCounts;
    }
}
