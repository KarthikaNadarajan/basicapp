package com.example.last;






import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class receiptj extends Activity {
	EditText date,vno,cname,ccolor,mode,status,fare;
	String dateb,nob,colorb,nameb,modeb,fareb,paid;
	SQLiteDatabase db;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt);
	date=(EditText)findViewById(R.id.editText1);
	vno=(EditText)findViewById(R.id.editText2);
    cname=(EditText)findViewById(R.id.editText3);
    ccolor=(EditText)findViewById(R.id.editText4);
    mode=(EditText)findViewById(R.id.editText5);
    fare=(EditText)findViewById(R.id.editText6);
    status=(EditText)findViewById(R.id.editText7);
	Bundle b5=getIntent().getExtras();
	dateb=b5.getString("H");
    nob=b5.getString("I");
      colorb=b5.getString("J");
     nameb =b5.getString("K");
      modeb=b5.getString("M");
      fareb=b5.getString("FA");
      paid=b5.getString("p");
      
      date.setText(dateb);
      vno.setText(nob);
      cname.setText(nameb);
      ccolor.setText(colorb);
      fare.setText(fareb);
      mode.setText(modeb);
      db = openOrCreateDatabase("myDataBase.db", MODE_PRIVATE, null);
		
      if(paid.equals(fareb)){
     	 status.setText("Fee paid");
     	 String money="200";
     	 if(paid.equals(money)){
     	db.execSQL("insert into sample values('"+dateb+"','"+nob+"','"+"True"+"');");}
     	 else
     	 {
     		db.execSQL("insert into sample values('"+dateb+"','"+nob+"','"+"False"+"');");
     	 }
      }
      else{
     	 status.setText("Fee unpaid");
     	db.execSQL("insert into sample values('"+dateb+"','"+nob+"','"+"False"+"');");
      }
      db.close();
}
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
