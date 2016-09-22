package net.minasamy.reactiveprogrammingdemo;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import net.minasamy.reactiveprogrammingdemo.adapter.AppsRecyclerViewAdapter;
import net.minasamy.reactiveprogrammingdemo.util.Utils;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AppListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Subscription mSubscription;
    private List<ApplicationInfo> mApps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll().penaltyLog().build());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll().penaltyLog()
                    .build());
        }

        setContentView(R.layout.activity_app_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.appsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        final AppsRecyclerViewAdapter adapter = new AppsRecyclerViewAdapter(getApplicationContext(), mApps);
        mRecyclerView.setAdapter(adapter);

        //load mApps list
        mSubscription = Observable.from(Utils.getAppsList(getApplicationContext()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .buffer(3)
                .subscribe(new Observer<List<ApplicationInfo>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<ApplicationInfo> applicationInfos) {
                        mApps.addAll(applicationInfos);
                    }
                });
    }


    @Override
    protected void onStop() {
        mSubscription.unsubscribe();
        super.onStop();
    }
}
