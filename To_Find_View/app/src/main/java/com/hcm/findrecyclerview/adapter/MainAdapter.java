package com.hcm.findrecyclerview.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hcm.findrecyclerview.R;
import com.hcm.findrecyclerview.model.ImageItem;
import com.hcm.findrecyclerview.util.UtilPicasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

/**
 * Created by BinhNguyen on 5/5/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    private List<ImageItem> mData;
    private Context mContext;
    public MainAdapter(Context context, List<ImageItem> images) {
        mContext = context;
        mData = images;
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_image, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {
        ImageItem item = mData.get(position);
        if (item.getPath() != null) {
            try {
                Bitmap bitmap = BitmapFactory.decodeFile(item.getPath());
                holder.thumbnail.setImageBitmap(bitmap);
                //UtilPicasso.get(mContext).load(item.getPath(), holder.thumbnail);
            }catch (Exception e) {
                Log.e("MainAdapter", item.getTitle();
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnail)
        public ImageView thumbnail;
        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public List<ImageItem> getData() {
        return mData;
    }

    public void setData(List<ImageItem> mData) {
        this.mData = mData;
    }

}
