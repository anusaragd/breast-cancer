package com.example.anusaratrokhum.myapplication.Test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.anusaratrokhum.myapplication.R;

public class test2Activity extends AppCompatActivity {

    RadioButton myOption1, myOption2, myOption3; //ปลุกกด
    Button btn1;
    String ans; //เก็บผลลัพธ์
    int sum1,sum2; //คำตอบ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        sum1 = getIntent().getIntExtra("sum1", 0);



        myOption1 = (RadioButton) findViewById(R.id.radioButton);
        myOption2 = (RadioButton) findViewById(R.id.radioButton2);
        myOption3 = (RadioButton) findViewById(R.id.radioButton3);

//        Condition(); // กำหนดค่าของปุ่ม

        btn1 = (Button) findViewById(R.id.nextbutton);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Condition(); // กำหนดค่าของปุ่ม
                if (v.getId() == R.id.nextbutton) {
                    Intent intent = new Intent(getApplicationContext(), test3Activity.class);
                    intent.putExtra("sum1", sum1);
                    intent.putExtra("sum2", sum2);
                    startActivity(intent);

                }

            }
        });
    }
    public void Condition(){
        if(myOption1.isChecked()){
            sum2 = 0;
        }
        if(myOption2.isChecked()){
            sum2 = 2;
        }
        if(myOption3.isChecked()){
            sum2 = 1;
        }
//        ans = String.valueOf(sum2);
        Toast.makeText(getApplicationContext(),sum1 + ""+sum2 + "",Toast.LENGTH_LONG).show();
//        Toast.makeText(getApplicationContext(),ans,Toast.LENGTH_LONG).show();

    }
}
