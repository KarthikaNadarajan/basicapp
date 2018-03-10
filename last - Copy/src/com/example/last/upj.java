package com.example.last;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class upj extends Activity {
	Button b;
	Bundle b3;
	String x,y,z,t;
		@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.up);
	        b3=new Bundle();
	        Bundle b2=getIntent().getExtras();
	        x=b2.getString("a");
	       y=b2.getString("b");
	         z=b2.getString("c");
	         t=b2.getString("d");
	        b=(Button)findViewById(R.id.button1);
	       
	 b.setOnClickListener(new OnClickListener() {
	 			
	 			@Override
	 			public void onClick(View arg0) {
	 				Intent i=new Intent(upj.this,bankj.class);
	 				
	 				b3.putString("h",x);
					b3.putString("i",y);
					b3.putString("j",z);
					b3.putString("k",t);
					b3.putString("m","up");

	 				b3.putString("f","100");
					i.putExtras(b3);
	startActivity(i);
	 			}});
		
}
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
