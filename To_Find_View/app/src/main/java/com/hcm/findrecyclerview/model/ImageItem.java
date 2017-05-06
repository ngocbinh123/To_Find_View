package com.hcm.findrecyclerview.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;

/**
 * Created by BinhNguyen on 5/5/2017.
 */

public class ImageItem implements Parcelable {
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

    protected ImageItem(Parcel in) {
        id = in.readLong();
        title = in.readString();
        path = in.readString();
    }

    public static final Creator<ImageItem> CREATOR = new Creator<ImageItem>() {
        @Override
        public ImageItem createFromParcel(Parcel in) {
            return new ImageItem(in);
        }

        @Override
        public ImageItem[] newArray(int size) {
            return new ImageItem[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(path);
    }
}
