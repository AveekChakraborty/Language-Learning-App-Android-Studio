package com.example.mp8;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LanguageSelectionActivity extends AppCompatActivity {
    private Button englishButton;
    private Button hindiButton;
    private Button japaneseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        englishButton = findViewById(R.id.englishButton);
        hindiButton = findViewById(R.id.hindiButton);
        japaneseButton = findViewById(R.id.japaneseButton);

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLessonActivity("English");
            }
        });

        hindiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLessonActivity("Hindi");
            }
        });

        japaneseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLessonActivity("Japanese");
            }
        });
    }

    private void startLessonActivity(String language) {
        Intent intent = new Intent(LanguageSelectionActivity.this, LessonActivity.class);
        intent.putExtra("language", language);
        startActivity(intent);
    }
}