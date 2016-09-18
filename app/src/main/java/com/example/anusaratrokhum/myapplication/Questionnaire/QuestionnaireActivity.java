package com.example.anusaratrokhum.myapplication.Questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anusaratrokhum.myapplication.GuestActivity;
import com.example.anusaratrokhum.myapplication.R;

public class QuestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        final Button sum = (Button) findViewById(R.id.button6);
        sum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.button6) {
                    Intent intent = new Intent(getApplicationContext(), AnswerQuestionnaireActivity.class);
                    startActivity(intent);
                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                    //startActivity(intent);
                }

            }
        });
    }
}
