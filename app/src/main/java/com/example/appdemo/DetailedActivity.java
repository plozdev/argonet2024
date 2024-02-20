package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appdemo.databinding.ActivityDetailedBinding;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

/*
        Intent i = this.getIntent();
            String name = i.getStringExtra("name");
            String percent = i.getStringExtra("percent");
            String seasonal = i.getStringExtra("seasonal");
            String daytime = i.getStringExtra("daytime");
            String type = i.getStringExtra("type");
            int image = i.getIntExtra("image",R.drawable.tao);*/

    }
}