package com.BgLogger;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.BgLogger.R;
import com.BgLogger.R.array;
import com.BgLogger.R.id;
import com.BgLogger.R.layout;



//activity to create custom log

public class MedicineActivity extends Activity {
	

	SimpleCursorAdapter cursorAdapter;
	Cursor cursor;
	private MedicineDBAdapter MedicationdbAdapter;
  
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_log);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
    	ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.medicine_array, android.R.layout.simple_spinner_item);
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner.setAdapter(adapter);
    	
		//final MedicationDBAdapter MedicationdbAdapter;
                                                   
    	final Spinner spinner2 = (Spinner) findViewById(R.id.Spinner01);
    	ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.diabetic_array, android.R.layout.simple_spinner_item);
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner2.setAdapter(adapter2);
    	
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinnerUnits);
    	ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.Units_array, android.R.layout.simple_spinner_item);
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	spinner3.setAdapter(adapter3);

    	
		MedicationdbAdapter = new MedicineDBAdapter(this);
		MedicationdbAdapter.openToWrite();
		cursor = MedicationdbAdapter.queueAll();

		
		String [] from = new String [] {MedicineDBAdapter.KEY_MedicationDATE, MedicineDBAdapter.KEY_MedicationTIME,	
				MedicineDBAdapter.KEY_MedicationDosage, MedicineDBAdapter.KEY_MedicationName, MedicineDBAdapter.KEY_MedicationMethodofDelivery};
        int [] to = new int [] { R.id.text1, R.id.text2, R.id.text3, R.id.text4};
        
        cursorAdapter = new SimpleCursorAdapter (this, R.layout.row, cursor, from, to);
        
        
        Button backbutton = (Button) findViewById(R.id.back);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
        
        
 
        
    Button btnAddMedication = (Button) findViewById(R.id.buttonAddMedication);
    btnAddMedication.setOnClickListener(new View.OnClickListener(){
	public void onClick(View v) {
		
		EditText editTextDosage;
		TextView txtMsgbox;
		Integer Dosage;
		String Measurement;
		Dosage = 0;
		
		
		
		editTextDosage = (EditText)findViewById(R.id.editTextDosage);
		txtMsgbox = (TextView)findViewById(R.id.txtMsgBoxMed);
		
		
		String Dosageinput = editTextDosage.getText().toString();
		
		
		Spinner spinnerMedication = (Spinner)findViewById(R.id.spinner1);
        String SpinnerMedicationText = spinnerMedication.getSelectedItem().toString();
        
		Spinner spinnerMethod = (Spinner)findViewById(R.id.Spinner01);
        String SpinnerMethodText = spinnerMethod.getSelectedItem().toString();
        
		Spinner spinnerUnits = (Spinner)findViewById(R.id.spinnerUnits);
        String SpinnerUnitsText = spinnerUnits.getSelectedItem().toString();
        
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePickerMedication);    
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePickerMedication);

		int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();
		String CurrentDate;
		String CurrentMin;
		String CurrentHour;
		String DosageStr;
		String CurrentTime;
		int hour = timePicker.getCurrentHour();
		int minute = timePicker.getCurrentMinute();
        		

        
        CurrentDate = String.valueOf(month)+"/"+String.valueOf(day)+"/"+String.valueOf(year);
        
        if (hour < 10){
        CurrentHour = "0" + String.valueOf(hour);
        }
        else
        {
        CurrentHour = String.valueOf(hour);
        }
        
        if (minute < 10){
        CurrentMin = "0" + String.valueOf(minute);
        }
        else
        {
        CurrentMin = String.valueOf(minute);
        }
        
        CurrentTime = CurrentHour+":"+ CurrentMin;
        
        
			if (editTextDosage != null && editTextDosage.length() >0){
		    	
	      DosageStr = String.valueOf(Dosage);
				
			MedicationdbAdapter.insert(CurrentDate, CurrentTime, DosageStr, SpinnerMedicationText + " " + SpinnerUnitsText, SpinnerMethodText );
			//cursor.requery();
			txtMsgbox.setText("Medication has been added." );
			 Handler handler = new Handler(); 
			    handler.postDelayed(new Runnable() { 
			         public void run() { 
			        	 Intent intent = new Intent();
			             setResult(RESULT_OK, intent);
			             finish(); 
			         } 
			    }, 2000); 
			
    	
    	}
    	else
    	{
    		txtMsgbox.setText("Please enter duration of Medication.");
    	}

	}
});

};

    @Override
    protected void onDestroy() {
    	
    	super.onDestroy();
    	MedicationdbAdapter.close();
    }
}