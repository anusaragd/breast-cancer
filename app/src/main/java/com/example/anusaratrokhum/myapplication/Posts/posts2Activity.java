package com.example.anusaratrokhum.myapplication.Posts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.anusaratrokhum.myapplication.R;

public class posts2Activity extends AppCompatActivity {

    String name,content;
    TextView text1;
    EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts2);

        name = getIntent().getStringExtra("name");
        content = getIntent().getStringExtra("content");

        text1 = (TextView) findViewById(R.id.textView11);
        text1.setText(name);


    }
}
