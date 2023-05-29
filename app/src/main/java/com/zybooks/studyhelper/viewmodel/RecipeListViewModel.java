package com.zybooks.studyhelper.viewmodel;

import android.app.Application;

import com.zybooks.studyhelper.model.Food;
import com.zybooks.studyhelper.repo.RecipeRepository;
import java.util.List;

public class RecipeListViewModel {

    private RecipeRepository recipeRepo;

    public RecipeListViewModel(Application application) {
        recipeRepo = RecipeRepository.getInstance(application.getApplicationContext());
    }

    public List<Food> getRecipes() {
        return recipeRepo.getSubjects();
    }

}