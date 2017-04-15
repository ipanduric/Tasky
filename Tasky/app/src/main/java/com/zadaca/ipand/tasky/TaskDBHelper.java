package com.zadaca.ipand.tasky;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PrivateKey;
import java.util.ArrayList;

import javax.xml.validation.Schema;

/**
 * Created by ipand on 15.4.2017..
 */

public class TaskDBHelper extends SQLiteOpenHelper {

    private static TaskDBHelper mTaskDBHelper = null;

    protected TaskDBHelper(Context context) {
        super(context.getApplicationContext(), Schema.DATABASE_NAME, null, Schema.SCHEMA_VERSION);
    }



    public static synchronized TaskDBHelper getInstance(Context context) {
        if (mTaskDBHelper == null) {
            mTaskDBHelper = new TaskDBHelper(context);
        }
        return mTaskDBHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MY_TASK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_MY_TASK);
        this.onCreate(db);
    }

    static final String CREATE_TABLE_MY_TASK = "CREATE TABLE " + Schema.TABLE_MY_TASK +
            " (" + Schema.TITLE + " TEXT,"  + Schema.DESCRIPTION + " TEXT," + Schema.CATEGORY + " TEXT," + Schema.PRIORITY + " TEXT);";

    static final String DROP_TABLE_MY_TASK = "DROP TABLE IF EXISTS " + Schema.TABLE_MY_TASK;

    static final String SELECT_ALL_TASK = "SELECT " + Schema.TITLE + "," + Schema.DESCRIPTION + "," + Schema.CATEGORY + ","
            +
            Schema.PRIORITY + " FROM " + Schema.TABLE_MY_TASK;

    public void insertTask(Task task) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Schema.TITLE, task.getTitle());
        contentValues.put(Schema.DESCRIPTION, task.getDescription());
        contentValues.put(Schema.CATEGORY, task.getCategory());
        contentValues.put(Schema.PRIORITY, task.getPriority());
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        writeableDatabase.insert(Schema.TABLE_MY_TASK, Schema.CATEGORY, contentValues);
        writeableDatabase.close();
    }

    public ArrayList<Task> getAllTasks() {
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        Cursor taskCursor = writeableDatabase.rawQuery(SELECT_ALL_TASK, null);
        ArrayList<Task> task = new ArrayList<>();
        if (taskCursor.moveToFirst()) {
            do {
                String title = taskCursor.getString(0);
                String description = taskCursor.getString(1);
                String category = taskCursor.getString(2);
                String priority = taskCursor.getString(3);
                task.add(new Task(title, description, category, priority));
            } while (taskCursor.moveToNext());
        }
        taskCursor.close();
        writeableDatabase.close();
        return task;
    }

    public void deleteTask(Task task) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Schema.TABLE_MY_TASK, Schema.TITLE + "=?", new String[] {task.getTitle()});
        db.close();
    }

    public static class Schema{
        private static final int SCHEMA_VERSION = 1;
        private static final String DATABASE_NAME = "task.db";
        //A table to store owned books:
        static final String TABLE_MY_TASK = "my_task";
        static final String TITLE= "title";
        static final String DESCRIPTION= "description";
        static final String CATEGORY= "category";
        static final String PRIORITY= "priority";
    }

}
