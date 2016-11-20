package com.example.anusaratrokhum.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.StatusLine;

public class RegisterActivity extends AppCompatActivity {

    private Button ib;
    private Calendar cal;
    private int day;
    private int month;
    private int year;
    private EditText et;


    EditText txtUsername , txtPassword, txtEmail, txtName, txtlastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // mDateButton = (Button) findViewById(R.id.date_button);
        inits();
        Button btnSave = (Button) findViewById(R.id.subbutt);
        // Perform action on click
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkFields()) {
                    saveData();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                }
            }
        });
        final Button cancel = (Button) findViewById(R.id.canbutt);
        assert cancel != null;
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }


//    @Override
//    public void onClick(View v) {
//        showDialog(0);
//    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            et.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };

    public void inits(){
        txtUsername = (EditText) findViewById(R.id.username);
        txtPassword = (EditText) findViewById(R.id.password);
        txtEmail = (EditText) findViewById(R.id.email);
        txtName = (EditText) findViewById(R.id.name);
        txtlastName = (EditText) findViewById(R.id.lastname);
        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);
        et = (EditText) findViewById(R.id.editText);
        ib = (Button) findViewById(R.id.Button1);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
                new AsyncTask<Void, Void, String>() {
                    @Override
                    protected String doInBackground(Void... voids) {
                        getHttp http = new getHttp();
                        String response = null;
                        try {
                            response = http.run("http://localhost/breast-cancer/register2.php");
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        return response;
                    }

                    @Override
                    protected void onPostExecute(String string) {
                        super.onPostExecute(string);

                        Log.e( "onPostExecute: ",string + "GG");


                /*try {
                    JSONObject gg = new JSONObject(string);
                    Log.e( "onPostExecute: ", gg.getString("StatusIDStatusID" ));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
*/

                    }
                }.execute();
            }
        });
    }

    public boolean checkFields() {


        // Dialog
        final AlertDialog.Builder ad = new AlertDialog.Builder(this);

        ad.setTitle("Error! ");
        ad.setIcon(android.R.drawable.btn_star_big_on);
        ad.setPositiveButton("Close", null);

        // Check Username
        if (txtUsername.getText().length() == 0) {
            ad.setMessage("Please input [Username] ");
            ad.show();
            txtUsername.requestFocus();
            return false;
        }
        // Check Password
        if (txtPassword.getText().length() == 0) {
            ad.setMessage("Please input [Password ");
            ad.show();
            txtPassword.requestFocus();
            return false;
        }
//        // Check Password and Confirm Password (Match)
//        if(!txtPassword.getText().toString().equals(txtConPassword.getText().toString()))
//        {
//            ad.setMessage("Password and Confirm Password Not Match! ");
//            ad.show();
//            txtConPassword.requestFocus();
//            return false;
//        }
        // Check Name
        if (txtName.getText().length() == 0) {
            ad.setMessage("Please input [Name] ");
            ad.show();
            txtName.requestFocus();
            return false;
        }
        // Check Email
        if (txtEmail.getText().length() == 0) {
            ad.setMessage("Please input [Email] ");
            ad.show();
            txtEmail.requestFocus();
            return false;
        }
        // Check Tel
        if (txtlastName.getText().length() == 0) {
            ad.setMessage("Please input [LastName] ");
            ad.show();
            txtlastName.requestFocus();
            return false;
        }
        return true;
    }

    private void saveData() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                getHttp http = new getHttp();
                String response = null;
                try {
                    response = http.run("http://localhost/breast-cancer/register2.php");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return response;
            }

            @Override
            protected void onPostExecute(String string) {
                super.onPostExecute(string);

                Log.e( "onPostExecute: ",string + "GG");


                /*try {
                    JSONObject gg = new JSONObject(string);
                    Log.e( "onPostExecute: ", gg.getString("StatusIDStatusID" ));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
*/

            }
        }.execute();


    }

    public class getHttp {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", "sss")
                .addFormDataPart("password", "sss")
                .addFormDataPart("email", "sss")
                .addFormDataPart("name", "sss")
                .addFormDataPart("lastname", "sss")
                .build();
        /*.addFormDataPart("username", txtUsername.getText().toString())
                .addFormDataPart("password", txtPassword.getText().toString())
                .addFormDataPart("email", txtEmail.getText().toString())
                .addFormDataPart("name", txtName.getText().toString())
                .addFormDataPart("lastname", txtlastName.getText().toString())*/
        String run(String url) throws IOException {
            Request request = new Request.Builder()
                    .post(requestBody)
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        }
    }

}


//
//   // private TextView tvDate;
//    Button Button1;
//
//    EditText txtUsername , txtPassword, txtEmail, txtName, txtlastName;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);
//        inits();
//
////
////
////        final Button submit = (Button) findViewById(R.id.subbutt);
////        submit.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////                if (v.getId() == R.id.subbutt) {
////                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
////                    startActivity(intent);
////                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
////                    //startActivity(intent);
////                }
////
////            }
////        });
//
//
//        // btnSave
//         /*Button btnSave = (Button) findViewById(R.id.subbutt);
//        // Perform action on click
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (checkFields()) {
//                    saveData();
//                }
//            }
//        });
//        final Button cancel = (Button) findViewById(R.id.canbutt);
//        assert cancel != null;
//        cancel.setOnClickListener(new View.OnClickListener() {
//                                      @Override
//                                      public void onClick(View v) {
//                                          Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
//                                          startActivity(intent);
//                                      }
//                                  });
//
//                //birthday();
//*/
//    }
//
//    // Get Current Date
//    public void inits(){
//        //tvDate = (TextView) findViewById(R.id.tv_date);
//        txtUsername = (EditText) findViewById(R.id.username);
//        txtPassword = (EditText) findViewById(R.id.password);
//        txtEmail = (EditText) findViewById(R.id.email);
//        txtName = (EditText) findViewById(R.id.name);
//        txtlastName = (EditText) findViewById(R.id.lastname);
//        Button1 = (Button) findViewById(R.id.button);
//        Button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new AsyncTask<Void, Void, String>() {
//                    @Override
//                    protected String doInBackground(Void... voids) {
//                        getHttp http = new getHttp();
//                        String response = null;
//                        try {
//                            response = http.run("http://localhost/breast-cancer/register2.php");
//                        } catch (IOException e) {
//                            // TODO Auto-generated catch block
//                            e.printStackTrace();
//                        }
//                        return response;
//                    }
//
//                    @Override
//                    protected void onPostExecute(String string) {
//                        super.onPostExecute(string);
//
//                        Log.e( "onPostExecute: ",string + "GG");
//
//
//                /*try {
//                    JSONObject gg = new JSONObject(string);
//                    Log.e( "onPostExecute: ", gg.getString("StatusIDStatusID" ));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//*/
//
//                    }
//                }.execute();
//            }
//        });
//    }
//
//    public boolean checkFields() {
//
//
//        // Dialog
//        final AlertDialog.Builder ad = new AlertDialog.Builder(this);
//
//        ad.setTitle("Error! ");
//        ad.setIcon(android.R.drawable.btn_star_big_on);
//        ad.setPositiveButton("Close", null);
//
//        // Check Username
//        if (txtUsername.getText().length() == 0) {
//            ad.setMessage("Please input [Username] ");
//            ad.show();
//            txtUsername.requestFocus();
//            return false;
//        }
//        // Check Password
//        if (txtPassword.getText().length() == 0) {
//            ad.setMessage("Please input [Password ");
//            ad.show();
//            txtPassword.requestFocus();
//            return false;
//        }
////        // Check Password and Confirm Password (Match)
////        if(!txtPassword.getText().toString().equals(txtConPassword.getText().toString()))
////        {
////            ad.setMessage("Password and Confirm Password Not Match! ");
////            ad.show();
////            txtConPassword.requestFocus();
////            return false;
////        }
//        // Check Name
//        if (txtName.getText().length() == 0) {
//            ad.setMessage("Please input [Name] ");
//            ad.show();
//            txtName.requestFocus();
//            return false;
//        }
//        // Check Email
//        if (txtEmail.getText().length() == 0) {
//            ad.setMessage("Please input [Email] ");
//            ad.show();
//            txtEmail.requestFocus();
//            return false;
//        }
//        // Check Tel
//        if (txtlastName.getText().length() == 0) {
//            ad.setMessage("Please input [LastName] ");
//            ad.show();
//            txtlastName.requestFocus();
//            return false;
//        }
//        return true;
//    }
//
//    private void saveData() {
//        new AsyncTask<Void, Void, String>() {
//            @Override
//            protected String doInBackground(Void... voids) {
//                getHttp http = new getHttp();
//                String response = null;
//                try {
//                    response = http.run("http://localhost/breast-cancer/register2.php");
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//                return response;
//            }
//
//            @Override
//            protected void onPostExecute(String string) {
//                super.onPostExecute(string);
//
//                Log.e( "onPostExecute: ",string + "GG");
//
//
//                /*try {
//                    JSONObject gg = new JSONObject(string);
//                    Log.e( "onPostExecute: ", gg.getString("StatusIDStatusID" ));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//*/
//
//            }
//        }.execute();
//    }
//
//    public class getHttp {
//        OkHttpClient client = new OkHttpClient();
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("username", "sss")
//                .addFormDataPart("password", "sss")
//                .addFormDataPart("email", "sss")
//                .addFormDataPart("name", "sss")
//                .addFormDataPart("lastname", "sss")
//                .build();
//        /*.addFormDataPart("username", txtUsername.getText().toString())
//                .addFormDataPart("password", txtPassword.getText().toString())
//                .addFormDataPart("email", txtEmail.getText().toString())
//                .addFormDataPart("name", txtName.getText().toString())
//                .addFormDataPart("lastname", txtlastName.getText().toString())*/
//        String run(String url) throws IOException {
//            Request request = new Request.Builder()
//                    .post(requestBody)
//                    .url(url)
//                    .build();
//            Response response = client.newCall(request).execute();
//            return response.body().string();
//        }
//    }
//}
//
















