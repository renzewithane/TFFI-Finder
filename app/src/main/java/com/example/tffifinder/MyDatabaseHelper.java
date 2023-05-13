package com.example.tffifinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "koinuDatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Pet";
    private static final String COLUMN_ID = "petID";
    private static final String COLUMN_PETNAME = "petName";
    private static final String COLUMN_BREED = "breed";
    private static final String COLUMN_SEX = "sex";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_WEIGHT = "weight";
    private static final String COLUMN_ALLERGIES = "allergies";
    private static final String COLUMN_TREATS = "treats";
    private static final String COLUMN_MEDICATIONS = "medications";
    private static final String COLUMN_VETNAME = "vetName";
    private static final String COLUMN_VETCONTACT = "vetContact";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PETNAME + "TEXT, " +
                COLUMN_BREED + "TEXT, " +
                COLUMN_SEX + "TEXT, " +
                COLUMN_AGE + "TEXT, " +
                COLUMN_WEIGHT + "NUMERIC, " +
                COLUMN_ALLERGIES + "TEXT, " +
                COLUMN_TREATS + "TEXT, " +
                COLUMN_MEDICATIONS + "TEXT, " +
                COLUMN_VETNAME + "TEXT, " +
                COLUMN_VETCONTACT+ "INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addPet(String name, String breed, int age, int weight, String allergies, String treats, String meds, String vetName, String vetContact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PETNAME, name);
        cv.put(COLUMN_BREED, breed);
        cv.put(COLUMN_AGE, age);
        cv.put(COLUMN_WEIGHT, weight);
        cv.put(COLUMN_ALLERGIES, allergies);
        cv.put(COLUMN_TREATS, treats);
        cv.put(COLUMN_MEDICATIONS, meds);
        cv.put(COLUMN_VETNAME, vetName);
        cv.put(COLUMN_VETCONTACT, vetContact);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
