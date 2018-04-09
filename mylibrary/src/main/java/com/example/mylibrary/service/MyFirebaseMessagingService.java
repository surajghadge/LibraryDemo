package com.example.mylibrary.service;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.mylibrary.DemoConfig;
import com.example.mylibrary.activity.CoverActivity;
import com.example.mylibrary.activity.FooterActivity;
import com.example.mylibrary.activity.HalfInterstitalActivity;
import com.example.mylibrary.activity.HeaderActivity;
import com.example.mylibrary.activity.InterstitialActivity;
import com.example.mylibrary.mainClass;
import com.example.mylibrary.util.NotificationUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONObject;

/**
 * Created by sghadge on 05/04/18.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();

    private NotificationUtils notificationUtils;
    mainClass mClass;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(TAG, "From: " + remoteMessage.getFrom());
        mClass=new mainClass();

        if (remoteMessage == null)
            return;

        // Check if message contains a notification payload.
        /*if (remoteMessage.getNotification() != null) {
            Log.e(TAG, "Notification Body: " + remoteMessage.getNotification().getBody());
            handleNotification(remoteMessage.getNotification().getBody());
        }*/

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.e(TAG, "Data Payload: " + remoteMessage.getData().toString());

            try {
                JSONObject json = new JSONObject(remoteMessage.getData().toString());
                handleDataMessage(json);
            } catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
        }
    }

   /* private void handleNotification(String message) {
        if (!NotificationUtils.isAppIsInBackground(getApplicationContext())) {
            // app is in foreground, broadcast the push message
            Intent pushNotification = new Intent(DemoConfig.PUSH_NOTIFICATION);
            pushNotification.putExtra("message", message);
            LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);

            // play notification sound
            NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
            notificationUtils.playNotificationSound();
        }else{
            // If the app is in background, firebase itself handles the notification
            Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
        }
    }*/


    private void handleDataMessage(JSONObject json) {
        Log.e(TAG, "push json: " + json.toString());

        try {
            //JSONObject data = json.getJSONObject("data");

            String title = json.optString("title");
            String message = json.optString("message");
            /*String t1_tracking_id = json.optString("t1_tracking_id");
            String t1_content_type = json.optString("t1_content_type");
            String t1_popup_content = json.optString("t1_popup_content");*/


            Log.e(TAG, "title: " + title);
            Log.e(TAG, "message: " + message);
            /*Log.e(TAG, "t1_tracking_id: " + t1_tracking_id);
            Log.e(TAG, "t1_content_type: " + t1_content_type);
            Log.e(TAG, "t1_popup_content: " + t1_popup_content);*/



            if (!NotificationUtils.isAppIsInBackground(getApplicationContext())) {
                // app is in foreground, broadcast the push message
                Intent pushNotification = new Intent(DemoConfig.PUSH_NOTIFICATION);
                pushNotification.putExtra("message", message);
                LocalBroadcastManager.getInstance(this).sendBroadcast(pushNotification);

                /*Intent intent=new Intent(getApplicationContext(), FooterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);*/

                /*Intent intent=new Intent(getApplicationContext(), HeaderActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);*/

                /*Intent intent=new Intent(getApplicationContext(), InterstitialActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);*/

                Intent intent=new Intent(getApplicationContext(), HalfInterstitalActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                /*Intent intent=new Intent(getApplicationContext(), CoverActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);*/



                //viewDialog.showDialog();
                //mClass.displayView();
                //Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                // play notification sound
                //NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
                //notificationUtils.playNotificationSound();
            } else {
                Log.e("app_details",message);
                //Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
                // app is in background, show the notification in notification tray
                /*Intent resultIntent = new Intent(getApplicationContext(), MainActivity.class);
                resultIntent.putExtra("message", message);*/

                // check for image attachment
               /*if (TextUtils.isEmpty(imageUrl)) {
                    showNotificationMessage(getApplicationContext(), title, message, timestamp, resultIntent);
                } else {
                    // image is present, show notification with image
                    showNotificationMessageWithBigImage(getApplicationContext(), title, message, timestamp, resultIntent, imageUrl);
                }*/




            }
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
    }

    /**
     * Showing notification with text only
     */
    private void showNotificationMessage(Context context, String title, String message, String timeStamp, Intent intent) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //notificationUtils.showNotificationMessage(title, message, timeStamp, intent);
    }

    /**
     * Showing notification with text and image
     */
    private void showNotificationMessageWithBigImage(Context context, String title, String message, String timeStamp, Intent intent, String imageUrl) {
        notificationUtils = new NotificationUtils(context);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //notificationUtils.showNotificationMessage(title, message, timeStamp, intent, imageUrl);
    }
}
