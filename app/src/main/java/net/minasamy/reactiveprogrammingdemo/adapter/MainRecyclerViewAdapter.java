package net.minasamy.reactiveprogrammingdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.minasamy.reactiveprogrammingdemo.R;
import net.minasamy.reactiveprogrammingdemo.model.DemoItem;

import java.util.List;

/**
 * Created by minsamy on 7/31/2016.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {

    private List<DemoItem> mDataSet;

    public MainRecyclerViewAdapter(List<DemoItem> dataset) {
        this.mDataSet = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.demo_item_card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        private TextView mDescriptionTextView;
        private Context mContext;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.title_text);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.desc_text);
        }

        public void setData(DemoItem item) {
            mTitleTextView.setText(item.getTitleResourceId());
            mDescriptionTextView.setText(item.getDescriptionResourceId());
        }
    }

}
