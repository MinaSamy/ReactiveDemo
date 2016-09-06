package net.minasamy.reactiveprogrammingdemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Mina.Samy on 9/6/2016.
 */
public class ReactiveDemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
