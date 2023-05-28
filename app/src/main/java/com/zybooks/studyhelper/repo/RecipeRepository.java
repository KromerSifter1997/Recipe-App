package com.zybooks.studyhelper.repo;

import android.content.Context;

import com.zybooks.studyhelper.model.Food;
import com.zybooks.studyhelper.model.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecipeRepository {

    private static RecipeRepository mRecipeRepo;
    private final List<Food> mFoodList;
    private final HashMap<Long, List<Recipe>> mRecipeList;

    public static RecipeRepository getInstance(Context context) {
        if (mRecipeRepo == null) {
            mRecipeRepo = new RecipeRepository(context);
        }
        return mRecipeRepo;
    }

    private RecipeRepository(Context context) {

        mFoodList = new ArrayList<>();
        mRecipeList = new HashMap<>();

        addStarterData();
    }

    private void addStarterData() {
//        Steps for Spaghetti
        // start subject to create new recipe
        Food food = new Food("SPAGHETTI");
        food.setId(1);
        addRecipe(food);

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
        food = new Food("COOKIES");
        food.setId(1);
        addRecipe(food);

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
        food = new Food("PANCAKES");
        food.setId(1);
        addRecipe(food);

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

    public void addRecipe(Food food) {
        mFoodList.add(food);
        List<Recipe> recipeList = new ArrayList<>();
        mRecipeList.put(food.getId(), recipeList);
    }

    public Food getSubject(long subjectId) {
        for (Food food : mFoodList) {
            if (food.getId() == subjectId) {
                return food;
            }
        }

        return null;
    }

    public List<Food> getSubjects() {
        return mFoodList;
    }

    public void addStep(Recipe recipe) {
        // this function can be applied to call upon "favorite recipe" by giving it a "favorite id" instead to call upon
        List<Recipe> recipeList = mRecipeList.get(recipe.getRecipeId());
        if (recipeList != null) {
            recipeList.add(recipe);
        }
    }

    public List<Recipe> getStep(long subjectId) {
        return mRecipeList.get(subjectId);
    }
}