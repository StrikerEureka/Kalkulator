package com.example.kalkulator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

public class DBhelper extends SQLiteOpenHelper {
        public static final String DATABASE_NAME = "kalkulator";
        public static final String TABLE_NAME = "history";
        public static final String COL_1 = "angka1";
        public static final String COL_2 = "angka2";
        public static final String COL_3 = "hasil";
        public static final String COL_4 = "op";
        public static final int DATABASE_VERTION = 1;

        public DBhelper (Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERTION);
            SQLiteDatabase db = this.getWritableDatabase();
        }
        @Override
        public void onCreate (SQLiteDatabase db) {
            db.execSQL("create table history(angka1 string null, angka2 string null, hasil string null, op string null);");
        }
        @Override
        public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
            onCreate(db);
        }

        // Metode untuk tambah data
        public boolean insertData(String angka1 , String angka2, String hasil, String op) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_1, angka1);
            contentValues.put(COL_2, angka2);
            contentValues.put(COL_3, hasil);
            contentValues.put(COL_4, op);
            long result = db.insert(TABLE_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }

        // Metode untuk mengambil data
        public Cursor getAllData() {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from history", null);
            return res;
        }

        // Metode untuk hapus data
        public int deleteData (String hasil) {
            SQLiteDatabase db = this.getWritableDatabase();
            return db.delete(TABLE_NAME, "hasil = ?", new String[]{hasil});
        }
}