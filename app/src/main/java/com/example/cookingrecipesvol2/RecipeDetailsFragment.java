package com.example.cookingrecipesvol2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RecipeDetailsFragment extends Fragment {
    private static final String ARG_RECIPE = "recipe";
    private String currentRecipe;

    // Factory method for secure argument passing
    public static RecipeDetailsFragment newInstance(String recipe) {
        RecipeDetailsFragment fragment = new RecipeDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_RECIPE, recipe);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_recipe_details, container, false);
        // Initialize UI Elements
        TextView tvRecipeDetails= view.findViewById(R.id.tv_recipe_details);
        ImageView imgRecipe= view.findViewById(R.id.img_recipe);
        TextView tvRecipeText= view.findViewById(R.id.tv_recipe_text);
        Button btnWebsite= view.findViewById(R.id.btn_website);
        Button btnVideo= view.findViewById(R.id.btn_video);

        // Retrieve the selected recipe and populate the UI
        if(getArguments()!=null) {
            currentRecipe= getArguments().getString(ARG_RECIPE);
            tvRecipeDetails.setText(currentRecipe);
            imgRecipe.setImageResource(getImageResource(currentRecipe));
            tvRecipeText.setText(getRecipeText(currentRecipe));

            // Implicit Intents to open external browser/apps
            btnWebsite.setOnClickListener(v -> {
                String url= getWebsiteUrl(currentRecipe);
                if (!url.isEmpty()) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                }
            });

            btnVideo.setOnClickListener(v -> {
                String url= getVideoUrl(currentRecipe);
                if (!url.isEmpty()) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                }
            });
        }
        return view;
    }

    // Mock Data Helpers (In a production app, these would come from a Database or API)
    private int getImageResource(String recipe){
        switch (recipe){
            case "Red Velvet Croissants":
                return R.drawable.croissants;
            case "Breakfast Burrito":
                return R.drawable.burrito;
            case "Waffles":
                return R.drawable.waffles;
            case "Chicken Kontosouvli":
                return R.drawable.kontosouvli;
            case "Light Mousakas":
                return R.drawable.mousakas;
            case "Smashed Burgers":
                return R.drawable.burger;
            case "Light Wrap with Chicken Salad":
                return R.drawable.wrap;
            case "Mac and Cheese Corn Dogs":
                return R.drawable.corndogs;
            case "Porridge":
                return R.drawable.porridge;
            default:
                return R.drawable.ic_launcher_background;
        }
    }

    private String getRecipeText(String recipe){
        switch (recipe){
            case "Red Velvet Croissants":
                return getString(R.string.croissants_text);
            case "Breakfast Burrito":
                return getString(R.string.burrito_text);
            case "Waffles":
                return getString(R.string.waffles_text);
            case "Chicken Kontosouvli":
                return getString(R.string.kontosouvli_text);
            case "Light Mousakas":
                return getString(R.string.mousakas_text);
            case "Smashed Burgers":
                return getString(R.string.smashed_burgers_text);
            case "Light Wrap with Chicken Salad":
                return getString(R.string.light_wrap_text);
            case "Mac and Cheese Corn Dogs":
                return getString(R.string.corn_dogs_text);
            case "Porridge":
                return getString(R.string.porridge_text);
            default:
                return "No Recipe Found.";
        }
    }

    private String getWebsiteUrl(String recipe){
        switch (recipe){
            case "Red Velvet Croissants":
                return "https://akispetretzikis.com/recipe/8836/krouasan-red-velvet";
            case "Breakfast Burrito":
                return "https://akispetretzikis.com/recipe/8820/breakfast-burrito";
            case "Waffles":
                return "https://akispetretzikis.com/recipe/7920/vafles";
            case "Chicken Kontosouvli":
                return "https://akispetretzikis.com/recipe/9060/kontosouvli-kotopoulo-sto-air-fryer";
            case "Light Mousakas":
                return "https://akispetretzikis.com/recipe/8775/light-mousakas-me-mpesamel-giaourtiou";
            case "Smashed Burgers":
                return "https://akispetretzikis.com/recipe/8389/smashed-burgers";
            case "Light Wrap with Chicken Salad":
                return "https://akispetretzikis.com/recipe/8035/light-wrap-me-kotosalata";
            case "Mac and Cheese Corn Dogs":
                return "https://akispetretzikis.com/recipe/7910/mac-n-cheese-corn-dogs";
            case "Porridge":
                return "https://akispetretzikis.com/recipe/5156/porridge";
            default:
                return "";
        }
    }

    private String getVideoUrl(String recipe){
        switch (recipe){
            case "Red Velvet Croissants":
                return "https://youtu.be/aDjJ1o7b_v8?feature=shared";
            case "Breakfast Burrito":
                return "https://youtu.be/tRyIrzJpt18?feature=shared";
            case "Waffles":
                return "https://youtu.be/NItGS3_Iql0?feature=shared";
            case "Chicken Kontosouvli":
                return "https://youtu.be/1kUIf6U15ug";
            case "Light Mousakas":
                return "https://youtu.be/1x0swsY6A2k";
            case "Smashed Burgers":
                return "https://youtu.be/cJN8GeDwq6M";
            case "Light Wrap with Chicken Salad":
                return "https://youtu.be/sGA5XmBF2as";
            case "Mac and Cheese Corn Dogs":
                return "https://youtu.be/HUZYOI92eJs";
            case "Porridge":
                return "https://youtu.be/03gYrJsBLig";
            default:
                return "";
        }
    }
}