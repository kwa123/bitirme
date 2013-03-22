package kwa.module.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends Activity{
	private Button draft;
	private Button contact;
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.welcome);
	        draft=(Button)findViewById(R.id.dra);
	        contact=(Button)findViewById(R.id.contact);
	        
	        draft.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent intent=new Intent(Welcome.this,Drafts.class);
					startActivity(intent);
				}
			});
	        
	        contact.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent intent=new Intent(Welcome.this,ViewContact.class);
					startActivity(intent);
				}
			});
	  };

}
