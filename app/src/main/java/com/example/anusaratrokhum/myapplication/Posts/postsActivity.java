package com.example.anusaratrokhum.myapplication.Posts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anusaratrokhum.myapplication.GuestActivity;
import com.example.anusaratrokhum.myapplication.Posts.posts1Activity;
import com.example.anusaratrokhum.myapplication.R;
import com.example.anusaratrokhum.myapplication.Test.testsumActivity;

public class postsActivity extends AppCompatActivity {

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        btn1 = (Button) findViewById(R.id.postbutton);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.postbutton) {
                    Intent intent = new Intent(getApplicationContext(), posts1Activity.class);
                    startActivity(intent);

                }

            }
        });

    }
}


//        final TextView skip = (TextView) findViewById(R.id.addposts);
//        skip.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v.getId() == R.id.addposts) {
//                    Intent intent = new Intent(getApplicationContext(), posts1Activity.class);
//                    startActivity(intent);
//                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
//                    //startActivity(intent);
//                }
//
//            }
//        });

//    public void onClickNext(View view){
//        Button skipbut = (Button)findViewById(R.id.skipbut);
//        Intent intent = new Intent(postsActivity.this,posts1Activity.class);
//        startActivity(intent);
//    }