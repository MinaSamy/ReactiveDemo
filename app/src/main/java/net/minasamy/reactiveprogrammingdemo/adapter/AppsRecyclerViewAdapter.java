package net.minasamy.reactiveprogrammingdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.minasamy.reactiveprogrammingdemo.R;
import net.minasamy.reactiveprogrammingdemo.model.AppInfo;

import java.util.List;

/**
 * Created by Mina.Samy on 8/15/2016.
 */
public class AppsRecyclerViewAdapter extends RecyclerView.Adapter<AppsRecyclerViewAdapter.AppViewHolder> {

    private List<AppInfo> mDataSet;

    public AppsRecyclerViewAdapter(List<AppInfo> dataset) {
        this.mDataSet = dataset;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AppViewHolder viewHolder = new AppViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_list_item, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        holder.setItem(mDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    class AppViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mAppIcon;
        private final TextView mAppName;

        public AppViewHolder(View itemView) {
            super(itemView);
            mAppIcon = (ImageView) itemView.findViewById(R.id.app_icon);
            mAppName = (TextView) itemView.findViewById(R.id.app_name_text);
        }


        public void setItem(AppInfo appInfo) {
            mAppIcon.setImageDrawable(appInfo.getLogo());
            mAppName.setText(appInfo.getLabel());
        }
    }
}
