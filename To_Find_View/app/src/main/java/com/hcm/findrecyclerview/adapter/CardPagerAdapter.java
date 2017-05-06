package com.hcm.findrecyclerview.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hcm.findrecyclerview.R;
import com.hcm.findrecyclerview.model.ImageItem;
import com.hcm.findrecyclerview.util.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyenngocbinh on 5/6/17.
 */

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    private List<ImageItem> mData;
    private float mBaseElevation;

    public CardPagerAdapter(ArrayList<ImageItem> images) {
        mData = images;
        mViews = new ArrayList<>();
        for (ImageItem item:mData) {
            mViews.add(null);
        }
    }

    public void addCardItem(ImageItem item) {
        mViews.add(null);
        mData.add(item);
    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.fragment_card, container, false);
        container.addView(view);
        bind(mData.get(position), view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
        mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mViews.set(position, null);
    }

    private void bind(ImageItem item, View view) {
        ImageView thumb = (ImageView) view.findViewById(R.id.thumbnail);
        TextView title = (TextView) view.findViewById(R.id.title);
        Utils.loadImageQuickly(view.getContext(), item.getPath(), thumb);
        title.setText(item.getTitle());
    }

}
