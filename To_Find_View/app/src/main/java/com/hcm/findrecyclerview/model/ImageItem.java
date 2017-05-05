package com.hcm.findrecyclerview.model;

import android.database.Cursor;
import android.provider.MediaStore;

/**
 * Created by BinhNguyen on 5/5/2017.
 */

public class ImageItem {
    private long id;
    private String title;
    private String path;
    public ImageItem(Cursor cursor) {
        int coldId = cursor.getColumnIndex(MediaStore.Images.Media._ID);
        int colTitle = cursor.getColumnIndex(MediaStore.Images.Media.TITLE);
        int coldPath = cursor.getColumnIndex(MediaStore.Images.Media.DATA);

        id = cursor.getLong(coldId);
        title = cursor.getString(colTitle);
        path = cursor.getString(coldPath);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
