package com.example.anusaratrokhum.myapplication.Test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.anusaratrokhum.myapplication.R;

public class testsumActivity extends AppCompatActivity {

    TextView textShow;
    test1Activity sum1 = new test1Activity();
    test2Activity sum2 = new test2Activity();
    test3Activity sum3 = new test3Activity();
    test4Activity sum4 = new test4Activity();
    test5Activity sum5 = new test5Activity();
    test6Activity sum6 = new test6Activity();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testsum);

        textShow = (TextView) findViewById(R.id.textView15);

        Datasum();


    }
    public void Datasum(){
        String a = String.valueOf(sum1) + String.valueOf(sum2) + String.valueOf(sum3) + String.valueOf(sum4) + String.valueOf(sum5) + String.valueOf(sum6);
//        int a = (sum1.getClass(String) + sum2.getClass(String) + sum3.getClass(String) + sum4.getClass(String) + sum5.getClass(String) + sum6.getClass(String));
        String sum = new String();







    }
}
