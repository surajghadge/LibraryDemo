package com.example.mylibrary;

/**
 * Created by sghadge on 05/04/18.
 */

public class DemoConfig {

    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static final String SHARED_PREF = "ah_firebase";

}

/*

{
	"to":"eCFPKqhqHBc:APA91bGZbbt38zlTmvahxF26aZdtksXPsbbBxfjL8bjdNaJ1nxjHlzha05atxib4QG5w0rp1ONzkLHsUbIvmUi6Zivns1uGOxCtFD5KHscsfeg-4_QlPz_8vh2HvfhGFLSvmTWZLP-bq",
	"data":{
		"title":"okk",
		"message":"ok",
		"image_url":"",
    	"icon_url":"",
    	"key1":"",
    	"key2":"",
    	"key3":"",
    	"key4":"",
    	"key5":"",
    	"t1_tracking_id":"",
		"t1_content_type":"",
		"t1_popup_content":""
	}
}

 */
