package com.example.anusaratrokhum.myapplication.Questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anusaratrokhum.myapplication.GuestActivity;
import com.example.anusaratrokhum.myapplication.R;
import com.example.anusaratrokhum.myapplication.Test.testsumActivity;

public class QuestionnaireActivity extends AppCompatActivity {

    RadioButton myOption1, myOption2, myOption3,myOption4, myOption5, myOption6,myOption7, myOption8, myOption9,myOption10, myOption11, myOption12; //ปลุกกด
    int sum1,sum2,sum3,sum4,sum5,sum6;
    Button btn1;
    TextView textShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);


        ScrollView sv = new ScrollView(this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);


        myOption1 = (RadioButton) findViewById(R.id.radio1);
        myOption2 = (RadioButton) findViewById(R.id.radio2);
        myOption3 = (RadioButton) findViewById(R.id.radio3);
        myOption4 = (RadioButton) findViewById(R.id.radio4);
        myOption5 = (RadioButton) findViewById(R.id.radio5);
        myOption6 = (RadioButton) findViewById(R.id.radio6);
        myOption7 = (RadioButton) findViewById(R.id.radio7);
        myOption8 = (RadioButton) findViewById(R.id.radio8);
        myOption9 = (RadioButton) findViewById(R.id.radio9);
        myOption10 = (RadioButton) findViewById(R.id.radio10);
        myOption11 = (RadioButton) findViewById(R.id.radio11);
        myOption12 = (RadioButton) findViewById(R.id.radio12);



        btn1 = (Button) findViewById(R.id.resultbutton);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.resultbutton) {
                    Condition1();
                    Condition2();
                    Condition3();
                    Condition4();
                    Condition5();
                    Condition6();
                    Intent intent = new Intent(getApplicationContext(), AnswerQuestionnaireActivity.class);
                    intent.putExtra("sum1", sum1);
                    intent.putExtra("sum2", sum2);
                    intent.putExtra("sum3", sum3);
                    intent.putExtra("sum4", sum4);
                    intent.putExtra("sum5", sum5);
                    intent.putExtra("sum6", sum6);
                    startActivity(intent);

                }

            }
        });




    }
    public void Condition1() {
        if (myOption1.isChecked()) {
            sum1 = 1;
        }
        if (myOption2.isChecked()) {
            sum1 = 0;
        }
//        Toast.makeText(getApplicationContext(),sum1 + "",Toast.LENGTH_LONG).show();
    }
    public void Condition2() {
        if (myOption3.isChecked()) {
            sum2 = 5;
        }
        if (myOption4.isChecked()) {
            sum2 = 0;
        }
//        Toast.makeText(getApplicationContext(),sum1 + ""+sum2 + "",Toast.LENGTH_LONG).show();

    }
    public void Condition3() {
        if (myOption5.isChecked()) {
            sum3 = 1;
        }
        if (myOption6.isChecked()) {
            sum3 = 0;
        }
//        Toast.makeText(getApplicationContext(),sum1 + ""+sum2 + ""+sum3 + "",Toast.LENGTH_LONG).show();

    }
    public void Condition4() {
        if (myOption7.isChecked()) {
            sum4 = 3;
        }
        if (myOption8.isChecked()) {
            sum4 = 0;
        }
//        Toast.makeText(getApplicationContext(),sum1 + ""+sum2 + ""+sum3 + ""+sum4 + "",Toast.LENGTH_LONG).show();

    }
    public void Condition5() {
        if (myOption9.isChecked()) {
            sum5 = 5;
        }
        if (myOption10.isChecked()) {
            sum5 = 0;
        }
//        Toast.makeText(getApplicationContext(),sum1 + ""+sum2 + ""+sum3 + ""+sum4 + ""+sum5 + "",Toast.LENGTH_LONG).show();

    }
    public void Condition6() {
        if (myOption11.isChecked()) {
            sum6 = 5;
        }
        if (myOption12.isChecked()) {
            sum6 = 0;
        }
//        Toast.makeText(getApplicationContext(),sum1 + ""+sum2 + ""+sum3 + ""+sum4 + ""+sum5 + ""+sum6 + "",Toast.LENGTH_LONG).show();

    }
//    public void Datasum() {
//        int a = (sum1 + sum2 + sum3 + sum4 + sum5 + sum6);
//        String ANS = new String();
//
//        if (a == 0) {
//            ANS = "พบว่าคุณไม่มีความเสี่ยงมะเร็งเต้านม";
//        }
//        if (a <= 2 ) {
//            ANS = "พบว่าคุณอาจมีความเสี่ยงมะเร็งเต้านม";
//        }
//        if (a >= 3 ) {
//            ANS = "พบว่าคุณมีความเสี่ยงมะเร็งเต้านมเพิ่มสูงขึ้น";
//        }
//
////        Toast.makeText(getApplicationContext(),a + "",Toast.LENGTH_LONG).show();
//        textShow.setText(ANS);
//    }




}

//        final Button sum = (Button) findViewById(R.id.button6);
//        sum.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v.getId() == R.id.button6) {
//                    Intent intent = new Intent(getApplicationContext(), AnswerQuestionnaireActivity.class);
//                    startActivity(intent);
//                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
//                    //startActivity(intent);
//                }
//
//            }
//        });
