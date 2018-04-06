package com.example.mylibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mylibrary.activity.DialogActivity;
import com.example.mylibrary.util.NotificationUtils;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by sghadge on 05/04/18.
 */

public class mainClass{

    private String TAG="mainClass_";
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private static Context context;

    public mainClass(){

    }

    public mainClass(Context context)
    {
        this.context=context;

        Toast.makeText(context,"Hi",Toast.LENGTH_SHORT).show();
        Log.d("DEVICE_OS", android.os.Build.VERSION.RELEASE);
        RegistrationBroadcastReceiver();
    }


    public void RegistrationBroadcastReceiver(){
        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // checking for type intent filter
                if (intent.getAction().equals(DemoConfig.REGISTRATION_COMPLETE)) {

                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(DemoConfig.TOPIC_GLOBAL);
                    //Toast.makeText(context.getApplicationContext(),"onReceive if",Toast.LENGTH_SHORT).show();
                    displayFirebaseRegId();

                } else if (intent.getAction().equals(DemoConfig.PUSH_NOTIFICATION)) {

                    // new push notification is received
                    String message = intent.getStringExtra("message");
                    Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    //Toast.makeText(context.getApplicationContext(),"onReceive else",Toast.LENGTH_SHORT).show();
                }
            }
        };

        displayFirebaseRegId();
    }

    private void displayFirebaseRegId() {
        SharedPreferences pref = context.getApplicationContext().getSharedPreferences(DemoConfig.SHARED_PREF, 0);
        String regId = pref.getString("regId", null);

        Log.e(TAG, "Firebase reg id: " + regId);
    }


    public void Resume() {
        Toast.makeText(context.getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();
        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(context.getApplicationContext()).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(DemoConfig.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(context.getApplicationContext()).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(DemoConfig.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(context.getApplicationContext());
    }

    public void Pause(){

        Toast.makeText(context.getApplicationContext(),"onPause",Toast.LENGTH_SHORT).show();
        LocalBroadcastManager.getInstance(context.getApplicationContext()).unregisterReceiver(mRegistrationBroadcastReceiver);
    }

    public void displayView(){
        Toast.makeText(context.getApplicationContext(),"displayView",Toast.LENGTH_SHORT).show();
        /*Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {

            @Override
            public void run() {
                context.startActivity(new Intent(context, DialogActivity.class));
            }
        });*/
    }

}
