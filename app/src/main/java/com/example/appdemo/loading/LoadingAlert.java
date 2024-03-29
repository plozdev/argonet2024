package com.example.appdemo.loading;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.appdemo.R;

public class LoadingAlert {
    private Activity activity;
    private AlertDialog dialog;
    public LoadingAlert(Activity myActivity) {
        activity = myActivity;
    }

    public void startAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loading_dialog,null));

        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }

    public void closeAlertDialog() {
        dialog.dismiss();
    }
}
