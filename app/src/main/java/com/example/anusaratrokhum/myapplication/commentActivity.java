package com.example.anusaratrokhum.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.anusaratrokhum.myapplication.DataManager.DataAccountManager;
import com.example.anusaratrokhum.myapplication.Posts.posts2Activity;
import com.example.anusaratrokhum.myapplication.Posts.postsActivity;
import com.example.anusaratrokhum.myapplication.Test.testActivity;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class commentActivity extends AppCompatActivity {
    EditText comment;
    Button sub,can ;
    String user ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        user = DataAccountManager.getInstance().getUsername();

        comment = (EditText)findViewById(R.id.comment);
        sub = (Button)findViewById(R.id.button8);
        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(commentActivity.this, posts2Activity.class);
                startActivity(intent);
            }

        }) ;



    }
}