package com.example.appdemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class FarmDataDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FarmData.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FarmDataContract.FarmEntry.TABLE_NAME + " (" +
                    FarmDataContract.FarmEntry._ID + " INTEGER PRIMARY KEY," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_N + " REAL," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_P + " REAL," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_K + " REAL," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_TEMP + " REAL," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_HUMID + " REAL," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_PH + " REAL," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_RAINFALL + " REAL," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_NHAN1 + " TEXT," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_AC1 + " TEXT," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_NHAN2 + " TEXT," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_AC2 + " TEXT," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_NHAN3 + " TEXT," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_AC3 + " TEXT," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_NHAN4 + " TEXT," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_AC4 + " TEXT," +
                    FarmDataContract.FarmEntry.COLUMN_NAME_TIME + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FarmDataContract.FarmEntry.TABLE_NAME;

    public FarmDataDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

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



    // Thêm một hàm để thêm dữ liệu mới vào cơ sở dữ liệu
    public long addData(String N, String P, String K, String temp, String humid, String ph,
                        String rainfall, String nhan1, String ac1, String nhan2, String ac2,
                        String nhan3, String ac3, String nhan4, String ac4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_N, N);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_P, P);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_K, K);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_TEMP, temp);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_HUMID, humid);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_PH, ph);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_RAINFALL, rainfall);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN1, nhan1);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC1, ac1);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN2, nhan2);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC2, ac2);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN3, nhan3);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC3, ac3);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN4, nhan4);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC4, ac4);

//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_N, model.getNito());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_P, model.getPhotpho());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_K, model.getKali());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_TEMP, model.getTemp());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_HUMID, model.getHumid());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_PH, model.getPh());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_RAINFALL, model.getRainfall());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN1, model.getNhan1());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC1, model.getAcc1());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN2, model.getNhan2());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC2,  model.getAcc2());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN3, model.getNhan3());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC3, model.getAcc3());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN4, model.getNhan4());
//        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC4, model.getAcc4());

        // Lấy ngày giờ hiện tại
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd-MM-yyyy", Locale.getDefault());
        String dateTimeNow = dateFormat.format(calendar.getTime());

        // Thêm thông tin thời gian vào cơ sở dữ liệu
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_TIME, dateTimeNow);

        long newRowId = db.insert(FarmDataContract.FarmEntry.TABLE_NAME, null, values);
        db.close();
        return newRowId;
    }



    // Thêm một hàm để đọc dữ liệu từ cơ sở dữ liệu
    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                FarmDataContract.FarmEntry.TABLE_NAME, // Bảng
                ALL_COLUMNS, // Các cột trả về
                null, // Câu lệnh WHERE
                null, // Đối số cho câu lệnh WHERE
                null, // GROUP BY
                null, // HAVING
                null // ORDER BY
        );
        return cursor;
    }

    // Thêm một hàm để cập nhật dữ liệu trong cơ sở dữ liệu
    public int updateData(long id, String N, String P, String K, String temp, String humid, String ph,
                          String rainfall, String nhan1, String ac1, String nhan2, String ac2,
                          String nhan3, String ac3, String nhan4, String ac4, String time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_N, N);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_P, P);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_K, K);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_TEMP, temp);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_HUMID, humid);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_PH, ph);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_RAINFALL, rainfall);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN1, nhan1);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC1, ac1);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN2, nhan2);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC2, ac2);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN3, nhan3);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC3, ac3);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_NHAN4, nhan4);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_AC4, ac4);
        values.put(FarmDataContract.FarmEntry.COLUMN_NAME_TIME,time);
        int count = db.update(
                FarmDataContract.FarmEntry.TABLE_NAME,
                values,
                FarmDataContract.FarmEntry._ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return count;
    }

    // Thêm một hàm để xóa dữ liệu từ cơ sở dữ liệu
    public void deleteData(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(FarmDataContract.FarmEntry.TABLE_NAME,
                FarmDataContract.FarmEntry._ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

}
