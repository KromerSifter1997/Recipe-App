package com.zybooks.studyhelper.model;

import androidx.annotation.NonNull;

public class Food {

    private long mId;
    private long mFavId;
    private String mText;
    private long mUpdateTime;

    public Food(@NonNull String text) {
        mText = text;
        mUpdateTime = System.currentTimeMillis();
    }

    //the id is what is called when the app needs to know what recipe to show on the list.

    public long getId() {
        return mId;
    }

    //same applies for Fav idea but for the favorite screen,
    // TODO: ONLY CALL WHEN favId IS NOT NULL (or ensure it can't be called when favId is null)
    public long getFavId() {
        return mFavId;
    }

    public void setId(long id) {
        mId = id;
    }

    public void setFavId(long favId) {
       mFavId = favId;
    }

    public String getText() {
        return mText;
    }

    public void setText(String subject) {
        mText = subject;
    }

    public long getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(long updateTime) {
        mUpdateTime = updateTime;
    }
}