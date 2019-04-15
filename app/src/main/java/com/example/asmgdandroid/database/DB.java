package com.example.asmgdandroid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB {


    final private String DB_NAME="BILL"; //Tên database
    final private String TB="xxx";   //Bảng
    final int DB_VERSION=1;       //Phiên bản

    private SQLiteDatabase database;


    public  DB(Context context){
        DatabaseOpenHepler openHepler=new DatabaseOpenHepler(context);
        database=openHepler.getWritableDatabase();
    }


    public class DatabaseOpenHepler extends SQLiteOpenHelper{

        public DatabaseOpenHepler(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            //Lệnh tạo bảng
            String lenhtaobang = "CREATE TABLE IF NOT EXISTS xxx(_id INTEGER PRIMARY KEY AUTOINCREMENT,khoanthu NVARCHAR)";

            db.execSQL(lenhtaobang);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+TB);
        }


    }

    //Hàm insert vào database
    public long insert(String kt)
    {
        ContentValues values=new ContentValues();
        //khoan thu phai trung voi khoan thu o len tao bang bên trên
        values.put("khoanthu",kt);
       long a= database.insert(TB,null,values);
        return a;
    }

    //Hàm delete 1 phần tử trong database
    public void delete(int id){
        database.delete(TB,"_id="+id,null);
    }
    //Hàm update trong database
    public void update(int id,String kt){
        ContentValues values=new ContentValues();
        //khoan thu phai trung voi khoan thu o len tao bang bên trên
        values.put("khoanthu",kt);
        database.update(TB,values,"_id="+id,null);
    }

    //Hàm lấy dữ liệu trong database
    public Cursor getData(){
        return database.query(TB,null,null,null,null,null,null);
    }
}
