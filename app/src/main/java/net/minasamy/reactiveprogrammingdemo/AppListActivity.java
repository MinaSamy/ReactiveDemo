package net.minasamy.reactiveprogrammingdemo;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

public class AppListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
