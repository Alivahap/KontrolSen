package com.example.programatik;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    static final int data_version=1;
    static final String Data_name="VeriTabanıİsmi";
    static final String Table_puanlama="PuanlamaTablosu";
    static final String id="id";
    static final String []coloums={"id","Activite"};
    static final String Create_Table="CREATE TABLE "+Table_puanlama+"(id INTEGER PRIMARY KEY AUTOINCREMENT,Activite TEXT)";



    public Database( Context context) {
        super(context, Data_name, null, data_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXİSTS " + Table_puanlama);
    }
    public void PuanEkle(puan puan){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues deger =new ContentValues();
        deger.put("Activite",puan.getPuan());

        db.insert(Table_puanlama,null,deger);
        db.close();
    }

    public void PuanOku(puan puan){


        String query="SELECT * FROM "+Table_puanlama;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);

        try {


                puan.setId(cursor.getInt(0));
                puan.setPuan(cursor.getString(1));






        }finally {
            cursor.close();
            db.close();

        }

    }
    public puan  oku(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor =db.query(Table_puanlama,coloums," id = ?",new String[]{String.valueOf(id)},null,null,null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        puan puan= new puan();
        puan.setId(cursor.getInt(0));
        puan.setPuan(cursor.getString(1));


        return puan;
    }
















}
