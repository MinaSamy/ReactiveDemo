package net.minasamy.reactiveprogrammingdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import net.minasamy.reactiveprogrammingdemo.fragment.DemosFragment;
import net.minasamy.reactiveprogrammingdemo.fragment.ReactiveConceptsFragment;
import net.minasamy.reactiveprogrammingdemo.model.SampleItem;


public class MainActivity extends AppCompatActivity implements DemosFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup toolbar
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

    @Override
    public void onListFragmentInteraction(SampleItem item) {

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
