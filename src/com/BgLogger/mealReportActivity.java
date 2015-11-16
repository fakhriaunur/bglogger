package com.BgLogger;

import android.app.Activity;
import com.BgLogger.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.database.*;
import android.widget.*;

public class mealReportActivity extends Activity {
	private DBAdapter mealdatabase;
	@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.mealreport);

ListView mealData = (ListView)findViewById(R.id.MeallistView);

mealdatabase = new DBAdapter(this);
mealdatabase.openToWrite();
Cursor results = mealdatabase.SUMtotal();


String [] from = new String [] {DBAdapter.KEY_DATE, DBAdapter.KEY_CARBS, DBAdapter.KEY_LOAD};
int [] to = new int [] {R.id.date, R.id.carbs, R.id.gload};

SimpleCursorAdapter displayAdapter = (SimpleCursorAdapter) new SimpleCursorAdapter (this, R.layout.report_meal_row, results, from, to);
mealData.setAdapter(displayAdapter);

Button mealBackbutton = (Button) findViewById(R.id.mealBackbutton);
mealBackbutton.setOnClickListener(new View.OnClickListener() {
public void onClick(View view) {
Intent mealintent = new Intent();
setResult(RESULT_OK, mealintent);
finish();
}
});

}
}

