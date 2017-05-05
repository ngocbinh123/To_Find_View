package com.hcm.findrecyclerview.util;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by BinhNguyen on 5/5/2017.
 */

public class UtilPicasso {
    private static Picasso mPicasso;

    public static UtilPicasso get(Context context) {
        if (mPicasso == null) {
            Picasso.Builder builder = new Picasso.Builder(context);
            mPicasso = builder.build();
        }
        return new UtilPicasso();
    }

    public void load(String uri, ImageView imageView) {
        if (uri.isEmpty() || imageView == null)
            return;
        File f = new File(uri);
        mPicasso.load(f).fit().centerCrop().into(imageView);
//        mPicasso.load(uri).centerCrop().into(imageView);
    }
}
