package com.merin.demoacty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondaryActivity extends Activity {

	
	String msg_string1;
	Bundle extras1;
	Intent startintent1;
	
	Button button1;
	Button button2;
	
	EditText edittext1;
	TextView textview4;
	String intentmsg1;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secondary);
		// Show the Up button in the action bar.
		//setupActionBar();
		

		
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		
		edittext1 = (EditText) findViewById(R.id.editText1);
		textview4 = (TextView) findViewById(R.id.textView4);
		
		startintent1 = new Intent(this, MainActivity.class);
		
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				intentmsg1 = edittext1.getText().toString();
				startintent1.putExtra("ACTION_MSG", intentmsg1);
				startActivity(startintent1);
				finish();
				
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		//msg_string1 = "debugging";
		//Log.i("merin-log", msg_string1);
		
		extras1 = getIntent().getExtras();
		
		
		
		//Log.i("merin-log", msg_string1);
		
		
		//msg_string1 = getIntent().getExtras().getString("ACTION_MSG").toString();
				
		//Log.i("merin-log", msg_string1);
		if (extras1 == null) {
			Toast.makeText(this, "No msg from Activity 1 " , Toast.LENGTH_LONG).show();    
		}else{
			msg_string1 = extras1.getString("ACTION_MSG");
			Toast.makeText(this, msg_string1, Toast.LENGTH_LONG).show();
			textview4.setText(msg_string1);
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
