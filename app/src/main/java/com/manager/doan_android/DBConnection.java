package com.manager.doan_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnection extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tienchi.db";

    private static final String TABLE_TIENCHI= "tienchi";

    private static final String KEY_ID = "_id";
    private static final String KEY_TEN = "ten";
    private static final String KEY_TIEN = "tien";
    private static final String KEY_NGAY="ngay";
    public DBConnection(@Nullable Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_SINHVIEN_TABLE = "CREATE TABLE " + TABLE_TIENCHI + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TEN + " TEXT,"
                + KEY_TIEN + " TEXT," + KEY_NGAY + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_SINHVIEN_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    void addTienChi(String strTen, String strTien, String strNgay) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TEN, strTen);
        values.put(KEY_TIEN, strTien);
        values.put(KEY_NGAY,strNgay);
        // Inserting Row
        db.insert(TABLE_TIENCHI, null, values);
        db.close(); // Closing database connection
    }

    public Cursor getAllInfo() {
        SQLiteDatabase mDb = this.getWritableDatabase();
        Cursor mCursor = mDb.query(TABLE_TIENCHI, new String[] {KEY_ID,
                        KEY_TEN, KEY_TIEN, KEY_NGAY},
                null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    public boolean updateData(String id,String strTen, String strTien, String strNgay){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,id);
        values.put(KEY_TEN, strTen);
        values.put(KEY_TIEN, strTien);
        values.put(KEY_NGAY,strNgay);
        db.update(TABLE_TIENCHI,values,"_id = ?",
                new String[] {id});
        return true;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_TIENCHI,"_id = ?",new String[]{id.toString()});
    }


}

