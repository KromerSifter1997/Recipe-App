package com.zybooks.studyhelper.viewmodel;

import android.app.Application;
import com.zybooks.studyhelper.model.Recipe;
import com.zybooks.studyhelper.repo.StudyRepository;
import java.util.List;

public class QuestionListViewModel {

    private StudyRepository studyRepo;

    public QuestionListViewModel(Application application) {
        studyRepo = StudyRepository.getInstance(application.getApplicationContext());
    }

    public List<Recipe> getQuestions(long subjectId) {
        return studyRepo.getQuestions(subjectId);
    }
}

