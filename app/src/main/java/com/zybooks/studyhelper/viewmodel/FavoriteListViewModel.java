package com.zybooks.studyhelper.viewmodel;

import android.app.Application;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.zybooks.studyhelper.R;
import com.zybooks.studyhelper.model.Favorites;
import com.zybooks.studyhelper.repo.RecipeRepository;
import java.util.List;

public class FavoriteListViewModel {
    private RecipeRepository RecipeRepo;




    public FavoriteListViewModel(Application application) {
        RecipeRepo = RecipeRepository.getInstance(application.getApplicationContext());

    }

    public List<Favorites> getRecipes() {
        return RecipeRepo.getFavorites();
    }
}
