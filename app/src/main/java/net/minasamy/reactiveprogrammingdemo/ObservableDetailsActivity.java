package net.minasamy.reactiveprogrammingdemo;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import net.minasamy.reactiveprogrammingdemo.model.DemoItem;
import net.minasamy.reactiveprogrammingdemo.presenter.DetailsPresenter;
import net.minasamy.reactiveprogrammingdemo.ui.UiUtils;
import net.minasamy.reactiveprogrammingdemo.view.DetailsView;

import java.util.ArrayList;
import java.util.List;

public class ObservableDetailsActivity extends AppCompatActivity implements DetailsView<Integer> {

    private static final String EXTRA_ITEM = "extra_item";
    private ListView mItemsList;
    private ArrayAdapter<String> mAdapter;
    private List<String> mDataSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable_details);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mItemsList = (ListView) findViewById(R.id.items_list);
        ViewCompat.setNestedScrollingEnabled(mItemsList,true);
        mDataSet = new ArrayList<>();
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mDataSet);
        mItemsList.setAdapter(mAdapter);
        if (getIntent().hasExtra(EXTRA_ITEM)) {
            DemoItem demoItem = getIntent().getParcelableExtra(EXTRA_ITEM);
            final DetailsPresenter presenter = new DetailsPresenter(this, demoItem.getDemoItemType());
            TextView detailsTextView=(TextView)findViewById(R.id.details_text);
            CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsingToolbarLayout);
            collapsingToolbarLayout.setTitle(getString(demoItem.getTitleResourceId()));
            detailsTextView.setText(demoItem.getDescriptionResourceId());
            FloatingActionButton playFab = (FloatingActionButton) findViewById(R.id.play_fab);

            //show snackbar
            final Snackbar snackBar=Snackbar.make(findViewById(R.id.coordinator_layout), R.string.demo_hint,Snackbar.LENGTH_INDEFINITE);
            snackBar.setActionTextColor(Color.WHITE);
            snackBar.setAction(R.string.got_it, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackBar.dismiss();
                }
            });
            snackBar.show();
            final Animator animator = UiUtils.makeFabAnimation(playFab);
            animator.start();
            playFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenter.startDemo();
                    animator.cancel();
                }
            });
        }
    }

    static public Intent makeIntent(Context context, DemoItem item) {
        Intent intent = new Intent(context, ObservableDetailsActivity.class);
        intent.putExtra(EXTRA_ITEM, item);
        return intent;
    }

    //Executor mExecutor= new ThreadPoolExecutor(5)

    @Override
    public void onReceiveResult(final Integer result) {
        Log.i("Received", String.valueOf(result));
        mDataSet.add(String.format(getString(R.string.item), result));
        mAdapter.notifyDataSetChanged();
    }
}
