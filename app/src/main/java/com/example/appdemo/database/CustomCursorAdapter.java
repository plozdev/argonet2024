package com.example.appdemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdemo.PollActivity;
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
        title = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        time = cursor.getString(cursor.getColumnIndexOrThrow("time"));
        n = cursor.getString(cursor.getColumnIndexOrThrow("N"));
        p = cursor.getString(cursor.getColumnIndexOrThrow("P"));
        k = cursor.getString(cursor.getColumnIndexOrThrow("K"));
        temp = cursor.getString(cursor.getColumnIndexOrThrow("temp"));
        humid = cursor.getString(cursor.getColumnIndexOrThrow("humid"));
        rain = cursor.getString(cursor.getColumnIndexOrThrow("rainfall"));
        ph = cursor.getString(cursor.getColumnIndexOrThrow("ph"));
        n1 = cursor.getString(cursor.getColumnIndexOrThrow("nhan1"));
        n2 = cursor.getString(cursor.getColumnIndexOrThrow("nhan2"));
        n3 = cursor.getString(cursor.getColumnIndexOrThrow("nhan3"));
        n4 = cursor.getString(cursor.getColumnIndexOrThrow("nhan4"));
        ac1 = cursor.getString(cursor.getColumnIndexOrThrow("ac1"));
        ac2 = cursor.getString(cursor.getColumnIndexOrThrow("ac2"));
        ac3 = cursor.getString(cursor.getColumnIndexOrThrow("ac3"));
        ac4 = cursor.getString(cursor.getColumnIndexOrThrow("ac4"));

        groupTitle.setText(title);
        timeTitle.setText(time);
        childItemN.setText("N: " + n);
        childItemP.setText("P: " + p);
        childItemK.setText("K: " + k);
        childItemTemp.setText("Nhiệt độ: " + temp + " °C");
        childItemHumid.setText("Độ ẩm: " + humid + " %");
        childItemRainfall.setText("Lượng mưa: " + rain + " mm");
        childItempH.setText("Độ pH: " + ph);
        nhan1tv.setText("Nhãn: " + n1 + " (" + ac1 + "%)");
        nhan2tv.setText("Nhãn: " + n2 + " (" + ac2 + "%)");
        nhan3tv.setText("Nhãn: " + n3 + " " + ac3 + "%)");
        nhan4tv.setText("Nhãn: " + n4 + " (" + ac4 + "%)");

        final long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(FarmDataContract.FarmEntry._ID));
        Button tickButton,cancelButton;
        tickButton = view.findViewById(R.id.tickButton);
        cancelButton = view.findViewById(R.id.cancelButton);
//        final String flag = cm
            tickButton.setOnClickListener(v -> {
                cancelButton.setVisibility(View.INVISIBLE);
//                ((PollActivity) context).updateDataTrue(itemId, "true");
                Toast.makeText(context, "Cảm ơn bạn đã đánh giá!", Toast.LENGTH_SHORT).show();
            });

            cancelButton.setOnClickListener(v -> {

                tickButton.setVisibility(View.INVISIBLE);
//                ((PollActivity) context).updateDataFalse(itemId, "false");
                Toast.makeText(context, "Cảm ơn bạn đã đánh giá!", Toast.LENGTH_SHORT).show();
            });
//        } else {
//            tickButton.setClickable(false);
//            cancelButton.setClickable(false);
//        }
    }
//    private void updateData(String data) {
//        SQLiteDatabase database;
//        FarmDataDbHelper dbHelper = new FarmDataDbHelper(this);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//    }
}
