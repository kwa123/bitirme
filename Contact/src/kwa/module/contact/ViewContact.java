package kwa.module.contact;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.nsd.NsdManager.RegistrationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ViewContact extends Activity{
	private Button newc;
	private Button home;
	private Database database;
	private ListView contactView;
	
	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.contact_view);
	        newc=(Button)findViewById(R.id.newContact);
	        home=(Button)findViewById(R.id.home);
	        
	       
	        contactView = (ListView)findViewById(R.id.listContact);
	        contactView.setClickable(true);
	        
	        /*
	        contactView.setOnItemLongClickListener(new OnItemLongClickListener() {

				public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					Log.e( "\n aaaa"+arg2+""+arg3+""+arg1,"aa");
					return false;
				}
	        	
			});
	        */
	        
	        
	        newc.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(ViewContact.this,MainActivity.class);
					startActivity(intent);
					
				}
	        
	        
	    });
	        database = new Database(this);
	        
	        getContents();
	        
	        
	        home.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(ViewContact.this,Welcome.class);
					startActivity(intent);
					
				}
			});
	        

	       
	        registerForContextMenu(contactView);
	   }
	   
	   private void getContents()
	   {
		   ArrayList<String> arr = database.getAllContactNames();

	        if(arr == null)
	        {
	        	arr = new ArrayList<String>();
	        }
	        
	        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
      			 android.R.layout.simple_list_item_1, arr);
  	        
  	        contactView.setAdapter(aa);
	   }
	   
	   private String listStr;

	   public void onCreateContextMenu(ContextMenu menu, final View v, ContextMenuInfo menuInfo) {
	    	super.onCreateContextMenu(menu, v, menuInfo);
	    	
	    	AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
	    	
	    	listStr = ((TextView) info.targetView).getText().toString();
	    	
	    	Log.e(""+info.position,""+listStr);
	    	
	    	MenuItem deleteItem = menu.add(0,1,1,"delete");
	    	MenuItem editItem = menu.add(1,1,1,"edit");
	    	
	    	deleteItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
				
				public boolean onMenuItemClick(MenuItem item) {
					// TODO Auto-generated method stub
					Contact contact = new Contact(listStr,"");
					database.deleteContect(contact);
					
					getContents();
					return false;
				}
			});
	    	
	    	editItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
				
				public boolean onMenuItemClick(MenuItem item) {
					// TODO Auto-generated method stub
					return false;
				}
			});
	    	
	   }

}
