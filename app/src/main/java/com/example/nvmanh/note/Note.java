package com.example.nvmanh.note;

public class Note {
    private int mId;
    private String mTitle;
    private String mBody;
    private boolean mIsLike;

    public Note() {
    }

    public Note(int mId, String mTitle, String mBody) {
        this.mId = mId;
        this.mTitle = mTitle;
        this.mBody = mBody;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmBody() {
        return mBody;
    }

    public void setmBody(String mBody) {
        this.mBody = mBody;
    }

    public boolean ismIsLike() {
        return mIsLike;
    }

    public void setmIsLike(boolean mIsLike) {
        this.mIsLike = mIsLike;
    }
}
