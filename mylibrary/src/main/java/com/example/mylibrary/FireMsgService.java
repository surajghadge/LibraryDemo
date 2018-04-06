package com.example.mylibrary;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by sghadge on 05/04/18.
 */

public class FireMsgService extends FirebaseMessagingService {

    private static final String TAG ="FireMsgService" ;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("RemoteMessage",remoteMessage.getNotification().getBody());
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            //sendNotification(remoteMessage.getData().get("message");
        }
        else {
            Log.d(TAG, "No Data");
        }

    }

}
