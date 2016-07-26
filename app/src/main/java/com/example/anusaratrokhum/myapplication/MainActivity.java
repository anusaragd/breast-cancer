package com.example.anusaratrokhum.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button signin = (Button) findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.signin) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                    //startActivity(intent);
                }

            }
        });
        final Button signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.signup) {
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(intent);
                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                    //startActivity(intent);
                }

            }
        });

        final Button skip = (Button) findViewById(R.id.skipbut);
        skip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.skipbut) {
                    Intent intent = new Intent(getApplicationContext(), GuestActivity.class);
                    startActivity(intent);
                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                    //startActivity(intent);
                }

            }
        });
    }

//    public void onClickNext(View view){
//        Button skipbut = (Button)findViewById(R.id.skipbut);
//        Intent intent = new Intent(MainActivity.this,GuestActivity.class);
//        startActivity(intent);
//
//    }

}
