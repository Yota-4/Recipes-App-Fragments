package com.example.cookingrecipesvol2;

import android.os.Bundle;
import android.content.res.Configuration;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private String selectedCategory = null;
    private String selectedRecipe = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            selectedCategory = savedInstanceState.getString("cat");
            selectedRecipe = savedInstanceState.getString("rec");
        }

        if (isLandscape())
            loadFragmentsForLandscape();
        else {
            // Portrait mode
            if (selectedRecipe != null)
                loadFragment(RecipeDetailsFragment.newInstance(selectedRecipe));
            else if (selectedCategory != null)
                loadFragment(RecipeListFragment.newInstance(selectedCategory));
            else
                loadFragment(CategoryFragment.newInstance());
        }
    }

    //Save before rotation
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("cat", selectedCategory);
        outState.putString("rec", selectedRecipe);
    }

    // Utility method to check current device orientation
    private boolean isLandscape() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    // Initializes the 3-pane layout for Landscape orientation
    private void loadFragmentsForLandscape(){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        // Load the initial category fragment into the left pane
        transaction.replace(R.id.category_fragment_container, CategoryFragment.newInstance());
        transaction.commit();

        if (selectedCategory != null)
            getSupportFragmentManager().beginTransaction().replace(R.id.recipe_list_fragment_container, RecipeListFragment
                    .newInstance(selectedCategory)).commit();
        if (selectedRecipe != null)
            getSupportFragmentManager().beginTransaction().replace(R.id.recipe_details_fragment_container, RecipeDetailsFragment
                    .newInstance(selectedRecipe)).commit();
    }

    // Handles fragment transactions for Portrait mode (Single-pane layout)
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        // Add to back stack so the user can navigate back with the device's back button
        transaction.addToBackStack(null);
        transaction.commit();
    }

    // Called by Fragments to navigate to the Recipe List
    public void openRecipeList(String category) {
        selectedCategory= category;
        selectedRecipe= null;
        if (isLandscape())
            // Place in the middle pane
            getSupportFragmentManager().beginTransaction().replace(R.id.recipe_list_fragment_container, RecipeListFragment.newInstance(category)).commit();
        else
            // Replace current full-screen fragment
            loadFragment(RecipeListFragment.newInstance(category));
    }

    // Called by Fragments to navigate to the Recipe Details
    public void openRecipeDetails(String recipe) {
        selectedRecipe= recipe;
        if (isLandscape())
            // Place in the right pane
            getSupportFragmentManager().beginTransaction().replace(R.id.recipe_details_fragment_container, RecipeDetailsFragment.newInstance(recipe)).commit();
        else
            // Replace current full-screen fragment
            loadFragment(RecipeDetailsFragment.newInstance(recipe));
    }
}