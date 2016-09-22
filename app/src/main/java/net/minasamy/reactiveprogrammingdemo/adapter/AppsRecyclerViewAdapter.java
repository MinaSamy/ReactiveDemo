package net.minasamy.reactiveprogrammingdemo.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.minasamy.reactiveprogrammingdemo.R;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mina.Samy on 8/15/2016.
 */
public class AppsRecyclerViewAdapter extends RecyclerView.Adapter<AppsRecyclerViewAdapter.AppViewHolder> {

    private List<ApplicationInfo> mDataSet;
    private PackageManager mPackageManager;
    private LruCache<Integer, Drawable> mMemoryCache;
    private ThreadPoolExecutor mExecutor;

    public AppsRecyclerViewAdapter(Context context, List<ApplicationInfo> dataset) {
        this.mDataSet = dataset;
        mPackageManager = context.getPackageManager();

        mMemoryCache = new LruCache<>(5 * 1024 * 1024); //5 MB

        int numberOfCores = Runtime.getRuntime().availableProcessors() * 2;
        mExecutor = new ThreadPoolExecutor(numberOfCores, numberOfCores, 10,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
    }

    private void addIconToCache(int key, Drawable bmp) {
        mMemoryCache.put(key, bmp);
    }

    private Drawable getAppIcon(int key) {
        return mMemoryCache.get(key);
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

        Handler mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                mAppIcon.setImageDrawable((Drawable) msg.obj);
            }
        };

        public AppViewHolder(View itemView) {
            super(itemView);
            mAppIcon = (ImageView) itemView.findViewById(R.id.app_icon);
            mAppName = (TextView) itemView.findViewById(R.id.app_name_text);
        }


        public void setItem(final ApplicationInfo appInfo) {
            mAppName.setText(appInfo.loadLabel(mPackageManager));
            mExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Drawable icon = getAppIcon(appInfo.uid);
                    if (icon == null) {
                        icon = appInfo.loadIcon(mPackageManager);
                        addIconToCache(appInfo.uid, icon);
                    }

                    Message msg = new Message();
                    msg.obj = icon;
                    mHandler.sendMessage(msg);
                }
            });
        }
    }
}
