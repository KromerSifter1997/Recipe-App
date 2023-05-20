package com.zybooks.studyhelper.viewmodel;

import android.app.Application;

import com.zybooks.studyhelper.model.Food;
import com.zybooks.studyhelper.repo.RecipeRepository;
import java.util.List;

public class SubjectListViewModel {

    private RecipeRepository studyRepo;

    public SubjectListViewModel(Application application) {
        studyRepo = RecipeRepository.getInstance(application.getApplicationContext());
    }

    public List<Food> getSubjects() {
        return studyRepo.getSubjects();
    }

}