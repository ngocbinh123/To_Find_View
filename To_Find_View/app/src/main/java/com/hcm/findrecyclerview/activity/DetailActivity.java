package com.hcm.findrecyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hcm.findrecyclerview.R;
import com.hcm.findrecyclerview.adapter.CardPagerAdapter;
import com.hcm.findrecyclerview.helper.ShadowTransformer;
import com.hcm.findrecyclerview.model.ImageItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BinhNguyen on 5/5/2017.
 */

public class DetailActivity extends AppCompatActivity {
    public static final String IMAGE_TRANSITION_NAME = "transitionImage";
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        init();
    }

    /**
     * init all of things in activity
     * */
    private void init() {
        // parse data from intent
        int curPos = (int) getIntent().getExtras().get(MainActivity.ITEM_CURRENT_POSITION); // current position
        ArrayList<ImageItem> images = getIntent().getParcelableArrayListExtra(MainActivity.IMAGES_LIST); // images list

        // init Viewpager
        mCardAdapter = new CardPagerAdapter(images);
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setCurrentItem(curPos);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }
}
