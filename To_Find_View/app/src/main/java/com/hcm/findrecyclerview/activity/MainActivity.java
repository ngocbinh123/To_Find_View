package com.hcm.findrecyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.hcm.findrecyclerview.R;
import com.hcm.findrecyclerview.adapter.MainAdapter;
import com.hcm.findrecyclerview.helper.ImagesHelper;
import com.hcm.findrecyclerview.model.ImageItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String ITEM_CURRENT_POSITION = "ITEM_CURRENT_POSITION";
    public static final String IMAGES_LIST = "IMAGES_LIST";
    @BindView(R.id.recycle_view)
    RecyclerView mRecyclerView;
    private MainAdapter mAdapter;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initActionButton();
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mAdapter = new MainAdapter(getApplicationContext(),getImages());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setListener(new MainAdapter.OnClickListener() {
            @Override
            public void onClickItem(ImageItem selected, int position) {
                goToDetailScreen(position);
            }
        });
    }

    private void initActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDetailScreen(0);

            }
        });
    }

    private void goToDetailScreen(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(ITEM_CURRENT_POSITION, position);
        intent.putParcelableArrayListExtra(IMAGES_LIST, mAdapter.getData());
        startActivity(intent);
    }

    private ArrayList<ImageItem> getImages() {
        return ImagesHelper.get(this).getAllImage();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
