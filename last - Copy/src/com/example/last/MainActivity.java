package com.example.last;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
Button b,r;
SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				db = openOrCreateDatabase("myDataBase.db", MODE_PRIVATE, null);
				db.execSQL("create table if not exists sample(vdate varchar,vno varchar,vstatus varchar);");
				db.close();
				Intent i=new Intent(MainActivity.this,detailsj.class);
				startActivity(i);
			}
		});
    
    r=(Button)findViewById(R.id.button2);
    r.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent j=new Intent(MainActivity.this,returnj.class);
			startActivity(j);
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
