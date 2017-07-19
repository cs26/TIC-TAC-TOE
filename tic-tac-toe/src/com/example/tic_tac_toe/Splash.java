package com.example.tic_tac_toe;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		Thread t = new Thread()
		{
				public void run(){
					try{
							sleep(3000);}
					catch(InterruptedException e){
						e.printStackTrace();}
					finally{
						Intent intent =new Intent(Splash.this,Register.class);
						startActivity(intent);
	                 }
		          }
				};
			t.start();
			
		}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

}
