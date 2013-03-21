package kwa.module.contact;

import android.app.Activity;
import android.os.Bundle;
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
	        
	    }
	   
	   


}
