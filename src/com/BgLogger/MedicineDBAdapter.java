package com.BgLogger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

//double value = Double.parseDouble(txtInput);
//import com.BgLogger.DBAdapter.SQLiteHelper;

public class MedicineDBAdapter {

	
	//variables declaration
	
	public static final String DB_Name = "BGLOGGER_DATABASE_3";
	public static final String Medication_Schedule = "Medication_Schedule";
	public static final int DB_Version = 1;
	public static final String KEY_ID = "_id";
	public static final String KEY_MedicationDATE = "MedicationDATE";
	public static final String KEY_MedicationTIME = "MedicationTime";
	public static final String KEY_MedicationDosage = "MedicationDosage";
	public static final String KEY_MedicationName = "MedicationName";
	public static final String KEY_MedicationMethodofDelivery = "MedicationMethodOfDelivery";
	
	private static final String DBSCRIPT =
			"CREATE TABLE IF NOT EXISTS Medication_Schedule (" +
			"_id integer primary key," +
			"MedicationDATE String not null, " +
			"MedicationTime String not null," +
			"MedicationDosage String not null," +
			"MedicationName String not null," +
			"MedicationMethodOfDelivery String not null);";
	
	private static final String DBSCRIPT2 =
			"CREATE TABLE IF NOT EXISTS Exercise_Schedule (" +
			"_id integer primary key," +
			"WorkoutDATE String not null, " +
			"WorkoutDurationMinutes integer not null," +
			"WorkoutNAME String not null);";

	
	private Context context;
	private SQLiteDatabase db;
	private SQLiteHelper dbHelper;

	public MedicineDBAdapter(Context c) {
	    context = c;
	}
	
	public void onOpen(SQLiteDatabase db) {
	    db.execSQL(DBSCRIPT);
	}
	
	public MedicineDBAdapter openToRead() throws android.database.SQLException {
	    dbHelper = new SQLiteHelper (context, DB_Name, null, DB_Version);
	    db = dbHelper.getReadableDatabase();
	    return this;
	}

	public MedicineDBAdapter openToWrite() throws android.database.SQLException {
		dbHelper = new SQLiteHelper (context, DB_Name, null, DB_Version);
		db = dbHelper.getWritableDatabase();
	return this;	
	}
	
	public void close() {
	    dbHelper.close();
	}
	
	
	
	public long insert (String MedicationDATE, String MedicationTime, 
			String MedicationDosage, String MedicationName, String MedicationMethodofDelivery)
	{
	    ContentValues content =new ContentValues();
	    content.put(KEY_MedicationDATE  , MedicationDATE);
	    content.put(KEY_MedicationTIME , MedicationTime);
	    content.put(KEY_MedicationDosage  , MedicationDosage);
	    content.put(KEY_MedicationName  , MedicationName);
	    content.put(KEY_MedicationMethodofDelivery  , MedicationMethodofDelivery);
 
	    return db.insert(Medication_Schedule, null, content);
	    
	}


	//delete entry by name with this method
	
		public void delete_byName(String Name){
			String deleteSql = "DELETE FROM Medication_Schedule WHERE MedicationNAME=" +
					"'" + Name + "'";
			db.rawQuery(deleteSql, null).moveToFirst();

			}
		
		//retrieve all data from food table with this method
		
	   public Cursor queueAll () {
		   
		   
		   Cursor cursor = db.rawQuery("select rowid _id, * from Medication_Schedule", null);
		   return cursor;
		   
	   }
	   

	   public class SQLiteHelper extends SQLiteOpenHelper {   
		   
		   public SQLiteHelper (Context context, String name, CursorFactory factory, int version) {
			   super (context, name, factory, version);
		   }
		   
		   @Override
		   public void onCreate (SQLiteDatabase db) {
			   db.execSQL(DBSCRIPT);
			   db.execSQL(DBSCRIPT2);
		   }
		   
		   @Override
		   public void onUpgrade (SQLiteDatabase db, int oldversion, int newversion) {
			   
			   
		   }
	   }
	}

