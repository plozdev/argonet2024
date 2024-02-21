package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class DetailedActivity extends AppCompatActivity {
    private int IMG;
    private String TEN;
    private String PHANTRAM;
    private String PHOBIEN,PHOBIENTRUE,PHOBIENFALSE;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        Intent i = getIntent();

    }
}