package com.example.last;




import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import android.view.View.OnClickListener;
public class bankj extends Activity {
	Button b0;
	Bundle b4;
	EditText acc,rs;
	String A,B,C,D,E,F;
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.bank);
	        b4=new Bundle();
	        Bundle b6=getIntent().getExtras();
	       A =b6.getString("h");
	       B=b6.getString("i");
	         C=b6.getString("j");
	        D =b6.getString("k");
	        E =b6.getString("m");
	        F =b6.getString("f");
	        
	        b0=(Button)findViewById(R.id.button1);
	 rs=(EditText)findViewById(R.id.editText2);
	 
	        acc=(EditText)findViewById(R.id.editText1);
	        b0.setOnClickListener(new OnClickListener() {
				
				@SuppressLint("NewApi") @Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String a=acc.getText().toString();
			        String amount=rs.getText().toString();
			        if(a.isEmpty()||amount.isEmpty()){
			        	Toast.makeText(getApplicationContext(),"Enter all the fields.",20000).show(); 
			        }else{
			        Intent i=new Intent(bankj.this,receiptj.class);
					b4.putString("p",amount);
					b4.putString("H",A);
					b4.putString("I",B);
					b4.putString("J",C);
					b4.putString("K",D);
					b4.putString("M",E);
					b4.putString("FA",F);
					i.putExtras(b4);
					startActivity(i);
				}}
				});
	 }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
}
}
