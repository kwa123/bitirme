package kwa.module.contact;

import java.util.ArrayList;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Drafts extends Activity {
	private Button edit1;
	private Button edit2;
	private Button edit3;
	private Button edit4;
	private Button edit5;
	private TextView draft1;
	private TextView draft2;
	private TextView draft3;
	private TextView draft4;
	private TextView draft5;
	private Button home;
	private static ArrayList<String> drafts;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draft);
        
        if(drafts == null)
        {
        	drafts = new ArrayList<String>();
        	drafts.add("Draft1");
        	drafts.add("Draft2");
        	drafts.add("Draft3");
        	drafts.add("Draft4");
        	drafts.add("Draft5");
        }
        
        edit1=(Button)findViewById(R.id.button1);
        edit2=(Button)findViewById(R.id.button2);
        edit3=(Button)findViewById(R.id.button3);
        edit4=(Button)findViewById(R.id.button4);
        edit5=(Button)findViewById(R.id.button5);
        
        home=(Button)findViewById(R.id.home);
        
        draft1=(TextView)findViewById(R.id.textView1);
        draft2=(TextView)findViewById(R.id.textView2);
        draft3=(TextView)findViewById(R.id.textView3);
        draft4=(TextView)findViewById(R.id.textView4);
        draft5=(TextView)findViewById(R.id.textView5);
        
        Intent intentFirst = getIntent();
        
        if(intentFirst.hasExtra("draftID"))
        {
        	String draftText = intentFirst.getExtras().get("draftText").toString();
        	int draftID = Integer.parseInt(intentFirst.getExtras().get("draftID").toString());
        	
        	for(int i=0;i<5;++i)
        	{
        		if(draftID == i+1)
        			drafts.set(i, draftText);	
        	}
        }
        
        
        setDrafts();
       
        
        edit1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Drafts.this,DraftEdit.class);
				intent.putExtra("draftID", "1");
				intent.putExtra("draftText", draft1.getText().toString());
				startActivity(intent);
			}
		});
        
        edit2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Drafts.this,DraftEdit.class);
				intent.putExtra("draftID", "2");
				intent.putExtra("draftText", draft2.getText().toString());
				startActivity(intent);
			}
		});
        
        edit3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Drafts.this,DraftEdit.class);
				intent.putExtra("draftID", "3");
				intent.putExtra("draftText", draft3.getText().toString());
				startActivity(intent);
			}
		});
        edit4.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Drafts.this,DraftEdit.class);
				intent.putExtra("draftID", "4");
				intent.putExtra("draftText", draft4.getText().toString());
				startActivity(intent);
			}
		});
        
        edit5.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Drafts.this,DraftEdit.class);
				intent.putExtra("draftID", "5");
				intent.putExtra("draftText", draft5.getText().toString());
				startActivity(intent);
			}
		});
        
        home.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Drafts.this,Welcome.class);
				startActivity(intent);
			}
		});
        
        
    }
	
    
    void setDrafts()
    {
    	draft1.setText(drafts.get(0));
    	draft2.setText(drafts.get(1));
    	draft3.setText(drafts.get(2));
    	draft4.setText(drafts.get(3));
    	draft5.setText(drafts.get(4));
    }
	
}

 