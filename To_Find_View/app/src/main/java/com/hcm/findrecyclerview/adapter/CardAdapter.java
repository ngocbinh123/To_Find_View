package com.hcm.findrecyclerview.adapter;

import android.support.v7.widget.CardView;

/**
 * Created by nguyenngocbinh on 5/6/17.
 */

public interface CardAdapter {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
