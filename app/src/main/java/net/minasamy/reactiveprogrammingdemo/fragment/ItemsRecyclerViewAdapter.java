package net.minasamy.reactiveprogrammingdemo.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.minasamy.reactiveprogrammingdemo.R;
import net.minasamy.reactiveprogrammingdemo.fragment.DemosFragment.OnListFragmentInteractionListener;
import net.minasamy.reactiveprogrammingdemo.model.SampleItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SampleItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder> {

    private final List<SampleItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public ItemsRecyclerViewAdapter(List<SampleItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sample_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final SampleItem item = mValues.get(position);
        holder.setDataItem(item);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View mView;
        private final TextView mTitleText;
        private final TextView mDescriptionText;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleText = (TextView) view.findViewById(R.id.item_title);
            mDescriptionText = (TextView) view.findViewById(R.id.item_description);
        }

        public void setDataItem(SampleItem item) {
            this.mTitleText.setText(item.getTitle());
            this.mDescriptionText.setText(item.getDescription());
        }
    }
}
