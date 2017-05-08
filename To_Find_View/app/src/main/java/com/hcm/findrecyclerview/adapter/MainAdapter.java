package com.hcm.findrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hcm.findrecyclerview.R;
import com.hcm.findrecyclerview.model.ImageItem;
import com.hcm.findrecyclerview.util.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BinhNguyen on 5/5/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    private static final String TAG = MainAdapter.class.getName();
    private ArrayList<ImageItem> mData;
    private Context mContext;
    private OnClickListener mListener;

    private ArrayList<ViewHolder> mHolders;
    public MainAdapter(Context context, ArrayList<ImageItem> images) {
        mContext = context;
        mData = images;
        mHolders = new ArrayList<>();
        for (ImageItem item:mData) {
            mHolders.add(null);
        }
    }

    public interface OnClickListener {
        void onClickItem(ImageItem selected, int position);
    }

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_image, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, final int position) {
        ImageItem item = mData.get(position);
        if (item.getPath() != null) {
            Utils.loadImageQuickly(mContext, item.getPath(), holder.thumbnail);
        } else {
            Log.d(TAG, item.getTitle() + "don't has path");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onClickItem(mData.get(position),position);
            }
        });
        mHolders.set(position, holder);
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.thumbnail)
        ImageView thumbnail;
        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
        public ImageView getThumbnail() {
            return thumbnail;
        }
    }

    public OnClickListener getListener() {
        return mListener;
    }

    public void setListener(OnClickListener listener) {
        this.mListener = listener;
    }

    public ArrayList<ImageItem> getData() {
        return mData;
    }

    public void setData(ArrayList<ImageItem> mData) {
        this.mData = mData;
    }

    public ViewHolder getHolderItem(int position) {
        return mHolders.get(position);
    }
}
