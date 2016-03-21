package com.test.yinbing.testexam.database;

import android.content.Context;
import android.util.Log;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

/**
 * Created by yinbing on 16-3-21.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private final static String TAG = "DatabaseHelper";
    public static final String DB_NAME = "exam.db"; //数据库名称
    public static final int version = 1; //数据库版本
    private static DatabaseHelper dbHelper;

    private DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static DatabaseHelper getInstance(Context context) {
        synchronized (DatabaseHelper.class) {
            if (dbHelper == null) {
                dbHelper = new DatabaseHelper(context, DB_NAME, null, version);
            }
        }
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG,"创建table");
        String sql = "create table question(_id integer not null primary key autoincrement,que_id integer not null, question varchar(200) not null, opt1 varchar(80) not null, opt2 varchar(80) not null, opt3 varchar(80) not null, opt4 varchar(80) not null, answer varchar(320) not null);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d(TAG,"数据库升级:旧版本  " + i + ",新版本: " + i1);
    }
}
