package com.boolea.oaxaca.ui.utils.snappyRecyclerView;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by David Olascoaga on 05/03/2019.
 */
public class CenterZoomLayoutManager extends LinearLayoutManager {

    private final float mShrinkAmount = .5f;
    private final float mShrinkDistance = 4.75f;

    public CenterZoomLayoutManager(Context context) {
        super(context);
    }

    public CenterZoomLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }


    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int orientation = getOrientation();
        if (orientation == VERTICAL) {
            int scrolled = super.scrollVerticallyBy(dy, recycler, state);
            float midpoint = getHeight() / 1.f;
            float d0 = 0.f;
            float d1 = mShrinkDistance * midpoint;
            float s0 = 1.f;
            float s1 = 1.f - mShrinkAmount;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                float childMidpoint =
                        (getDecoratedBottom(child) + getDecoratedTop(child)) / 2.f;
                float d = Math.min(d1, Math.abs(midpoint - childMidpoint));
                float scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
                child.setScaleX(scale);
                child.setScaleY(scale);
            }
            return scrolled;
        } else {
            return 0;
        }
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int orientation = getOrientation();
        if (orientation == HORIZONTAL) {
            int scrolled = super.scrollHorizontallyBy(dx, recycler, state);

            float midpoint = getWidth() / 2.f;
            float d0 = 0.f;
            float d1 = mShrinkDistance * midpoint;
            float s0 = 1.f;
            float s1 = 1.f - mShrinkAmount;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                float childMidpoint =
                        (getDecoratedRight(child) + getDecoratedLeft(child)) / 2.f;
                float d = Math.min(d1, Math.abs(midpoint - childMidpoint));
                float scale = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
                child.setScaleX(scale);
                child.setScaleY(scale);
            }
            return scrolled;
        } else {
            return 0;
        }

    }
}
