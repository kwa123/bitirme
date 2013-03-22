package kwa.module.contact;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ViewContact extends Activity{
	private Button newc;
	private Button home;
	private Database database;
	
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.contact_view);
	        newc=(Button)findViewById(R.id.newContact);
	        home=(Button)findViewById(R.id.home);
	        
	       
	        ListView contactView=(ListView)findViewById(R.id.listContact);
	        contactView.setClickable(true);
	        
	        contactView.setOnItemLongClickListener(new OnItemLongClickListener() {

				public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					Log.e( "\n aaaa"+arg2+""+arg3+""+arg1,"aa");
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
	        database = new Database(this);
	        
<<<<<<< HEAD
	        ArrayList<String> arr = database.getAllContactNames();
=======
	        home.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(ViewContact.this,Welcome.class);
					startActivity(intent);
					
				}
			});
	        
	        ArrayList<String> arr=new ArrayList<String>();
	        arr.add("hey");
	        arr.add("123");
>>>>>>> ac030ba58b7eb124975612953981ddc6103b9181
	        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
    			 android.R.layout.simple_list_item_1, arr);
	        
	        contactView.setAdapter(aa);
	        
	   }


}
