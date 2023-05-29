package com.zybooks.studyhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.zybooks.studyhelper.viewmodel.FavoriteListViewModel;


public class FavoriteActivity extends AppCompatActivity {

    private FavoriteActivity mFavoriteAdapter;

    private RecyclerView mRecyclerView;

    private int[] mSubjectColors;

    private FavoriteListViewModel mSubjectListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);


    }
}