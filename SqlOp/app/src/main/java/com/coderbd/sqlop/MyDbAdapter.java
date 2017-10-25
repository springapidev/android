package com.coderbd.sqlop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbAdapter {

    MyDbHelper helper;

    public MyDbAdapter(Context context)
    {
        helper = new MyDbHelper(context);
    }


   static class MyDbHelper extends SQLiteOpenHelper
   {

      // Table Name
      public static final String TABLE_NAME = "TODOS";

       // Table columns
       public static final String _ID = "_id";
       private static final String NAME = "name";
       private static final String PASSWORD= "password";
       // Database Information
       static final String DB_NAME = "JAVATECHIG_TODOS.DB";

       // database version
       static final int DB_VERSION = 1;

       // Creating table query
       private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
               + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL, " + PASSWORD + " TEXT);";

       public MyDbHelper(Context context) {
           super(context, DB_NAME, null, DB_VERSION);
       }

       @Override
       public void onCreate(SQLiteDatabase db) {
           db.execSQL(CREATE_TABLE);
       }

       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
          onCreate(db);
       }
   }
    public long insertData(String name, String password)
    {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.NAME, name);
        contentValues.put(MyDbHelper.PASSWORD, password);
        long id = db.insert(MyDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }
}
