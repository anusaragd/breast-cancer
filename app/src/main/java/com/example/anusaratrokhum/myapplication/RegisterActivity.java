package com.example.anusaratrokhum.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.RequestBody;
import okhttp3.internal.http.StatusLine;

public class RegisterActivity extends AppCompatActivity {

    private Spinner daySpinner, monthSpinner, yearSpinner;
    private EditText Age;

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        daySpinner = (Spinner) findViewById(R.id.date);
        monthSpinner = (Spinner) findViewById(R.id.month);
        yearSpinner = (Spinner) findViewById(R.id.year);


        String[] day = getResources().getStringArray(R.array.day);
        ArrayAdapter<String> adapterEnglish = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, day);
        daySpinner.setAdapter(adapterEnglish);

        String[] month = getResources().getStringArray(R.array.month);
        ArrayAdapter<String> adaptermonth = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, month);
        monthSpinner.setAdapter(adaptermonth);

        String[] englishClub = getResources().getStringArray(R.array.year);
        ArrayAdapter<String> adapteryear = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, englishClub);
        yearSpinner.setAdapter(adapteryear);

//        final Button submit = (Button) findViewById(R.id.subbutt);
//        submit.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v.getId() == R.id.subbutt) {
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
//                    //startActivity(intent);
//                }
//
//            }
//        });

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        // btnSave
        final Button btnSave = (Button) findViewById(R.id.subbutt);
        // Perform action on click
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(SaveData())
                {
                    // When Save Complete
                }
            }
        });
        final Button cancel = (Button) findViewById(R.id.canbutt);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.canbutt) {
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(intent);
                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
                    //startActivity(intent);
                }

            }
        });

        birthday();

    }

    public boolean SaveData()
    {

        // txtUsername,txtPassword,txtName,txtEmail,txtTel
        final EditText txtUsername = (EditText)findViewById(R.id.username);
        final EditText txtPassword = (EditText)findViewById(R.id.password);
        final EditText txtEmail = (EditText)findViewById(R.id.email);
        final EditText txtName = (EditText)findViewById(R.id.name);
        final EditText txtlastName = (EditText)findViewById(R.id.lastname);



        // Dialog
        final AlertDialog.Builder ad = new AlertDialog.Builder(this);

        ad.setTitle("Error! ");
        ad.setIcon(android.R.drawable.btn_star_big_on);
        ad.setPositiveButton("Close", null);

        // Check Username
        if(txtUsername.getText().length() == 0)
        {
            ad.setMessage("Please input [Username] ");
            ad.show();
            txtUsername.requestFocus();
            return false;
        }
         // Check Password
        if(txtPassword.getText().length() == 0 )
        {
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
        if(txtName.getText().length() == 0)
        {
            ad.setMessage("Please input [Name] ");
            ad.show();
            txtName.requestFocus();
            return false;
        }
        // Check Email
        if(txtEmail.getText().length() == 0)
        {
            ad.setMessage("Please input [Email] ");
            ad.show();
            txtEmail.requestFocus();
            return false;
        }
         // Check Tel
        if(txtlastName.getText().length() == 0)
        {
            ad.setMessage("Please input [LastName] ");
            ad.show();
            txtlastName.requestFocus();
            return false;
        }


        String url = "http://192.168.1.2/breast-cancer/register2.php";

//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("sUsername", txtUsername.getText().toString()));
//        params.add(new BasicNameValuePair("sPassword", txtPassword.getText().toString()));
//        params.add(new BasicNameValuePair("sName", txtName.getText().toString()));
//        params.add(new BasicNameValuePair("sEmail", txtEmail.getText().toString()));
//        params.add(new BasicNameValuePair("slastName", txtEmail.getText().toString()));


        /** Get result from Server (Return the JSON Code)
         * StatusID = ? [0=Failed,1=Complete]
         * Error	= ?	[On case error return custom error message]
         *
         * Eg Save Failed = {"StatusID":"0","Error":"Email Exists!"}
         * Eg Save Complete = {"StatusID":"1","Error":""}
         */

//        String resultServer  = getHttpPost(url,params);

        /*** Default Value ***/
        String strStatusID = "0";
        String strError = "Unknow Status!";

        JSONObject c;
        try {
            c = new JSONObject(url);
            strStatusID = c.getString("StatusID");
            strError = c.getString("Error");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Prepare Save Data
        if(strStatusID.equals("0"))
        {
            ad.setMessage(strError);
            ad.show();
        }
        else
        {
            Toast.makeText(RegisterActivity.this, "Save Data Successfully", Toast.LENGTH_SHORT).show();
            txtUsername.setText("");
            txtPassword.setText("");
            txtlastName.setText("");
            txtName.setText("");
            txtEmail.setText("");

        }


        return true;
    }


//    public String getHttpPost(String url,List<NameValuePair> params) {
//        StringBuilder str = new StringBuilder();
//        HttpClient client = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost(url);
//
//        try {
//            httpPost.setEntity(new UrlEncodedFormEntity(params));
//            HttpResponse response = client.execute(httpPost);
//            StatusLine statusLine = response.getStatusLine();
//            int statusCode = statusLine.getStatusCode();
//            if (statusCode == 200) { // Status OK
//                HttpEntity entity = response.getEntity();
//                InputStream content = entity.getContent();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    str.append(line);
//                }
//            } else {
//                Log.e("Log", "Failed to download result..");
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return str.toString();
//    }






    private void birthday() {

        Age = (EditText) findViewById(R.id.sumtext);

//        for(int i = 0; i>; i++){
//
//        }
    }


}
