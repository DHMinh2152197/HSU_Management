package com.example.minhd.hsumanagement;

public class DataNotification {
    String mTitle, mLink, mImage, mDate;

    public DataNotification(String mTitle, String mLink, String mImage, String mDate) {
        this.mTitle = mTitle;
        this.mLink = mLink;
        this.mImage = mImage;
        this.mDate = mDate;
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

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}
