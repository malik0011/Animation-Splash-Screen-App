package com.example.booking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class dbManager extends SQLiteOpenHelper {

    private static String dbName = "dbContact";

    public dbManager(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //here we will create the table
        String qry = "create table tbl_contact (id integer primary key autoincrement, name text, mail text,phoneNumber text,address text,pin text," +
                "inDate text,outDate,country text,other text,adults text,child text,room text)";
        sqLiteDatabase.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //if already exixits table drop that table
        String qry = "DROP TABLE IF EXISTS tbl_contact";
        sqLiteDatabase.execSQL(qry);

        //and create new one
        onCreate(sqLiteDatabase);
    }

    public String addRecord(String name, String mail, String phone, String address, String pin, String inDate, String outDate, String Country, String other,String adults,String child, String room) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("mail", mail);
        cv.put("phoneNumber", phone);
        cv.put("address", address);
        cv.put("pin", pin);
        cv.put("inDate", inDate);
        cv.put("outDate", outDate);
        cv.put("country", Country);
        cv.put("other", other);
        cv.put("adults", adults);
        cv.put("child", child);
        cv.put("room", room);
        float res = db.insert("tbl_contact", null, cv);

        if (res == -1) {
            return "Failed";
        } else{
            SQLiteDatabase sqLiteDatabase;
            String qry = "select IDENT_CURRENT('tbl_contact')";
           // sqLiteDatabase.execSQL(qry);
            return "Successfully Inserted!";
        }
    }

    public Cursor ShowAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from tbl_contact order by id desc";
        Cursor cursor = db.rawQuery(qry,null);
        return cursor;
    }
    public Boolean updateData(Integer id,String name, String mail, String phone, String address, String pin, String inDate, String outDate, String Country, String other,String adults,String child, String room){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("mail", mail);
        cv.put("phoneNumber", phone);
        cv.put("address", address);
        cv.put("pin", pin);
        cv.put("inDate", inDate);
        cv.put("outDate", outDate);
        cv.put("country", Country);
        cv.put("other", other);
        cv.put("adults", adults);
        cv.put("child", child);
        cv.put("room", room);

        Cursor cursor = db.rawQuery("Select * from tbl_contact where id = ?", new String[]{String.valueOf(id)});

        if(cursor.getCount() > 0){
            long result = db.update("tbl_contact",cv,"id=?",  new String[]{String.valueOf(id)});

            if(result==-1){
                return false;
            }else return true;
        }else return false;
    }

    public String getMaxId(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select max(id) from tbl_contact", null);
        if(cursor!=null){
            if(cursor.moveToFirst()) {
                return cursor.getString(0);
            }
            else
                return "Please submit some details!";
        }else{
            return "Please submit some details!";
        }
    }

}
