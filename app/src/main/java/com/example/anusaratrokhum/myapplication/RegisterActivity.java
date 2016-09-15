package com.example.anusaratrokhum.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import okhttp3.RequestBody;

public class RegisterActivity extends AppCompatActivity {

    private Spinner daySpinner, monthSpinner, yearSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        daySpinner = (Spinner) findViewById(R.id.date);
        monthSpinner = (Spinner) findViewById(R.id.month);
        yearSpinner = (Spinner) findViewById(R.id.year);


        String[] day = getResources().getStringArray(R.array.day);
        ArrayAdapter<String> adapterEnglish = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, day);
        daySpinner.setAdapter(adapterEnglish);

        String[] month = getResources().getStringArray(R.array.month);
        ArrayAdapter<String> adaptermonth = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, month);
        monthSpinner.setAdapter(adaptermonth);

        String[] englishClub = getResources().getStringArray(R.array.year);
        ArrayAdapter<String> adapteryear = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, englishClub);
        yearSpinner.setAdapter(adapteryear);

//        final Button submit = (Button) findViewById(R.id.subbutt);
//        submit.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v.getId() == R.id.subbutt) {
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
//                    //startActivity(intent);
//                }
//
//            }
//        });
        final Button cancel = (Button) findViewById(R.id.canbutt);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.subbutt) {
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(intent);
                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                    //startActivity(intent);
                }

            }
        });

    }
}
