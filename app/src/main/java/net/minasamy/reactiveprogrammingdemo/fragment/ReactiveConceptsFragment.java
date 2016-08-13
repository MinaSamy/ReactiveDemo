package net.minasamy.reactiveprogrammingdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.minasamy.reactiveprogrammingdemo.R;
import net.minasamy.reactiveprogrammingdemo.adapter.MainRecyclerViewAdapter;
import net.minasamy.reactiveprogrammingdemo.model.DemoItem;
import net.minasamy.reactiveprogrammingdemo.ui.MainRecyclerViewItemDecoration;


public class ReactiveConceptsFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public ReactiveConceptsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmetnView = inflater.inflate(R.layout.fragment_reactive_concepts, container, false);
        mRecyclerView = (RecyclerView) fragmetnView.findViewById(R.id.main_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        //configure the layout manager
        if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
            //for tablets it's an instance of GridLayoutManager
            GridLayoutManager gridLayoutManager = (GridLayoutManager) mRecyclerView.getLayoutManager();
            gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
            gridLayoutManager.setSpanCount(3);
        } else {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mRecyclerView.getLayoutManager();
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        }

        //specify the adapter
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(DemoItem.getSampleData());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new MainRecyclerViewItemDecoration());
        return fragmetnView;
    }
}
