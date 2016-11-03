package com.example.anusaratrokhum.myapplication.About;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.anusaratrokhum.myapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AnsAboutActivity extends AppCompatActivity {

    String name,content;
    TextView text1,messege;

    ArrayList<String> listname = new ArrayList<>();
    ArrayList<String> listcontent = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans_about);

//        getList();

        name = getIntent().getStringExtra("name");
        content = getIntent().getStringExtra("content");

        text1 = (TextView) findViewById(R.id.textView11);
        text1.setText(name);

        messege = (TextView) findViewById(R.id.messege);
        messege.setText(content);

        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
    }



}
