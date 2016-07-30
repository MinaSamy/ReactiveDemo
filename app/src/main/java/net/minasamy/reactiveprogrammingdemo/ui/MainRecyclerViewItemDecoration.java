package net.minasamy.reactiveprogrammingdemo.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.minasamy.reactiveprogrammingdemo.R;

/**
 * Created by minsamy on 7/31/2016.
 */
public class MainRecyclerViewItemDecoration extends RecyclerView.ItemDecoration {


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int margin = parent.getContext().getResources().getDimensionPixelSize(R.dimen.card_view_margin);
        outRect.right = margin;
        outRect.left = margin;
        outRect.top = margin;
        outRect.right = margin;
    }
}
