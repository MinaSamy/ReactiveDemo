package net.minasamy.reactiveprogrammingdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import net.minasamy.reactiveprogrammingdemo.adapter.AppsRecyclerViewAdapter;
import net.minasamy.reactiveprogrammingdemo.model.AppInfo;
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
    private List<AppInfo> mApps = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.appsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        final AppsRecyclerViewAdapter adapter = new AppsRecyclerViewAdapter(mApps);
        mRecyclerView.setAdapter(adapter);

        //load mApps list
        mSubscription = Observable.from(Utils.getAppsList(getApplicationContext())).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AppInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AppInfo appInfo) {
                        mApps.add(appInfo);
                        adapter.notifyDataSetChanged();
                    }
                });
    }


    @Override
    protected void onStop() {
        mSubscription.unsubscribe();
        super.onStop();
    }
}
