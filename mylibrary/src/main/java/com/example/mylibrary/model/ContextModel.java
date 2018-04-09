package com.example.mylibrary.model;

import android.app.Activity;
import android.content.Context;

public class ContextModel {

    private Activity activity;
    private Context context;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
