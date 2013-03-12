package com.merin.demoacty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button button1;
	Button button2;
	
	EditText etext1;
	String etext_string;
	String intentmsg1;
	
	Bundle extras1;
	//String ACTION_MSG;
	//private Intent startintent1 = new Intent(this, SecondaryActivity.class);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Log.w("merin-log", "msg_string1");
		extras1 = getIntent().getExtras();
		
		if (extras1 != null){
			intentmsg1 = extras1.getString("ACTION_MSG");  
			if (intentmsg1 == "") {
				Toast.makeText(this, "No msg from Activity 2 " , Toast.LENGTH_LONG).show();    
			}else{
				Log.w("merin-log", intentmsg1);
				Toast.makeText(this, intentmsg1, Toast.LENGTH_LONG).show();
				
			}
		}
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		
		etext1 = (EditText) findViewById(R.id.editText1);
		
		
		//Log.w("merin-log", etext_string);
		
		final Intent startintent1 = new Intent(this, SecondaryActivity.class);
		
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				etext_string = etext1.getText().toString();
				startintent1.putExtra("ACTION_MSG", etext_string);
				
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
	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
