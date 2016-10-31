package com.example.anusaratrokhum.myapplication.Posts;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.anusaratrokhum.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class posts1Activity extends AppCompatActivity {

    EditText edt_name, edt_contents;
    Button btn_insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts1);

        edt_name = (EditText)findViewById(R.id.edt_name);
        edt_contents = (EditText)findViewById(R.id.edt_contents);
        btn_insert = (Button)findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncTask<Void, Void, String>() {
                    @Override
                    protected String doInBackground(Void... voids) {
                        getHttp http = new getHttp();
                        String response = null;
                        try {
                            response = http.run("http://192.168.1.2/breast-cancer/insert2.php");
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        return response;
                    }

                    @Override
                    protected void onPostExecute(String string) {
                        super.onPostExecute(string);

                        Log.e( "onPostExecute: ", string);
                    }
                }.execute();



            }
        });


    }


    public class getHttp {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("p_name", edt_name.getText().toString())
                .addFormDataPart("p_content", edt_contents.getText().toString())
                .build();

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
