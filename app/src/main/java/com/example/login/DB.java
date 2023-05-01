package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {

    public static final String DB="kayıt.db";

    public DB(@Nullable Context context) {
        super(context, "kayıt.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {
        Mydb.execSQL("create Table uyeler(email TEXT primary key,password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {

        Mydb.execSQL("drop table if exists uyeler");

    }

    public Boolean insertData(String email, String password){

    SQLiteDatabase Mydb = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("email",email);
    contentValues.put("password",password);
    long result = Mydb.insert("uyeler",null,contentValues);
    if(result == -1 ){

        return  false;

    }else{
        return true;
    }


    }
    public Boolean kontrolEmail(String email){
    SQLiteDatabase Mydb= this.getWritableDatabase();
    Cursor cursor = Mydb.rawQuery("Select * from uyeler where email =?",new String[]{email});

        if(cursor.getCount()>0){
            return true;
        }else {

            return false ;
        }
    }

    public Boolean kontrolsifreemail( String email, String password ){
        SQLiteDatabase Mydb= this.getWritableDatabase();
        Cursor cursor = Mydb.rawQuery("Select * from uyeler where email = ? and password = ? ",new String[]{email,password});

        if(cursor.getCount()>0){
            return true;
        }else {

            return false ;
        }
    }
}
