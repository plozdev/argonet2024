package com.example.appdemo.database;
import android.provider.BaseColumns;

public final class FarmDataContract {
    // Private constructor to prevent instantiation
    private FarmDataContract() {}

    /* Inner class that defines the table contents */
    public static class FarmEntry implements BaseColumns {
        public static final String TABLE_NAME = "farm";
        public static final String COLUMN_NAME_N = "N";
        public static final String COLUMN_NAME_P = "P";
        public static final String COLUMN_NAME_K = "K";
        public static final String COLUMN_NAME_TEMP = "temp";
        public static final String COLUMN_NAME_HUMID = "humid";
        public static final String COLUMN_NAME_PH = "ph";
        public static final String COLUMN_NAME_RAINFALL = "rainfall";
        public static final String COLUMN_NAME_NHAN1 = "nhan1";
        public static final String COLUMN_NAME_AC1 = "ac1";
        public static final String COLUMN_NAME_NHAN2 = "nhan2";
        public static final String COLUMN_NAME_AC2 = "ac2";
        public static final String COLUMN_NAME_NHAN3 = "nhan3";
        public static final String COLUMN_NAME_AC3 = "ac3";
        public static final String COLUMN_NAME_NHAN4 = "nhan4";
        public static final String COLUMN_NAME_AC4 = "ac4";
        public static final String COLUMN_NAME_TIME = "time";

    }
}
