package com.example.anusaratrokhum.myapplication.Test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.anusaratrokhum.myapplication.R;

public class test5Activity extends AppCompatActivity {
    RadioButton myOption1, myOption2, myOption3; //ปลุกกด
    Button btn1;
    String ans; //เก็บผลลัพธ์
    int sum5; //คำตอบ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);

        myOption1 = (RadioButton) findViewById(R.id.radio1);
        myOption2 = (RadioButton) findViewById(R.id.radio2);
        myOption3 = (RadioButton) findViewById(R.id.radio3);

//        Condition(); // กำหนดค่าของปุ่ม

        btn1 = (Button) findViewById(R.id.nextbutton);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Condition(); // กำหนดค่าของปุ่ม
                if (v.getId() == R.id.nextbutton) {
                    Intent intent = new Intent(getApplicationContext(), test6Activity.class);
                    startActivity(intent);

                }

            }
        });
    }
    public void Condition(){
        if(myOption1.isChecked()){
            sum5 = 0;
        }
        if(myOption2.isChecked()){
            sum5 = 2;
        }
        if(myOption3.isChecked()){
            sum5 = 1;
        }
        ans = String.valueOf(sum5);
//        Toast.makeText(getApplicationContext(),ans,Toast.LENGTH_LONG).show();

    }
}
