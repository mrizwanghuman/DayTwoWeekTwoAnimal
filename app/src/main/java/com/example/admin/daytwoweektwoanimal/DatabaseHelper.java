package com.example.admin.daytwoweektwoanimal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  Admin on 11/14/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="AnimalDB";
    public static final int VERSION =2;
// Tables to create
    public static final String TABLE_CATEGORIES ="Species";
    public static final String TABLE_ANIMAL = "animal";

    // Columns to create
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_ANI_ID="id";
    public static final String COLUMN_NAME ="Name";
    public static final String COLUMN_ANI_DES = "AnimalDesciption";
    public static final String COLUMN_CAT_ID = "CatID";
    private static final String CREATE_TABLE_CAT = "CREATE TABLE " + TABLE_CATEGORIES
            + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_NAME +" TEXT "+ ")";

    private static final String CREATE_TABLE_ANI = "CREATE TABLE " + TABLE_ANIMAL
            + "(" + COLUMN_ANI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_NAME + " TEXT, "+
            COLUMN_ANI_DES+" TEXT,"+ COLUMN_CAT_ID +" TEXT"+")";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//sqLiteDatabase.execSQL(CREATE_TABLE_CAT);
sqLiteDatabase.execSQL((CREATE_TABLE_ANI));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
      //  db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_ANIMAL);

onCreate(db);
    }

    public  long saveSpecy(AnimalSpecies species){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,species.getId());
        contentValues.put(COLUMN_NAME, species.getName());
        long row = db.insert(TABLE_CATEGORIES, null, contentValues);
        return  row;

    }
    public  long saveAnimal(Animal animal){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ANI_ID,animal.getId());
        contentValues.put(COLUMN_NAME, animal.getName());
        contentValues.put(COLUMN_ANI_DES, animal.getDescription());
        contentValues.put(COLUMN_CAT_ID, animal.getCat_id());
        long row = db.insert(TABLE_ANIMAL, null, contentValues);
        return  row;
    }

    public List<AnimalSpecies> getSpecies(){
        List<AnimalSpecies> speciesList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "SELECT * FROM "+ TABLE_CATEGORIES;
        Cursor cursor = database.rawQuery(QUERY, null);
        if(cursor.moveToFirst()){
            do{
                AnimalSpecies species = new AnimalSpecies(cursor.getString(0), cursor.getString(1));
                speciesList.add(species);
            }while (cursor.moveToNext());
        }
        return speciesList;
    }
    public List<Animal> getAnimal(){
        List<Animal> AnimalList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "SELECT * FROM "+ TABLE_ANIMAL;
        Cursor cursor = database.rawQuery(QUERY, null);
        if(cursor.moveToFirst()){
            do{
                Animal animal = new Animal(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                AnimalList.add(animal);
            }while (cursor.moveToNext());
        }
        return AnimalList;
    }
    public List<Animal> getAnimal(String id){
        List<Animal> AnimalList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "SELECT * FROM "+ TABLE_ANIMAL +" WHERE CatID="+id ;
        Cursor cursor = database.rawQuery(QUERY, null);
        if(cursor.moveToFirst()){
            do{
                Animal animal = new Animal(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
                AnimalList.add(animal);
            }while (cursor.moveToNext());
        }
        return AnimalList;
    }

}
