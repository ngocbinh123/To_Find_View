package com.hcm.findrecyclerview.helper;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.hcm.findrecyclerview.model.ImageItem;

import java.util.ArrayList;

/**
 * Created by BinhNguyen on 5/5/2017.
 */

public class ImagesHelper {
    private ContentResolver mResolver;

    public ImagesHelper(Context context) {
        mResolver = context.getContentResolver();
    }

    public static ImagesHelper get(Context context) {
        return new ImagesHelper(context);
    }

    public ArrayList<ImageItem> getAllImage() {
        ArrayList<ImageItem> images = new ArrayList<>();
        Cursor cursor = mResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                images.add(new ImageItem(cursor));
            } while (cursor.moveToNext());
        }
        return images;
    }
}
