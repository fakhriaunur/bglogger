package com.BgLogger.model.glucose;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.BgLogger.model.GenericDao;

/**
 * @author   Scott Leonard, 
 * Created:  07/01/2012, 
 * Modified: 07/08/2012
 */
public class BloodGlucoseLogDao extends GenericDao{
	public static final String LOG_TIME_FIELD_NAME = "log_time";
	public static final String READING_FIELD_NAME = "reading";
	
	private static final String TABLE_NAME = "blood_glucose_log";
	private static final String CREATE_SCRIPT = "CREATE TABLE IF NOT EXISTS " 
			+ TABLE_NAME + " ("
			+ "_id integer primary key autoincrement" 
			+ ",blood_glucose_type_id integer not null"
			+ ",blood_glucose_measurement_unit_id integer not null" 
			+ ",reading numeric not null"
			+ ",log_time datetime not null);";

	public BloodGlucoseLogDao(Context context) {
		super(context,TABLE_NAME,CREATE_SCRIPT);
	}

	public BloodGlucoseLogDao openToRead() throws android.database.SQLException {
		return (BloodGlucoseLogDao)super.openToRead();
	}

	public BloodGlucoseLogDao openToWrite() throws android.database.SQLException {
		return (BloodGlucoseLogDao)super.openToWrite();
	}
	
	public Cursor queueAll(){
		return super.queueAll("log_time desc");
	}

	public long insertBloodGlucoseLog(BloodGlucoseLog bloodGlucoseLog) {
		ContentValues entityMap = new ContentValues();

		entityMap.put("_id", bloodGlucoseLog.getId());
		entityMap.put("blood_glucose_measurement_unit_id", bloodGlucoseLog.getBloodGlucoseMeasurementUnitId());
		entityMap.put("blood_glucose_type_id", bloodGlucoseLog.getBloodGlucoseTypeId());
		entityMap.put("log_time", bloodGlucoseLog.getLogTimeFormatted());
		entityMap.put("reading", bloodGlucoseLog.getReading().toString());
		
		return super.insert(TABLE_NAME, entityMap);

	}
}
