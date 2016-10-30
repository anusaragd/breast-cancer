package com.example.anusaratrokhum.myapplication.alert;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.anusaratrokhum.myapplication.HomeActivity;
import com.example.anusaratrokhum.myapplication.R;

public class AlertsetActivity extends AppCompatActivity {

    Button btnShowNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertset);

        btnShowNotification = (Button) findViewById(R.id.btn_show_notification);
        btnShowNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification();

            }
        });
    }
    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    private void showNotification() {
        Context context = AlertsetActivity.this;
        int color = ContextCompat.getColor(context, R.color.colorPrimary);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                R.mipmap.ic_alarm);

        final NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        final String KEY_TEXT_REPLY = "ACTION_REPLY";
        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel("REPLY")
                .build();

        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.mipmap.ic_account,"OK", getPendingIntent(context,"Hello World"))
                        .build();


        final NotificationCompat.Builder notification = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_alarm)
                .setLargeIcon(bitmap)
                .setContentTitle("สวัสดีผู้ใช้")
                .setContentText("ได้เวลาตรวจของคุณแล้ว.")
                .setAutoCancel(true)
                .setColor(color)
                .addAction(action);

        notificationManager.notify(1000, notification.build());
    }

    private PendingIntent getPendingIntent(Context context, String message) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.putExtra("MESSAGE", message);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(HomeActivity.class);
        stackBuilder.addNextIntent(intent);
        return stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private PendingIntent getPendingIntentURL() {
        String url = "http://benzneststudios.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        return PendingIntent.getActivity(AlertsetActivity.this, 0, intent, 0);
    }
}
