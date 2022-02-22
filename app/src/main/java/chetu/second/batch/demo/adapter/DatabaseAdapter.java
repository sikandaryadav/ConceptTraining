package chetu.second.batch.demo.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseAdapter {
    private final String DB_NAME = "chetu";
    private final String TABLE_NAME = "Students";
    private final int DB_VERSION = 1;

    // TABLE Cloumns name
    private final String ROW_ID = "rowId";
    private final String FIRST_NAME = "firstName";
    private final String LAST_NAME = "lastName";
    private final String IMAGE = "image";

    // CREATE TABLE STUDENTS (rowId Integer AUTOINCREAMENT PRIMARY KEY, firstName text, lastName text, image text);
    private String sqlQuery = "CREATE TABLE "+TABLE_NAME+" ("+ROW_ID+" "+"INTEGER PRIMARY KEY AUTOINCREMENT"+", "+FIRST_NAME+" text"+", "+LAST_NAME+" text"+", "+IMAGE+" text"+")";
    MyDbHelper myDbHelper;
    SQLiteDatabase sqLiteDatabase;

    public DatabaseAdapter(Context context){
       myDbHelper = new MyDbHelper(context);
    }

    public DatabaseAdapter openDatabase(){
        sqLiteDatabase = myDbHelper.getWritableDatabase();
        return this;
    }

    class MyDbHelper extends SQLiteOpenHelper{

        public MyDbHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(sqlQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


}
