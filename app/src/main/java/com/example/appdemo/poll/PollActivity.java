package com.example.appdemo.poll;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdemo.R;
import com.example.appdemo.database.FarmDataDbHelper;
import com.example.appdemo.database.Model;
import com.example.appdemo.database.ModelAdapter;

import java.util.List;

public class PollActivity extends AppCompatActivity {
    private ModelAdapter modelAdapter;
    FarmDataDbHelper db;
    private ListView listView;
    List<Model> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        listView = findViewById(R.id.listView);
        db = new FarmDataDbHelper(PollActivity.this);
        modelAdapter = new ModelAdapter();
        listView.setAdapter(modelAdapter);
    }
}