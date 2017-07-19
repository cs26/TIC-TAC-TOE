package com.example.tic_tac_toe;



import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button a1btn,a2btn,a3btn,b1btn,b2btn,b3btn,c1btn,c2btn,c3btn;
	Button[] arr;
	Button newgame,ext;
	AlertDialog.Builder builder;
boolean turn=true;
int turn_count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		newgame=(Button)findViewById(R.id.nwgame);
		ext=(Button)findViewById(R.id.exit);
		a1btn=(Button)findViewById(R.id.a1);
		a2btn=(Button)findViewById(R.id.a2);
		a3btn=(Button)findViewById(R.id.a3);
		b1btn=(Button)findViewById(R.id.b1);
		b2btn=(Button)findViewById(R.id.b2);
		b3btn=(Button)findViewById(R.id.b3);
		c1btn=(Button)findViewById(R.id.c1);
		c2btn=(Button)findViewById(R.id.c2);
		c3btn=(Button)findViewById(R.id.c3);
		arr=new Button[]{a1btn,a2btn,a3btn,b1btn,b2btn,b3btn,c1btn,c2btn,c3btn};
		
		for(Button b:arr){
			b.setOnClickListener(this);
			newgame.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					turn=true;
					turn_count=0;
					enabledisablebtn(true);
				}
			});
			
			
		}
	}

	
	@Override
	public void onClick(View v) {
		Button b=(Button)v;
		buttonclicked(b);
	}

public void buttonclicked(Button b){
	if(turn){
		b.setText("X");
	}else
	{
		b.setText("O");
		}
	turn_count++;
	b.setBackgroundColor(Color.YELLOW);
	b.setClickable(false);
	turn=!turn;
	checkforwinner();
}



public void checkforwinner(){
	boolean winner=false;
//horizontal condition
	if(a1btn.getText()==a2btn.getText()  && a2btn.getText()==a3btn.getText()&& !a1btn.isClickable()){
		winner=true;
	}
	else if(b1btn.getText()==b2btn.getText()  && b2btn.getText()==b3btn.getText() && !b1btn.isClickable()){
		winner=true;
	}
	else if(c1btn.getText()==c2btn.getText()  && c2btn.getText()==c3btn.getText()&& !c1btn.isClickable()){
		winner=true;
	}
	//vertical
	
	else if(a1btn.getText()==b1btn.getText()  && b1btn.getText()==c1btn.getText()&& !a1btn.isClickable()){
		winner=true;
	}
	else if(a2btn.getText()==b2btn.getText()  && b2btn.getText()==c2btn.getText() && !b2btn.isClickable()){
		winner=true;
	}
	else if(a3btn.getText()==b3btn.getText()  && b3btn.getText()==c3btn.getText()&& !c3btn.isClickable()){
		winner=true;
	}
	
	
	//diagonal
	else if(a1btn.getText()==b2btn.getText()  && b2btn.getText()==c3btn.getText()&& !a1btn.isClickable()){
		winner=true;
	}
	else if(a3btn.getText()==b2btn.getText()  && b2btn.getText()==c1btn.getText()&& !b2btn.isClickable()){
		winner=true;
	}
	
	
	
	
if(winner){
	if(!turn){
		Toast.makeText(this,"X wins",Toast.LENGTH_LONG).show();
	}
	else
	{
		Toast.makeText(this,"O wins",Toast.LENGTH_LONG).show();
	}
	
	enabledisablebtn(false);
	
}
else if(turn_count==9)
{
	Toast.makeText(getApplicationContext(), "DRAW",Toast.LENGTH_LONG).show();
	
}
}


private void enabledisablebtn(boolean enable) {
	for(Button b:arr){
		b.setClickable(enable);
		if(enable){
			b.setBackgroundColor(Color.parseColor("#33b5e5"));
			b.setText("");
		
		}
		else
		{
			b.setBackgroundColor(Color.YELLOW);
		}
	}
	ext.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			finish();
			
		}
	});
	
}

}