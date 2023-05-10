package com.zybooks.studyhelper.repo;

import android.content.Context;
import com.zybooks.studyhelper.model.Recipe;
import com.zybooks.studyhelper.model.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeRepository {

    private static RecipeRepository mStudyRepo;
    private final List<Subject> mSubjectList;
    private final HashMap<Long, List<Recipe>> mQuestionMap;

    public static RecipeRepository getInstance(Context context) {
        if (mStudyRepo == null) {
            mStudyRepo = new RecipeRepository(context);
        }
        return mStudyRepo;
    }

    private RecipeRepository(Context context) {

        mSubjectList = new ArrayList<>();
        mQuestionMap = new HashMap<>();

        addStarterData();
    }

    private void addStarterData() {
        // Add a few subjects and questions
        Subject subject = new Subject("SPAGHETTI");
        subject.setId(1);
        addSubject(subject);

//        Steps for Spaghetti
        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Sauce");
        recipe.setAnswer("4 Roma tomatoes \n\n 1/2 clove of garlic \n\n 1 tablespoon of oregano");
        recipe.setInstructions("slice the skin of the tomato in a \"X\" pattern \n\n boil them for 1 minute \n\n peel then dice tomato flesh\n\n Sautee with seasonings for 3 minutes ");
        recipe.setSubjectId(1);
        addQuestion(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Pasta");
        recipe.setAnswer("2 cups of water\n\nSalt\n\n1/2 - 1 pound dry spaghetti");
        recipe.setInstructions("pour 2 cups of water into large pot\n\n Throw a pinch of salt into water\n\n Heat water until boil\n\n Place pasta into water, boil for 4 minutes or until Al Dente \n\n Serve and enjoy!");
        recipe.setSubjectId(1);
        addQuestion(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Serving");
        recipe.setAnswer("Quarter Oz tomato sauce\n\nHalf pound spaghetti\n\nSalt & pepper (if desired)");
        recipe.setInstructions("Place pasta into bowl or place\n\nPour sauce over pasta\n\nAdd salt and pepper if desired");
        recipe.setSubjectId(1);
        addQuestion(recipe);


// ///////////////////////////////////////////////////////////////

        subject = new Subject("History");
        subject.setId(2);
        addSubject(subject);

        recipe = new Recipe();
        recipe.setId(3);
        recipe.setText("On what date was the U.S. Declaration of Independence adopted?");
        recipe.setAnswer("July 4, 1776");
        recipe.setSubjectId(2);
        addQuestion(recipe);

        subject = new Subject("Computing");
        subject.setId(3);
        addSubject(subject);
    }

    public void addSubject(Subject subject) {
        mSubjectList.add(subject);
        List<Recipe> recipeList = new ArrayList<>();
        mQuestionMap.put(subject.getId(), recipeList);
    }

    public Subject getSubject(long subjectId) {
        for (Subject subject: mSubjectList) {
            if (subject.getId() == subjectId) {
                return subject;
            }
        }

        return null;
    }

    public List<Subject> getSubjects() {
        return mSubjectList;
    }

    public void addQuestion(Recipe recipe) {
        List<Recipe> recipeList = mQuestionMap.get(recipe.getSubjectId());
        if (recipeList != null) {
            recipeList.add(recipe);
        }
    }

    public List<Recipe> getQuestions(long subjectId) {
        return mQuestionMap.get(subjectId);
    }
}