package net.minasamy.reactiveprogrammingdemo.adapter;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.minasamy.reactiveprogrammingdemo.ObservableDetailsActivity;
import net.minasamy.reactiveprogrammingdemo.R;
import net.minasamy.reactiveprogrammingdemo.model.DemoItem;
import net.minasamy.reactiveprogrammingdemo.ui.UiUtils;

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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleTextView;
        private TextView mDescriptionTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView.findViewById(R.id.title_text);
            mDescriptionTextView = (TextView) itemView.findViewById(R.id.desc_text);
            itemView.setOnClickListener(this);
        }

        public void setData(DemoItem item) {
            mTitleTextView.setText(item.getTitleResourceId());
            mDescriptionTextView.setText(item.getDescriptionResourceId());
        }

        @Override
        public void onClick(View v) {
            int itemPosition = this.getAdapterPosition();
            DemoItem item = mDataSet.get(itemPosition);
            Intent intent = ObservableDetailsActivity.makeIntent(this.itemView.getContext(), item);
            final Animator animator = UiUtils.makeCardViewClickAnimation(v);
            v.post(new Runnable() {
                @Override
                public void run() {
                    animator.start();
                }
            });
            Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) this.itemView.getContext(),
                    v, v.getResources().getString(R.string.transition_card_view)).toBundle();
            this.itemView.getContext().startActivity(intent, bundle);
            //ActivityOptionsCompat.makeCustomAnimation(R.anim.slide_from_right,R.anim.slide_from_right)

        }
    }

}
