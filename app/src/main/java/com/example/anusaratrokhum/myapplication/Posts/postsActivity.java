package com.example.anusaratrokhum.myapplication.Posts;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.anusaratrokhum.myapplication.GuestActivity;
import com.example.anusaratrokhum.myapplication.Posts.posts1Activity;
import com.example.anusaratrokhum.myapplication.R;
import com.example.anusaratrokhum.myapplication.Test.testsumActivity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class postsActivity extends AppCompatActivity {

    Button btn1;
    TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        txtResult = (TextView)findViewById(R.id.txtResult);


        btn1 = (Button) findViewById(R.id.postbutton);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (v.getId() == R.id.postbutton) {
                    Intent intent = new Intent(getApplicationContext(), posts1Activity.class);
                    startActivity(intent);

                }

            }
        });

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        getHttp http = new getHttp();
        String response = null;
        try {
            response = http.run("http://192.168.1.2/breast-cancer/post.php");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public class getHttp {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
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
// Permission StrictMode
//        if (android.os.Build.VERSION.SDK_INT > 9) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }
//
//        // listView1
//        final ListView lisView1 = (ListView)findViewById(R.id.listView);
//
//        /
//
//        String url = "http://192.168.1.2/breast-cancer/post.php";
//
//        try {
//
//            JSONArray data = new JSONArray(getJSONUrl(url));
//
//            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
//            HashMap<String, String> map;
//
//            for(int i = 0; i < data.length(); i++){
//                JSONObject c = data.getJSONObject(i);
//
//                map = new HashMap<String, String>();
//                map.put("Name", c.getString("Name"));
//                MyArrList.add(map);
//
//            }
//
//
//            SimpleAdapter sAdap;
//            sAdap = new SimpleAdapter(postsActivity.this, MyArrList, R.layout.activity_column,
//                    new String[] {"Name"}, new int[] {R.id.ColName});
//            lisView1.setAdapter(sAdap);
//
//            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);
//            // OnClick Item
//            lisView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                public void onItemClick(AdapterView<?> myAdapter, View myView,
//                                        int position, long mylng) {
//
////                    String sMemberID = MyArrList.get(position).get("MemberID")
////                            .toString();
//                    String sName = MyArrList.get(position).get("Name")
//                            .toString();
////                    String sTel = MyArrList.get(position).get("Tel")
////                            .toString();
//
//                    //String sMemberID = ((TextView) myView.findViewById(R.id.ColMemberID)).getText().toString();
//                    // String sName = ((TextView) myView.findViewById(R.id.ColName)).getText().toString();
//                    // String sTel = ((TextView) myView.findViewById(R.id.ColTel)).getText().toString();
//
//                    viewDetail.setIcon(android.R.drawable.btn_star_big_on);
//                    viewDetail.setTitle("Member Detail");
//                    viewDetail.setMessage("Name : " + sName);
//                    viewDetail.setPositiveButton("OK",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//                                    // TODO Auto-generated method stub
//                                    dialog.dismiss();
//                                }
//                            });
//                    viewDetail.show();
//
//                }
//            });
//
//
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }



//        final TextView skip = (TextView) findViewById(R.id.addposts);
//        skip.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v.getId() == R.id.addposts) {
//                    Intent intent = new Intent(getApplicationContext(), posts1Activity.class);
//                    startActivity(intent);
//                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
//                    //startActivity(intent);
//                }
//
//            }
//        });

//    public void onClickNext(View view){
//        Button skipbut = (Button)findViewById(R.id.skipbut);
//        Intent intent = new Intent(postsActivity.this,posts1Activity.class);
//        startActivity(intent);
//    }