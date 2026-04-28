package com.example.cookingrecipesvol2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CategoryFragment extends Fragment {

    // Factory method to create a new instance of this fragment
    public static CategoryFragment newInstance() {

        return new CategoryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_category, container, false);
        // Initialize UI components using local variables
        Button btnBreakfast= view.findViewById(R.id.btn_breakfast);
        Button btnLunch= view.findViewById(R.id.btn_lunch);
        Button btnDinner= view.findViewById(R.id.btn_dinner);

        // Set click listeners to communicate with the host Activity (MainActivity)
        // We safely check if the hosting activity is MainActivity before casting to avoid crashes
        btnBreakfast.setOnClickListener(v -> {
            if(getActivity() instanceof MainActivity)
                ((MainActivity) getActivity()).openRecipeList("Breakfast");
        });
        btnLunch.setOnClickListener(v -> {
            if(getActivity() instanceof MainActivity)
                ((MainActivity) getActivity()).openRecipeList("Lunch");
        });
        btnDinner.setOnClickListener(v -> {
            if(getActivity() instanceof MainActivity)
                ((MainActivity) getActivity()).openRecipeList("Dinner");
        });

        return view;
    }

}