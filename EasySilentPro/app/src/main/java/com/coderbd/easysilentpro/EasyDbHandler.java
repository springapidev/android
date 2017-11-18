package com.coderbd.easysilentpro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajail Islam on 11/1/2017.
 */

public class EasyDbHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "easysilentt";
    private static final String TABLE_EASYSILENT = "easysilent";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_STARTINGTIME = "starting_time";
    private static final String KEY_ENDINGTIME = "ending_time";
    private static final String KEY_STATUS = "status";

    public EasyDbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_EASY_SILENT_TABLE = "CREATE TABLE " + TABLE_EASYSILENT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"  + KEY_NAME + " TEXT,"
                + KEY_STARTINGTIME + " TEXT,"
                + KEY_ENDINGTIME + " TEXT," + KEY_STATUS + " TEXT" + ")";
        db.execSQL(CREATE_EASY_SILENT_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EASYSILENT);

        // Create tables again
        onCreate(db);
    }

    // code to add the new EasySchedule
    void addEasySchedule(EasySchedule easySchedule) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, easySchedule.getName()); // name
        values.put(KEY_STARTINGTIME, easySchedule.getStartingTime()); // starting time
        values.put(KEY_ENDINGTIME, easySchedule.getEndingTime()); // ending time
        values.put(KEY_STATUS, easySchedule.getStatus()); // status
        // Inserting Row
        db.insert(TABLE_EASYSILENT, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single EasySchedule
    EasySchedule getEasySchedule(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EASYSILENT, new String[]{KEY_ID,KEY_NAME,
                        KEY_STARTINGTIME, KEY_ENDINGTIME, KEY_STATUS}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        EasySchedule easySchedule = new EasySchedule(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4));
        // return easySchedule
        return easySchedule;
    }

    // code to get all EasySchedules in a list view
    public List<EasySchedule> getAllEasySchedule() {
        List<EasySchedule> echeduleList = new ArrayList<EasySchedule>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EASYSILENT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                EasySchedule echedule = new EasySchedule();
                echedule.setId(Integer.parseInt(cursor.getString(0)));
                echedule.setName(cursor.getString(1));
                echedule.setStartingTime(cursor.getString(2));
                echedule.setEndingTime(cursor.getString(3));
                echedule.setStatus(cursor.getString(4));
                // Adding echedule to list
                echeduleList.add(echedule);
            } while (cursor.moveToNext());
        }

        // return echedule list
        return echeduleList;
    }

    // code to update the single EasySchedule
    public int updateEasySchedule(EasySchedule easySchedule) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, easySchedule.getName());
        values.put(KEY_STARTINGTIME, easySchedule.getStartingTime());
        values.put(KEY_ENDINGTIME, easySchedule.getEndingTime());
        values.put(KEY_STATUS, easySchedule.getStatus());
        // updating row
        return db.update(TABLE_EASYSILENT, values, KEY_ID + " = ?",
                new String[]{String.valueOf(easySchedule.getId())});
    }

    // Deleting single EasySchedule
    public void deleteEasySchedule(EasySchedule easySchedule) {
        SQLiteDatabase db = this.getWritableDatabase();
       // db.delete(TABLE_EASYSILENT, KEY_ID + " = ?",
        //        new String[]{String.valueOf(easySchedule.getId())});
        //Execute sql query to remove from database
        //NOTE: When removing by String in SQL, value must be enclosed with ''
        db.execSQL("DELETE FROM " + TABLE_EASYSILENT + " WHERE " + KEY_ID + "= '" + easySchedule.getId() + "'");
        db.close();
    }

    // Getting EasySchedules Count
    public int getEasySchedule() {
        String countQuery = "SELECT  * FROM " + TABLE_EASYSILENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}

