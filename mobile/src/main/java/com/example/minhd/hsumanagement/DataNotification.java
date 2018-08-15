package com.example.minhd.hsumanagement;

public class DataNotification {
    String mTitle,mLink,mImage;

    public DataNotification(String mTitle, String mLink, String mImage) {
        this.mTitle = mTitle;
        this.mLink = mLink;
        this.mImage = mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }
}
