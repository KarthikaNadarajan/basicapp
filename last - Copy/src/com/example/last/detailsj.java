package com.example.last;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class detailsj extends Activity{
	EditText date,no,color,name;
	RadioGroup g;
	Bundle b1;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailsx);
        date=(EditText)findViewById(R.id.editText1);
        no=(EditText)findViewById(R.id.editText2);
        color=(EditText)findViewById(R.id.editText4);
        name=(EditText)findViewById(R.id.editText3);
        g=(RadioGroup)findViewById(R.id.radioGroup1);
        
                g.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@SuppressLint("NewApi") @Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				String D=date.getText().toString();
				String N=no.getText().toString();
				String Nam=name.getText().toString();			
			    String C=color.getText().toString();
			    if(D.isEmpty()||N.isEmpty()||Nam.isEmpty()||C.isEmpty()){
		        	Toast.makeText(getApplicationContext(),"Enter all the fields.",20000).show(); 
			    }else {
			    b1=new Bundle();				
				b1.putString("a",D);
				b1.putString("b",N);
				b1.putString("d",C);
				b1.putString("c",Nam);
				
				

				// TODO Auto-generated method stub
			switch(arg1)	{
			case R.id.radio0:Intent i=new Intent(detailsj.this,upj.class);
					     	 i.putExtras(b1);
							startActivity(i);					                
			                 break;
			case R.id.radio1:Intent j=new Intent(detailsj.this,upanddownj.class);
					     	 j.putExtras(b1);
							startActivity(j);					                
			                break;
			}
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
