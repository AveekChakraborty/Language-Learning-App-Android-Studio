package com.example.mp8;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private TextView questionText;
    private RadioGroup optionsRadioGroup;
    private Button submitButton;
    private String language;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private String[] quizQuestions;
    private String[][] quizOptions;
    private String[] quizAnswers;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.questionText);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        submitButton = findViewById(R.id.submitButton);

        // Retrieve the selected language from the intent
        Intent intent = getIntent();
        language = intent.getStringExtra("language");

        if (language.equals("English")) {
            quizQuestions = new String[]{"What is the word for '1' in English?", "How do you wish in the evening in English?", "What is the word for '5' in English?"};
            quizOptions = new String[][]{{"A. one", "B. two", "C. three", "D. four"}, {"A. Good Afternoon", "B. Good Evening", "C. Good Night", "D. Good Morning"}, {"A. Five", "B. Six", "C. Seven", "D. Eight"}};
            quizAnswers = new String[]{"A. one", "B. Good Evening", "A. Five"};
        } else if (language.equals("Hindi")) {
            quizQuestions = new String[]{"What is the word for '1' in Hindi?", "How do you wish in the evening in Hindi?", "What is the word for '5' in Hindi?"};
            quizOptions = new String[][]{{"A. एक", "B. दो", "C. तीन", "D. चार"}, {"A. शुभ दोपहर", "B. शुभ शाम", "C. शुभ रात्रि", "D. शुभ प्रभात"}, {"A. पाँच", "B. छः", "C. सात", "D. आठ"}};
            quizAnswers = new String[]{"A. एक", "B. शुभ शाम", "A. पाँच"};
        } else if (language.equals("Japanese")) {
            quizQuestions = new String[]{"What is the word for '1' in Japanese?", "How do you wish in the evening in Japanese?", "What is the word for '5' in Japanese?"};
            quizOptions = new String[][]{{"A. いち", "B. に", "C. さん", "D. よん"}, {"A. こんばんは", "B. おはようございます", "C. こんにちは", "D. さようなら"}, {"A. ご", "B. ろく", "C. しち", "D. はち"}};
            quizAnswers = new String[]{"A. いち", "A. こんばんは", "A. ご"};
        }

        // Set the first question
        setQuestion();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void setQuestion() {
        questionText.setText(quizQuestions[currentQuestionIndex]);

        optionsRadioGroup.removeAllViews();
        for (int i = 0; i < quizOptions[currentQuestionIndex].length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(quizOptions[currentQuestionIndex][i]);
            optionsRadioGroup.addView(radioButton);
        }
    }

    private void checkAnswer() {
        int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedOptionId != -1) {
            RadioButton selectedRadioButton = findViewById(selectedOptionId);
            String selectedAnswer = selectedRadioButton.getText().toString();

            if (selectedAnswer.equals(quizAnswers[currentQuestionIndex])) {
                score++;
            }

            currentQuestionIndex++;

            if (currentQuestionIndex < quizQuestions.length) {
                setQuestion();
            } else {
                showQuizResult();
            }
        } else {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    private void showQuizResult() {
        int totalQuestions = quizQuestions.length;
        int percentageScore = (score * 100) / totalQuestions;

        StringBuilder quizResult = new StringBuilder();
        quizResult.append("Congratulations!\n\n");
        quizResult.append("You have completed the ").append(language).append(" quiz.\n\n");
        quizResult.append("Score: ").append(score).append("/").append(totalQuestions).append(" (").append(percentageScore).append("%)\n\n");
        quizResult.append("Correct Answers:\n");

        for (int i = 0; i < totalQuestions; i++) {
            quizResult.append("Question ").append(i + 1).append(": ").append(quizAnswers[i]).append("\n");
        }

        questionText.setText(quizResult.toString());
        optionsRadioGroup.setVisibility(View.GONE);
        submitButton.setVisibility(View.GONE);
    }
}
