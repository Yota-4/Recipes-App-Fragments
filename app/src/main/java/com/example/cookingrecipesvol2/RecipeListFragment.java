package com.example.cookingrecipesvol2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RecipeListFragment extends Fragment {
    private static final String ARG_CATEGORY= "category";
    private String category;

    // Factory method to instantiate the fragment with the required category argument
    public static RecipeListFragment newInstance(String category) {
        RecipeListFragment fragment = new RecipeListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_recipe_list, container, false);
        ListView recipeList= view.findViewById(R.id.recipe_list);

        // Retrieve the category from arguments securely
        if (getArguments() != null)
            category= getArguments().getString(ARG_CATEGORY);
        if (category == null)
            category= "";   // Safety net to avoid null pointer exceptions

        // Populate the ListView with mock data based on the selected category
        String[] recipes= getRecipesForCategory(category);
        ArrayAdapter<String> adapter= new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, recipes);
        recipeList.setAdapter(adapter);

        // Handle item clicks to open the recipe details
        recipeList.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedRecipe= recipes[position];
            // Communicate back to MainActivity to load the Details Fragment
            if (getActivity() instanceof MainActivity)
                ((MainActivity) getActivity()).openRecipeDetails(selectedRecipe);
        });
        return view;
    }

    // Mock Database Query
    private String[] getRecipesForCategory(String category){
        switch (category){
            case "Breakfast":
                return new String[]{"Red Velvet Croissants", "Breakfast Burrito", "Waffles"};
            case "Lunch":
                return new String[]{"Chicken Kontosouvli", "Light Mousakas", "Smashed Burgers"};
            case "Dinner":
                return new String[]{"Light Wrap with Chicken Salad", "Mac and Cheese Corn Dogs", "Porridge"};
            default:
                return new String[]{};
        }
    }
}