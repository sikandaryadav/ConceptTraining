package chetu.second.batch.demo.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import chetu.second.batch.demo.utilities.Utility;

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

    public void insertData(Context context, String firstName, String lastName, String image){
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, firstName);
        contentValues.put(LAST_NAME, lastName);
        contentValues.put(IMAGE, image);
        long insertedRow = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (insertedRow > 0){
            Utility.showLongToast(context, insertedRow+" data is successfully inserted");
        }else {
            Utility.showLongToast(context, "Something went wrong");
        }
    }

    public Cursor getAllData(){
        String[] colList = new String[]{ROW_ID, FIRST_NAME, LAST_NAME, IMAGE};
        return sqLiteDatabase.query(TABLE_NAME, colList, null, null, null, null, null);
    }

    public void deleteSingleRecord(Context context, String rowId){
        // DELETE * FROM STUDENT Where RowDI = 101;
        int deletedItems = sqLiteDatabase.delete(TABLE_NAME, ROW_ID+" = "+rowId, null);
        if (deletedItems > 0 ){
            Utility.showLongToast(context, deletedItems+" Record deleted");
        }else {
            Utility.showLongToast(context, "Something went wrong.");
        }
    }

    public void updateRecord(Context context, String firstName, String lastName, String image, String rowId){
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, firstName);
        contentValues.put(LAST_NAME, lastName);
        contentValues.put(IMAGE, image);
        int updatedRow = sqLiteDatabase.update(TABLE_NAME, contentValues, ROW_ID+" = "+rowId, null);
        if (updatedRow > 0){
            Utility.showLongToast(context, updatedRow+" data is successfully updated");
        }else {
            Utility.showLongToast(context, "Something went wrong");
        }
    }

    public void deleteAllRecords(Context context){
        int deletedItems = sqLiteDatabase.delete(TABLE_NAME, null, null);
        if (deletedItems > 0 ){
            Utility.showLongToast(context, deletedItems+" Record deleted");
        }else {
            Utility.showLongToast(context, "Something went wrong.");
        }
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
