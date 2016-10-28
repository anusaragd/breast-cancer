package com.example.anusaratrokhum.myapplication.Test;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.anusaratrokhum.myapplication.R;


public class test1Activity extends AppCompatActivity {

    RadioButton myOption1, myOption2, myOption3; //ปลุกกด
    Button btn1;
    String ans; //เก็บผลลัพธ์
    int sum1; //คำตอบ


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        myOption1 = (RadioButton) findViewById(R.id.radio1);
        myOption2 = (RadioButton) findViewById(R.id.radio2);
        myOption3 = (RadioButton) findViewById(R.id.radio3);

//        Condition(); // กำหนดค่าของปุ่ม

        btn1 = (Button) findViewById(R.id.nextbutton);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Condition(); // กำหนดค่าของปุ่ม
                if (v.getId() == R.id.nextbutton) {
                    Intent intent = new Intent(getApplicationContext(), test2Activity.class);
                    intent.putExtra("sum1", sum1);
                    startActivity(intent);

                }

            }
        });


    }
    public void Condition(){
        if(myOption1.isChecked()){
            sum1 = 0;
        }
        if(myOption2.isChecked()){
            sum1 = 2;
        }
        if(myOption3.isChecked()){
            sum1 = 1;
        }

//        ans = String.valueOf(sum1);
        Toast.makeText(getApplicationContext(),sum1 + "",Toast.LENGTH_LONG).show();

    }


}
//        btn1.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                Toast.makeText(test1Activity.this,
//                        "RadioButton 1 : " + myOption1.isChecked() + "\n"+
//                                "RadioButton 2 : " + myOption2.isChecked() + "\n" +
//                                "RadioButton 3 : " + myOption3.isChecked(),
//                        Toast.LENGTH_LONG).show();
//            }
//        });
//
//    };


//
//        myOption1 = (RadioButton)findViewById(R.id.radio1);
//        myOption2 = (RadioButton)findViewById(R.id.radio2);
//        myOption3 = (RadioButton)findViewById(R.id.radio3);
//        myOption1.setOnClickListener(myOptionOnClickListener);
//        myOption2.setOnClickListener(myOptionOnClickListener);
//        myOption3.setOnClickListener(myOptionOnClickListener);
//    }
//
//    RadioButton.OnClickListener myOptionOnClickListener =
//            new RadioButton.OnClickListener()
//            {
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
//                    Toast.makeText(test1Activity.this,
//                            "RadioButton 1 : " + myOption1.isChecked() + "\n"+
//                                    "RadioButton 2 : " + myOption2.isChecked() + "\n" +
//                                    "RadioButton 3 : " + myOption3.isChecked(),
//                            Toast.LENGTH_LONG).show();
//
//                }
//            };
//}
