package com.hcm.findrecyclerview.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hcm.findrecyclerview.R;
/**
 * Created by BinhNguyen on 5/5/2017.
 */

public class Utils {
    public static void loadImageQuickly(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url)
                .error(R.mipmap.ic_no_image)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}
