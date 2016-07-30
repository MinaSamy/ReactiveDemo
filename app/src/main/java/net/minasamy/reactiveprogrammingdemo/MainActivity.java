package net.minasamy.reactiveprogrammingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.minasamy.reactiveprogrammingdemo.adapter.MainRecyclerViewAdapter;
import net.minasamy.reactiveprogrammingdemo.model.DemoItem;
import net.minasamy.reactiveprogrammingdemo.ui.MainRecyclerViewItemDecoration;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.main_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        //configure the layout manager
        if(mRecyclerView.getLayoutManager() instanceof LinearLayoutManager){
            LinearLayoutManager linearLayoutManager=(LinearLayoutManager)mRecyclerView.getLayoutManager();
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            //linearLayoutManager.set
        }else{
            //for tablets it's an instance of GridLayoutManager
            GridLayoutManager gridLayoutManager=(GridLayoutManager)mRecyclerView.getLayoutManager();
            gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
            gridLayoutManager.setSpanCount(5);
        }

        //specify the adapter
        MainRecyclerViewAdapter adapter=new MainRecyclerViewAdapter(DemoItem.getSampleData());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new MainRecyclerViewItemDecoration());
    }
}
