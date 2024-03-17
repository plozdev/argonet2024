package com.example.appdemo.poll;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdemo.R;
import com.example.appdemo.database.CustomCursorAdapter;
import com.example.appdemo.database.FarmDataContract;
import com.example.appdemo.database.FarmDataDbHelper;

import java.util.List;

public class PollActivity extends AppCompatActivity {

    FarmDataDbHelper dbHelper;
    private ListView listView;

    private static final String[] ALL_COLUMNS = {
            FarmDataContract.FarmEntry._ID,
            FarmDataContract.FarmEntry.COLUMN_NAME_N,
            FarmDataContract.FarmEntry.COLUMN_NAME_P,
            FarmDataContract.FarmEntry.COLUMN_NAME_K,
            FarmDataContract.FarmEntry.COLUMN_NAME_TEMP,
            FarmDataContract.FarmEntry.COLUMN_NAME_HUMID,
            FarmDataContract.FarmEntry.COLUMN_NAME_PH,
            FarmDataContract.FarmEntry.COLUMN_NAME_RAINFALL,
            FarmDataContract.FarmEntry.COLUMN_NAME_NHAN1,
            FarmDataContract.FarmEntry.COLUMN_NAME_AC1,
            FarmDataContract.FarmEntry.COLUMN_NAME_NHAN2,
            FarmDataContract.FarmEntry.COLUMN_NAME_AC2,
            FarmDataContract.FarmEntry.COLUMN_NAME_NHAN3,
            FarmDataContract.FarmEntry.COLUMN_NAME_AC3,
            FarmDataContract.FarmEntry.COLUMN_NAME_NHAN4,
            FarmDataContract.FarmEntry.COLUMN_NAME_AC4,
            FarmDataContract.FarmEntry.COLUMN_NAME_TIME
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poll);
        listView = findViewById(R.id.listView);
        dbHelper = new FarmDataDbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                FarmDataContract.FarmEntry.TABLE_NAME,
                ALL_COLUMNS,
                null,
                null,
                null,
                null,
                null
        );
        CustomCursorAdapter adapter = new CustomCursorAdapter(this,cursor);
        listView.setAdapter(adapter);
    }
}