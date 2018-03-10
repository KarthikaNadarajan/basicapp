package com.example.last;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 

public class returnj extends Activity{
	Button b0;
	EditText date,no;
	SQLiteDatabase db;
	Cursor c;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eturn);
        b0=(Button)findViewById(R.id.button1);
        
   	 date=(EditText)findViewById(R.id.editText2);
   	 
   	        no=(EditText)findViewById(R.id.editText1);
   	        b0.setOnClickListener(new OnClickListener() {
   				
   				@SuppressLint("NewApi") @Override
   				public void onClick(View arg0) {
   					// TODO Auto-generated method stub
   					String s1=no.getText().toString();
   			       String s2= date.getText().toString();
   			    if(s1.isEmpty()||s2.isEmpty()){
		        	Toast.makeText(getApplicationContext(),"Enter all the fields.",20000).show(); 
		        }else{
   			     db = openOrCreateDatabase("myDataBase.db", MODE_PRIVATE, null);
 				c = db.rawQuery("select * from sample where vno='"+s1+"'", null);
 				
 				if(c.getCount()==0){
 					Toast.makeText(getApplicationContext(), "No:"+s1+" "+"NotFound", 5000).show();
 				}
 				while (c.moveToNext()) {
 					String y="True";
 					String not="False";
 					String vdate = c.getString(0);
 					String vno = c.getString(1);
 					String vstatus = c.getString(2);
 					if((vdate.equals(s2))&&(vstatus.equals(y))){
 					Toast.makeText(getApplicationContext(), "Happy journey!!!", Toast.LENGTH_SHORT).show();
 				}
 					else if((vdate.equals(s2))&&(vstatus.equals(not))){
 	 					Toast.makeText(getApplicationContext(), " You didn't pay the amount.Sry", Toast.LENGTH_SHORT).show();
 	 				}	
 					else if((vdate.equals(s2)==false)){
 	 					Toast.makeText(getApplicationContext(), "Sry.You are late.Take another ticket.", Toast.LENGTH_SHORT).show();
 	 				}
 				}
 				c.close();
 				db.close();
		        }
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
