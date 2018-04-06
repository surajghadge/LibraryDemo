package com.example.sghadge.librarydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mylibrary.mainClass;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    mainClass mClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClass=new mainClass(getApplicationContext());
        //mainClass.RegistrationBroadcastReceiver(getApplicationContext());
        /*mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                // checking for type intent filter
                if (intent.getAction().equals(DemoConfig.REGISTRATION_COMPLETE)) {
                    // gcm successfully registered
                    // now subscribe to `global` topic to receive app wide notifications
                    FirebaseMessaging.getInstance().subscribeToTopic(DemoConfig.TOPIC_GLOBAL);
                    Toast.makeText(getApplication(),"onReceive if",Toast.LENGTH_SHORT).show();
                    displayFirebaseRegId();

                } else if (intent.getAction().equals(DemoConfig.PUSH_NOTIFICATION)) {
                    // new push notification is received

                    String message = intent.getStringExtra("message");

                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplication(),"onReceive else",Toast.LENGTH_SHORT).show();
                    txtMessage.setText(message);
                }
            }
        };

        displayFirebaseRegId();*/
    }

   /* // Fetches reg id from shared preferences
    // and displays on the screen
    private void displayFirebaseRegId() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences(DemoConfig.SHARED_PREF, 0);
        String regId = pref.getString("regId", null);

        Log.e(TAG, "Firebase reg id: " + regId);

        if (!TextUtils.isEmpty(regId))
            txtRegId.setText("Firebase Reg Id: " + regId);
        else
            txtRegId.setText("Firebase Reg Id is not received yet!");
    }*/

    /*@Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplication(),"onResume",Toast.LENGTH_SHORT).show();
        // register GCM registration complete receiver
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(DemoConfig.REGISTRATION_COMPLETE));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                new IntentFilter(DemoConfig.PUSH_NOTIFICATION));

        // clear the notification area when the app is opened
        NotificationUtils.clearNotifications(getApplicationContext());
    }

    @Override
    protected void onPause() {
        Toast.makeText(getApplication(),"onPause",Toast.LENGTH_SHORT).show();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        super.onPause();
    }*/

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }*/

    /*public void click(View view){
        mainClass mainClassobject = new mainClass(this);
        //mainClassobject.getFirebaseToken(this);
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        mClass.Resume();
    }

    @Override
    protected void onPause() {
        mClass.Pause();
        super.onPause();

    }
}
