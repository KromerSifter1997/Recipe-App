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
    private final HashMap<Long, List<Recipe>> mRecipeList;

    public static RecipeRepository getInstance(Context context) {
        if (mStudyRepo == null) {
            mStudyRepo = new RecipeRepository(context);
        }
        return mStudyRepo;
    }

    private RecipeRepository(Context context) {

        mSubjectList = new ArrayList<>();
        mRecipeList = new HashMap<>();

        addStarterData();
    }

    private void addStarterData() {
//        Steps for Spaghetti
        // start subject to create new recipe
        Subject subject = new Subject("SPAGHETTI");
        subject.setId(1);
        addSubject(subject);

        //recipe new recipe creates individual steps
        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Sauce");
        recipe.setIngredients("4 Roma tomatoes \n\n 1/2 clove of garlic \n\n 1 tablespoon of oregano");
        recipe.setInstructions("slice the skin of the tomato in a \"X\" pattern \n\n boil them for 1 minute \n\n peel then dice tomato flesh\n\n Sautee with seasonings for 3 minutes ");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Pasta");
        recipe.setIngredients("2 cups of water\n\nSalt\n\n1/2 - 1 pound dry spaghetti");
        recipe.setInstructions("pour 2 cups of water into large pot\n\n Throw a pinch of salt into water\n\n Heat water until boil\n\n Place pasta into water, boil for 4 minutes or until Al Dente \n\n Serve and enjoy!");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Serving");
        recipe.setIngredients("Quarter Oz tomato sauce\n\nHalf pound spaghetti\n\nSalt & pepper (if desired)");
        recipe.setInstructions("Place pasta into bowl or place\n\nPour sauce over pasta\n\nAdd salt and pepper if desired");
        recipe.setSubjectId(1);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

//        Steps for cookies
        // only need to do Subject subject = new subject() once
        //after just do subject = new subject()
        subject = new Subject("COOKIES");
        subject.setId(1);
        addSubject(subject);

        //recipe new recipe creates individual steps
        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Sauce");
        recipe.setIngredients("4 Roma tomatoes \n\n 1/2 clove of garlic \n\n 1 tablespoon of oregano");
        recipe.setInstructions("slice the skin of the tomato in a \"X\" pattern \n\n boil them for 1 minute \n\n peel then dice tomato flesh\n\n Sautee with seasonings for 3 minutes ");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Pasta");
        recipe.setIngredients("2 cups of water\n\nSalt\n\n1/2 - 1 pound dry spaghetti");
        recipe.setInstructions("pour 2 cups of water into large pot\n\n Throw a pinch of salt into water\n\n Heat water until boil\n\n Place pasta into water, boil for 4 minutes or until Al Dente \n\n Serve and enjoy!");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Serving");
        recipe.setIngredients("Quarter Oz tomato sauce\n\nHalf pound spaghetti\n\nSalt & pepper (if desired)");
        recipe.setInstructions("Place pasta into bowl or place\n\nPour sauce over pasta\n\nAdd salt and pepper if desired");
        recipe.setSubjectId(1);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////

        //        Steps for pancakes
        subject = new Subject("PANCAKES");
        subject.setId(1);
        addSubject(subject);

        //recipe new recipe creates individual steps
        recipe = new Recipe();
        recipe.setId(1);
        recipe.setText("Sauce");
        recipe.setIngredients("4 Roma tomatoes \n\n 1/2 clove of garlic \n\n 1 tablespoon of oregano");
        recipe.setInstructions("slice the skin of the tomato in a \"X\" pattern \n\n boil them for 1 minute \n\n peel then dice tomato flesh\n\n Sautee with seasonings for 3 minutes ");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Pasta");
        recipe.setIngredients("2 cups of water\n\nSalt\n\n1/2 - 1 pound dry spaghetti");
        recipe.setInstructions("pour 2 cups of water into large pot\n\n Throw a pinch of salt into water\n\n Heat water until boil\n\n Place pasta into water, boil for 4 minutes or until Al Dente \n\n Serve and enjoy!");
        recipe.setSubjectId(1);
        addStep(recipe);

        recipe = new Recipe();
        recipe.setId(2);
        recipe.setText("Serving");
        recipe.setIngredients("Quarter Oz tomato sauce\n\nHalf pound spaghetti\n\nSalt & pepper (if desired)");
        recipe.setInstructions("Place pasta into bowl or place\n\nPour sauce over pasta\n\nAdd salt and pepper if desired");
        recipe.setSubjectId(1);
        addStep(recipe);


// ///////////////////////////////////////////////////////////////
    }

    public void addSubject(Subject subject) {
        mSubjectList.add(subject);
        List<Recipe> recipeList = new ArrayList<>();
        mRecipeList.put(subject.getId(), recipeList);
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

    public void addStep(Recipe recipe) {
        List<Recipe> recipeList = mRecipeList.get(recipe.getRecipeId());
        if (recipeList != null) {
            recipeList.add(recipe);
        }
    }

    public List<Recipe> getStep(long subjectId) {
        return mRecipeList.get(subjectId);
    }
}