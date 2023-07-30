package com.example.mp8;


import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.text.method.LinkMovementMethod;
public class LessonActivity extends AppCompatActivity {
    private TextView lessonText;
    private Button startQuizButton;
    private String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);




        lessonText = findViewById(R.id.lessonText);
        startQuizButton = findViewById(R.id.startQuizButton);

        // Retrieve the selected language from the intent
        Intent intent = getIntent();
        language = intent.getStringExtra("language");

        // Retrieve and display the lesson content for the selected language
        String lesson = getLessonContent(language);
        lessonText.setText(lesson);



        startQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity();
            }
        });
    }

    private String getLessonContent(String language) {
        // Example lesson content for different languages
        String lessonContent = "";

        if (language.equals("English")) {
            lessonContent = "COUNTING\n" +
                    "1-one 2-two 3-three\n" +
                    "4-four 5-five 6-six\n" +
                    "7-seven 8-eight 9-nine\n\n" +
                    "GREETING\n" +
                    "Any Time- Hi/Hello\n"+
                    "Morning-Good Morning\n"+
                    "Afternoon-Good afternoon\n" +
                    "Evening-Good evening\n\n" +
                    "EMOTIONS\n"+
                    "-Happy\n"+
                    "-Sad\n"+
                    "-Angry\n"+
                    "-Excited\n"+
                    "-Calm\n";
            TextView linkTextView = findViewById(R.id.activity_main_link);
            linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
//            setupHyperlink();


        } else if (language.equals("Hindi")) {
            lessonContent = "गिनती(COUNTING)\n" +
                    "1-एक 2-दो 3-तीन\n" +
                    "4-चार 5-पाँच 6-छ:\n" +
                    "7-सात 8-आठ 9-नौ\n\n" +
                    "अभिवादन(GREETING)\n" +
                    "Any Time- नमस्ते\n" +
                    "Morning- सुप्रभात\n" +
                    "Afternoon- शुभ दोपहर\n" +
                    "Evening- शुभ संध्या\n\n" +
                    "भावना(EMOTION)\n"+
                    "क्रोध (Anger)\n"+
                    "खुश (Happy)\n"+
                    "दुखी (Sad)\n"+
                    "उत्तेजित (Excited)\n"+
                    "शांत (Calm)\n";
            TextView linkTextView2 = findViewById(R.id.activity_main_link2);
            linkTextView2.setMovementMethod(LinkMovementMethod.getInstance());
        } else if (language.equals("Japanese")) {
            lessonContent = "COUNTING\n" +
                    "1-いち 2-に 3-さん\n" +
                    "4-し/よん 5-ご 6-ろく\n" +
                    "7-しち/なな 8-はち 9-きゅう/く\n\n" +
                    "挨拶(GREETING)\n" +
                    "11Am to 5Pm- こんにちわ\n" +
                    "Morning- おはようございます\n" +
                    "Evening-こんばんわ \n\n" +
                    "感情(EMOTION)\n"+
                    "क्रोध (Anger)\n"+
                    "うれしい  (Happy)\n"+
                    "かなしい (Sad)\n"+
                    "興奮した (Excited)\n"+
                    "落ち着いて (Calm)\n";
            TextView linkTextView3 = findViewById(R.id.activity_main_link3);
            linkTextView3.setMovementMethod(LinkMovementMethod.getInstance());
        }

        return lessonContent;
    }

//    private void setupHyperlink() {
//        TextView linkTextView = findViewById(R.id.activity_main_link);
//        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
//    }





    private void startQuizActivity() {
        Intent intent = new Intent(LessonActivity.this, QuizActivity.class);
        intent.putExtra("language", language);
        startActivity(intent);
    }
}

