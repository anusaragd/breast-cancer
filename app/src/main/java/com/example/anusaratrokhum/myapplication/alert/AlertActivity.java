package com.example.anusaratrokhum.myapplication.alert;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TimePicker;

import com.example.anusaratrokhum.myapplication.R;
import com.example.anusaratrokhum.myapplication.RegisterActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class AlertActivity extends AppCompatActivity {

    TimePicker myTimePicker;
    Button buttonstartSetDialog;
    private ListView listAlarm;
    public static ArrayList<String> listValue;

    TimePickerDialog timePickerDialog;

    final static int RQS_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

//        listAlarm = (ListView)findViewById(R.id.listView1);
//        listValue = new ArrayList<String>();
//
//        buttonstartSetDialog = (Button)findViewById(R.id.startSetDialog);
//        buttonstartSetDialog.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View v) {
//                //openTimePickerDialog(true);
//                showTimePickerDialog(buttonstartSetDialog);
//            }});
//
//    }
//    public void showTimePickerDialog(View v) {
//        DialogFragment newFragment = new TimePickerFragment();
//        newFragment.show(getFragmentManager(), "timePicker");
//    }
//
//    class TimePickerFragment extends DialogFragment
//            implements TimePickerDialog.OnTimeSetListener {
//
//        int callCount = 0;
//
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//
//            final Calendar c = Calendar.getInstance();
//            int hour = c.get(Calendar.HOUR_OF_DAY);
//            int minute = c.get(Calendar.MINUTE);
//
//            return new TimePickerDialog(getActivity(), this, hour, minute,
//                    DateFormat.is24HourFormat(getActivity()));
//        }
//
//        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//            if(callCount==0){
//                // Do something with the time chosen by the user
//                Calendar cal = Calendar.getInstance();
//                cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
//                cal.set(Calendar.MINUTE, minute);
//
//                setAlarm(cal);
//            }
//            callCount++;
//        }
//    }
//
//    private void setAlarm(Calendar targetCal){
//
//        listValue.add(targetCal.getTime()+"");
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listValue);
//        listAlarm.setAdapter(adapter);
//
//        final int _id = (int) System.currentTimeMillis();
//
//        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), _id, intent, 0);
//        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listValue);
//        listAlarm.setAdapter(adapter);
//    }
    }
}

//        final ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v.getId() == R.id.imageButton) {
//                    Intent intent = new Intent(getApplicationContext(), alert1Activity.class);
//                    startActivity(intent);
//                    //Intent intent = new Intent(getApplicationContext(), homeActivity.class);
//                    //startActivity(intent);
//                }
//
//            }
//        });