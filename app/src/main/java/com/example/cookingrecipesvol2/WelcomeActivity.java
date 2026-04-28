package com.example.cookingrecipesvol2;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Initialize the welcome button (Local variable to keep memory usage low)
        Button welcomeBtn = findViewById(R.id.btn_welcome);
        // Handle click event to navigate to the Main Activity screen
        welcomeBtn.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            // Call finish() to remove WelcomeActivity from the back stack.
            // This prevents the user from returning to this intro screen when pressing "Back".
            finish();
        });
    }
}