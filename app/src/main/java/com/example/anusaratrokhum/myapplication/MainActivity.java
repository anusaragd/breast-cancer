package com.example.anusaratrokhum.myapplication;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private Button signin;
    private EditText username, password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        bindWidget();

        controlActivity();

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

    private void controlActivity() {

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              /*  String strUsername = username.getText().toString().trim();
                String strPassword = password.getText().toString().trim();

                if (strUsername.equals("") || strPassword.equals("")) {

                    Toast.makeText(Login2Activity.this,"กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_SHORT).show();

                }*/

                if (checkEmpty()) {

                    LoginData();

                }

            }
        });

    }
    private boolean checkEmpty() {


        if (password.getText().length() == 0 && username.getText().length() == 0){

            Toast.makeText(MainActivity.this,"กรุณากรอกชื่อผู้ใช้และรหัสผ่าน", Toast.LENGTH_SHORT).show();

            return false;

        }else if (password.getText().length() == 0) {

            Toast.makeText(MainActivity.this,"กรุณากรอกรหัสผ่าน", Toast.LENGTH_SHORT).show();

            return false;

        }else if (username.getText().length() == 0) {

            Toast.makeText(MainActivity.this,"กรุณากรอกชื่อผู้ใช้", Toast.LENGTH_SHORT).show();

            return false;

        }

        return true;

    }

    private void bindWidget() {

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        signin = (Button) findViewById(R.id.signin);

    }
    public void LoginData() {
        HttpUrl httpUrl = HttpUrl.parse(JSONObtained.BASE_URL + "checklogin.php");
        RequestBody formBody = new FormBody.Builder()
                .add("username", username.getText().toString())
                .add("password", password.getText().toString())
                .build();
        JSONObtained.getInstance().newCall(JSONObtained.postRequest(httpUrl, formBody)).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {

                final String json = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
//                        Toast.makeText(getApplicationContext(),json,Toast.LENGTH_SHORT).show();

                        String status = null;

                        try {
                            JSONObject jObj = new JSONObject(json);
                            status = jObj.getString("StatusID");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if (status.equals("1")) {
                            Toast.makeText(getApplicationContext(), "ยินดีต้อนรับ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
//                        Intent intentObj = new Intent(MainActivity.this,Main2Activity.class);
                        } else if (status.equals("0")) {
                            Toast.makeText(getApplicationContext(), "ไม่มีบัญชีผู้ใช้นี้", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
//                        Intent intentObj = new Intent(MainActivity.this,Main2Activity.class);
                        }


                    }
                });
            }


        });

    }




//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        final Button signin = (Button) findViewById(R.id.signin);
//        signin.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v.getId() == R.id.signin) {
//                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                    startActivity(intent);
//                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
//                    //startActivity(intent);
//                }
//
//            }
//        });
//        final Button signup = (Button) findViewById(R.id.signup);
//        signup.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v.getId() == R.id.signup) {
//                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
//                    startActivity(intent);
//                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
//                    //startActivity(intent);
//                }
//
//            }
//        });
//
//        final Button skip = (Button) findViewById(R.id.skipbut);
//        skip.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v.getId() == R.id.skipbut) {
//                    Intent intent = new Intent(getApplicationContext(), GuestActivity.class);
//                    startActivity(intent);
//                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
//                    //startActivity(intent);
//                }
//
//            }
//        });
//    }

//    public void onClickNext(View view){
//        Button skipbut = (Button)findViewById(R.id.skipbut);
//        Intent intent = new Intent(MainActivity.this,GuestActivity.class);
//        startActivity(intent);
//
//    }

}
