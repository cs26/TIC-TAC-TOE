package com.example.tic_tac_toe;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends Activity {
EditText ed1,ed2;
Button ply;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		ed1=(EditText)findViewById(R.id.pname1);
		ed2=(EditText)findViewById(R.id.pname2);
		
		ply=(Button)findViewById(R.id.subbtn);
		ply.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {

				String s1,s2;
				s1=ed1.getText().toString();
				s2=ed2.getText().toString();
				Intent i=new Intent(Register.this,MainActivity.class);
				startActivity(i);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}
