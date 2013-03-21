package kwa.module.contact;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
	        
	        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
					this);
	 
				// set title
				alertDialogBuilder.setTitle("Deleting");
	 
				// set dialog message
				alertDialogBuilder
					.setMessage("Delete contact ?")
					.setCancelable(false)
					.setPositiveButton("YES",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							
							
						}
					  })
					.setNegativeButton("NO",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, just close
							// the dialog box and do nothing
							dialog.cancel();
						}
					});
	 
					// create alert dialog
					final AlertDialog alertDialog = alertDialogBuilder.create();
	 
					// show it
					
	        
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
	        
	        
	        
	    }


}
