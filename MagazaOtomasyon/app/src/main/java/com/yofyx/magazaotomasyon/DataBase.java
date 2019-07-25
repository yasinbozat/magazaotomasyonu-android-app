package com.yofyx.magazaotomasyon;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBase extends SQLiteOpenHelper {

    //DATABASE INFORMATION -------------------------------------------------------------------------
    private static final String DATABASE_NAME = "Magaza";
    private static final int DATABASE_VERSION = 1;
    //----------------------------------------------------------------------------------------------

    //TABLE_URUNLER INFORMATION --------------------------------------------------------------------
    private static final String TABLE_URUNLER = "urunler";
    private static final String ROW_ID = "urunNo";
    private static final String ROW_URUNADI = "urunAdi";
    private static final String ROW_URUNTURU = "urunTuru";
    private static final String ROW_BEDEN = "beden";
    private static final String ROW_RENK = "renk";
    //----------------------------------------------------------------------------------------------

    public DataBase(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+ TABLE_URUNLER + "("
                + ROW_ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ROW_URUNADI + "TEXT NOT NULL,"
                + ROW_URUNTURU + "TEXT NOT NULL,"
                + ROW_BEDEN + "TEXT NOT NULL,"
                + ROW_RENK + "TEXT NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_URUNLER);
        onCreate(db);
    }

    public void InsertData(String urunAdi, String urunTuru, String beden, String renk){
        SQLiteDatabase db = this.getWritableDatabase();
        try {

            ContentValues cv = new ContentValues();

            cv.put(ROW_URUNADI, urunAdi);
            cv.put(ROW_URUNTURU, urunTuru);
            cv.put(ROW_BEDEN, beden);
            cv.put(ROW_RENK, renk);

            db.insert(TABLE_URUNLER, null,cv);
        }catch (Exception e){
            Log.d("DEBUG","Veritabanı oluşturma hatası!");
        }
        db.close();
    }


}