package com.mizardar.shaaditest.base;

import android.content.Context;

public class BaseDatabaseHelper {

    public AppDatabase appDatabase;

    public BaseDatabaseHelper(Context context) {
        appDatabase = AppDatabase.getInstance(context);
    }
}
