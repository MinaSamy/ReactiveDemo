package net.minasamy.reactiveprogrammingdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import net.minasamy.reactiveprogrammingdemo.adapter.StackExchangeUsersAdapter;
import net.minasamy.reactiveprogrammingdemo.model.StackExchangeUser;
import net.minasamy.reactiveprogrammingdemo.service.StackExchangeService;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StackExchangeActivity extends AppCompatActivity {

    private List<StackExchangeUser> mUsers=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_stack_exchange);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView usersRecyclerView=(RecyclerView)findViewById(R.id.users_recycler_view);
        usersRecyclerView.setHasFixedSize(true);
        final StackExchangeUsersAdapter adapter=new StackExchangeUsersAdapter(mUsers);
        usersRecyclerView.setAdapter(adapter);

        //retrieve contributors
        StackExchangeService service=new StackExchangeService();
        service.getStackExchangeApi().getTopContributers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<StackExchangeUser>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<StackExchangeUser> stackExchangeUsers) {
                        mUsers.addAll(stackExchangeUsers);
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}
