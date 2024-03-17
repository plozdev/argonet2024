package com.example.appdemo.database;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.appdemo.R;

public class CustomCursorAdapter extends CursorAdapter {

    public CustomCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView groupTitle, timeTitle, childItemN, childItemP, childItemK, childItemTemp, childItemHumid,childItemRainfall, childItempH, nhan1tv,nhan2tv,nhan3tv,nhan4tv;
        groupTitle = view.findViewById(R.id.groupTitle);
        timeTitle = view.findViewById(R.id.timeTitle);
        childItemN = view.findViewById(R.id.childItemN);
        childItemP = view.findViewById(R.id.childItemP);
        childItemK = view.findViewById(R.id.childItemK);
        childItemTemp = view.findViewById(R.id.childItemTemp);
        childItemHumid = view.findViewById(R.id.childItemHumid);
        childItemRainfall = view.findViewById(R.id.childItemRainfall);
        childItempH = view.findViewById(R.id.childItempH);
        nhan1tv = view.findViewById(R.id.nhan1tv);
        nhan2tv = view.findViewById(R.id.nhan2tv);
        nhan3tv = view.findViewById(R.id.nhan3tv);
        nhan4tv = view.findViewById(R.id.nhan4tv);

        String title,time,n,p,k,temp,humid,rain,ph,n1,n2,n3,n4,ac1,ac2,ac3,ac4;

        // Đọc dữ liệu từ Cursor và đặt nội dung vào TextView
        title = cursor.getString(cursor.getColumnIndexOrThrow("_ID"));
        time = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_TIME"));
        n = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_N"));
        p = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_P"));
        k = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_K"));
        temp = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_TEMP"));
        humid = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_HUMID"));
        rain = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_PH"));
        ph = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_RAINFALL"));
        n1 = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_NHAN1"));
        n2 = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_NHAN2"));
        n3 = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_NHAN3"));
        n4 = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_NHAN4"));
        ac1 = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_AC1"));
        ac2 = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_AC2"));
        ac3 = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_AC3"));
        ac4 = cursor.getString(cursor.getColumnIndexOrThrow("COLUMN_NAME_AC4"));

        groupTitle.setText(title);
        timeTitle.setText(time);
        childItemN.setText(n);
        childItemP.setText(p);
        childItemK.setText(k);
        childItemTemp.setText(temp + " °C");
        childItemHumid.setText(humid + " %");
        childItemRainfall.setText(rain + " mm");
        childItempH.setText(ph);
        nhan1tv.setText("Nhãn: " + n1 + "(" + ac1 + "%)");
        nhan2tv.setText("Nhãn: " + n2 + "(" + ac2 + "%)");
        nhan3tv.setText("Nhãn: " + n3 + "(" + ac3 + "%)");
        nhan4tv.setText("Nhãn: " + n4 + "(" + ac4 + "%)");
    }
}
