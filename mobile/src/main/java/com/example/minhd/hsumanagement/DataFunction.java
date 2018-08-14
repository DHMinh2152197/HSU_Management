package com.example.minhd.hsumanagement;

public class DataFunction {
    private int mfunctionImage;
    private String mfunctionName;

    public DataFunction(int mfunctionImage, String mfunctionName) {
        this.mfunctionImage = mfunctionImage;
        this.mfunctionName = mfunctionName;
    }

    public int getMfunctionImage() {
        return mfunctionImage;
    }

    public void setMfunctionImage(int mfunctionImage) {
        this.mfunctionImage = mfunctionImage;
    }

    public String getMfunctionName() {
        return mfunctionName;
    }

    public void setMfunctionName(String mfunctionName) {
        this.mfunctionName = mfunctionName;
    }
}
