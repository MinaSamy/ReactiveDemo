package net.minasamy.reactiveprogrammingdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import net.minasamy.reactiveprogrammingdemo.model.DemoItem;
import net.minasamy.reactiveprogrammingdemo.presenter.DetailsPresenter;
import net.minasamy.reactiveprogrammingdemo.view.DetailsView;

public class ObservableDetailsActivity extends AppCompatActivity implements DetailsView<Integer> {

    private static final String EXTRA_ITEM = "extra_item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra(EXTRA_ITEM)) {
            DemoItem demoItem = getIntent().getParcelableExtra(EXTRA_ITEM);
            DetailsPresenter presenter = new DetailsPresenter(this, demoItem.getDemoItemType());
            presenter.startDemo();
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
    }
}
