package kwa.module.contact;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ViewContact extends Activity{
	private Button newc;
	private Button home;
	
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.contact_view);
	        newc=(Button)findViewById(R.id.newContact);
	        home=(Button)findViewById(R.id.home);
	        
	       
	        ListView contactView=(ListView)findViewById(R.id.listContact);
	        contactView.setClickable(true);
	        contactView.setOnLongClickListener(new View.OnLongClickListener() {
				
				public boolean onLongClick(View v) {
					// TODO Auto-generated method stub
					// v.getId();
					Log.e("", v.getId()+"");
					return false;
				}
				
				
			});
	        newc.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(ViewContact.this,MainActivity.class);
					startActivity(intent);
					
				}
	        
	        
	    });
	        
	   }


}
