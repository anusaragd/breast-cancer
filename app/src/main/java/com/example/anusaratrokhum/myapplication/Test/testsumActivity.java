package com.example.anusaratrokhum.myapplication.Test;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anusaratrokhum.myapplication.R;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class testsumActivity extends AppCompatActivity {

    TextView textShow, txtResult;
    int sum1,sum2,sum3,sum4,sum5,sum6; //คำตอบ




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testsum);

        sum1 = getIntent().getIntExtra("sum1", 0);
        sum2 = getIntent().getIntExtra("sum2", 0);
        sum3 = getIntent().getIntExtra("sum3", 0);
        sum4 = getIntent().getIntExtra("sum4", 0);
        sum5 = getIntent().getIntExtra("sum5", 0);
        sum6 = getIntent().getIntExtra("sum6", 0);

        textShow = (TextView) findViewById(R.id.textView15);
        Datasum();

        txtResult = (TextView) findViewById(R.id.txtResult);

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        getHttp http = new getHttp();
        String response = null;
        try {
            response = http.run("http://192.168.1.2/getString.php");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        txtResult.setText(response);

    }
    public class getHttp {
        OkHttpClient client = new OkHttpClient();

        String run(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        }
    }
    public void Datasum() {
        int a = (sum1 + sum2 + sum3 + sum4 + sum5 + sum6);
        String ANS = new String();

        if ((a == 0) || (a == 1) || (a == 2) || (a == 3) || (a == 4)) {
            ANS = "เป็นปกติ";
        }
        if ((a == 5) || (a == 6) || (a == 7) || (a == 8)) {
            ANS = "เสี่ยงต่อการเป็นมะเร็งเต้านม";
        }
        if ((a == 9) || (a == 10) || (a == 11) || (a == 12)) {
            ANS = "ตรวจพบว่าคุณเป็นมะเร็งเต้านม";
        }

        Toast.makeText(getApplicationContext(),a + "",Toast.LENGTH_LONG).show();
        textShow.setText(ANS);
    }



    public int getSum1() {
        return sum1;
    }

    public void setSum1(int sum1) {
        this.sum1 = sum1;
    }

    public int getSum2() {
        return sum2;
    }

    public void setSum2(int sum2) {
        this.sum2 = sum2;
    }

    public int getSum3() {
        return sum3;
    }

    public void setSum3(int sum3) {
        this.sum3 = sum3;
    }

    public int getSum4() {
        return sum4;
    }

    public void setSum4(int sum4) {
        this.sum4 = sum4;
    }

    public int getSum5() {
        return sum5;
    }

    public void setSum5(int sum5) {
        this.sum5 = sum5;
    }

    public int getSum6() {
        return sum6;
    }

    public void setSum6(int sum6) {
        this.sum6 = sum6;
    }


}
