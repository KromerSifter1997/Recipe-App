package com.zybooks.studyhelper.viewmodel;

import android.app.Application;
import com.zybooks.studyhelper.model.Recipe;
import com.zybooks.studyhelper.repo.RecipeRepository;

import java.util.List;

public class QuestionListViewModel {

    private RecipeRepository studyRepo;

    public QuestionListViewModel(Application application) {
        studyRepo = RecipeRepository.getInstance(application.getApplicationContext());
    }

    public List<Recipe> getQuestions(long subjectId) {
        return studyRepo.getStep(subjectId);
    }
}

