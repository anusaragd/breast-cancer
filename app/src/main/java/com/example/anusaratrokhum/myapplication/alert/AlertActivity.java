package com.example.anusaratrokhum.myapplication.alert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.anusaratrokhum.myapplication.R;
import com.example.anusaratrokhum.myapplication.RegisterActivity;

public class AlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        final ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.imageButton) {
                    Intent intent = new Intent(getApplicationContext(), alert1Activity.class);
                    startActivity(intent);
                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                    //startActivity(intent);
                }

            }
        });
    }
}
