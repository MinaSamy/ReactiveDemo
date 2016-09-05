package net.minasamy.reactiveprogrammingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import net.minasamy.reactiveprogrammingdemo.fragment.DemosFragment;
import net.minasamy.reactiveprogrammingdemo.fragment.ReactiveConceptsFragment;
import net.minasamy.reactiveprogrammingdemo.model.Sample;


public class MainActivity extends AppCompatActivity implements DemosFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll().penaltyLog().build());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll().penaltyLog()
                    .build());
        }

        //setup toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    public void onListFragmentInteraction(Sample item) {
        switch (item.getId()) {
            case 0:
            default:
                startActivity(new Intent(this, AppListActivity.class));
                break;
        }
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private static final int FRAGMENTS_COUNT = 2;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                default:
                    return new ReactiveConceptsFragment();
                case 1:
                    return new DemosFragment();
            }
        }

        @Override
        public int getCount() {
            return FRAGMENTS_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                default:
                    return getString(R.string.concepts);
                case 1:
                    return getString(R.string.demo);
            }
        }
    }
}
