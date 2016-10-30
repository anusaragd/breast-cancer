package com.example.anusaratrokhum.myapplication.alert;

import android.app.KeyguardManager;
import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.anusaratrokhum.myapplication.R;

public class alert1Activity extends AppCompatActivity {

    PowerManager pm;
    PowerManager.WakeLock wl;
    KeyguardManager km;
    KeyguardManager.KeyguardLock kl;
    Ringtone r;

    Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert1);
    }}
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        Log.i("ShowEvent", "onCreate() in DismissLock");
//        pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
//        km=(KeyguardManager)getSystemService(Context.KEYGUARD_SERVICE);
//        kl=km.newKeyguardLock("ShowEvent");
//        wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP| PowerManager.ON_AFTER_RELEASE, "ShowEvent");
//        wl.acquire(); //wake up the screen
//        kl.disableKeyguard();
//
//        setContentView(R.layout.activity_alert1);
//
//        btnStop = (Button)findViewById(R.id.btnStop);
//        btnStop.setOnClickListener(this);
//
//        }
//
//
//    @Override
//    public void onClick(View v) {
//        if(v.getId() == R.id.btnStop){
//            AlertActivity.listValue.remove(0);
//            this.finish();
//        }
//    }
//
//    @Override
//    protected void onResume() {
//
//        super.onResume();
//        wl.acquire();//must call this!
//        Uri notif = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
//        if(notif==null){
//            notif = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
//            if(notif==null){
//                notif = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//            }
//        }
//        r = RingtoneManager.getRingtone(getApplicationContext(), notif);
//        r.play();
//
//
//    }
//
//    @Override
//    public void onPause(){
//        super.onPause();
//        wl.release();
//        if(r.isPlaying()){
//            r.stop();
//        }
//    }
//}
