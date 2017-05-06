package com.hcm.findrecyclerview.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
    @BindView(R.id.bottom_navigation)
    BottomNavigationView mBottomBar;
    private int curPos = 0;
    private ArrayList<ImageItem> mImages;

    @BindView(R.id.viewPager)
    ViewPager mViewPager;

    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;

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

    private void init() {
        // parse data from intent
        curPos = (int) getIntent().getExtras().get(MainActivity.ITEM_CURRENT_POSITION);
        mImages = getIntent().getParcelableArrayListExtra(MainActivity.IMAGES_LIST);

        initViewPager();
        mBottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_gps:
                        break;
                    case R.id.action_signal:
                        break;
                    case R.id.action_add:
                        break;
                }
                return true;
            }
        });
    }

    private void initViewPager() {
        mCardAdapter = new CardPagerAdapter(mImages);
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setCurrentItem(curPos);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }
}
