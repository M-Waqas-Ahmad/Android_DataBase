package pk.talmeez.muhaamad500.studentmanagementapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {

   private static DbHelper instance ;

   public List<StudenModule> studentData = new ArrayList<>();

    public static final String DB_NAME = "Student_Management_App_Database";
    public static final int DB_VERSION = 2;

    private DbHelper(@Nullable Context context) {

        super(context, DB_NAME, null, DB_VERSION);

        Log.d("DATABASE", "constructor");


    }

    public static DbHelper getInstance(Context context){
        if (instance == null){
            instance = new DbHelper(context.getApplicationContext());
            return instance;
        }else{
            return instance;
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DATABASE", "in on create");
        db.execSQL(StudenModule.CREATE_STUDENT_TABLE);
        db.execSQL(UserLogingModule.CREAT_USER_LOGIN_TABLE);
        Log.d("DATABASE", "table created success");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       if (oldVersion != newVersion){
            db.execSQL(StudenModule.DROP_STUDENT_TABLE);
            db.execSQL(UserLogingModule.DROP_USER_LOGIN_TABLE);

            onCreate(db);

        }
    }

    // insert data methods

    public boolean insertStudentData(StudenModule studenModule){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(StudenModule.STUDENT_ROLL_NUMBER_COL , studenModule.getStdRollNumber());
        contentValues.put(StudenModule.STUDENT_NAME_COL , studenModule.getStdName());
        contentValues.put(StudenModule.STUDENT_FATHER_NAME_COL , studenModule.getStdFatherName());
        contentValues.put(StudenModule.STUDENT_TOTAL_FEE_COL , studenModule.getStdTotalFee());

        long result = sqLiteDatabase.insert(StudenModule.TABLE_NAME ,null , contentValues);

        if (result != -1) {
            return true;
        }else {
            return false;
        }
    }

    public boolean insertUserLoginData(UserLogingModule userLogingModule){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserLogingModule.USER_EMAIL_COL , userLogingModule.getEmail());
        contentValues.put(UserLogingModule.USER_FIRST_NAME_COL , userLogingModule.getFirstName());
        contentValues.put(UserLogingModule.USER_SECOND_NAME_COL , userLogingModule.getSecondName());
        contentValues.put(UserLogingModule.USER_NAME , userLogingModule.getUserName());
        contentValues.put(UserLogingModule.USER_PASSWORD , userLogingModule.getPassword());
        long result  = db.insert(UserLogingModule.USER_TABLE_NAME ,null ,contentValues);
        if (result != -1){
            return true;
        }else {
            return false;
        }
    }
    public boolean loginValidation(String user , String pass){
        SQLiteDatabase db = getReadableDatabase();
        Log.d("DATABASE" , "in login validation");
        Cursor cursor = db.rawQuery("SELECT * FROM "+UserLogingModule.USER_TABLE_NAME+" WHERE "+UserLogingModule.USER_NAME+" = ? AND "+UserLogingModule.USER_PASSWORD+" = ?",
                                         new String[] {user , pass});
        Log.d("DATABASE" , "in login validation process completed");
        if (cursor.getCount() > 0){
            Log.d("DATABASE" , "in login validation return true");
            return true;

        }else{
            Log.d("DATABASE" , "in login validation return false");
            return false;
        }
    }

    public  boolean studentRollNumberValidator(String rno){
        Log.d("Db helper class" , "inside rno validator ");
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + StudenModule.TABLE_NAME + " WHERE "+StudenModule.STUDENT_ROLL_NUMBER_COL + "=? " ,new String[]{rno});
        Log.d("Db helper class" , "inside rno validator rno validate and ready to return result ");
        if (cursor.getCount() > 0){
            return false ;
        }else{
            return true;
        }
    }

    public List<StudenModule> getAllStudents(){
        Log.d("DB HELPER" , "in get all students");
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(StudenModule.SELECT_ALL_FROM_STUDENT_TABLE , null);
        Log.d("DB HELPER" , "in get all students execute all fetch query");

        if (cursor.moveToFirst()){
            do{
                Log.d("DB HELPER" , "in get all students getting data in loop and save in list");
                StudenModule studenModule = new StudenModule();
                studenModule.setStdRollNumber(cursor.getString(cursor.getColumnIndex(StudenModule.STUDENT_ROLL_NUMBER_COL)));
                studenModule.setStdName(cursor.getString(cursor.getColumnIndex(StudenModule.STUDENT_NAME_COL)));
                studenModule.setStdFatherName(cursor.getString(cursor.getColumnIndex(StudenModule.STUDENT_FATHER_NAME_COL)));
                studenModule.setStdTotalFee(cursor.getFloat(cursor.getColumnIndex(StudenModule.STUDENT_TOTAL_FEE_COL)));
                studentData.add(studenModule);
                Log.d("DB HELPER" , "in get all students data saved in list");
            }while (cursor.moveToNext());
        }
        Log.d("DB HELPER" , "in get all students returning list");
        return studentData;
    }
}
