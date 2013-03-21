package kwa.module.contact;

import android.app.Activity;
import android.os.Bundle;
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.draft);
        
        edit1=(Button)findViewById(R.id.button1);
        edit2=(Button)findViewById(R.id.button2);
        edit3=(Button)findViewById(R.id.button3);
        edit4=(Button)findViewById(R.id.button4);
        edit5=(Button)findViewById(R.id.button5);
        
        draft1=(TextView)findViewById(R.id.textView1);
        draft2=(TextView)findViewById(R.id.textView2);
        draft3=(TextView)findViewById(R.id.textView3);
        draft4=(TextView)findViewById(R.id.textView4);
        draft5=(TextView)findViewById(R.id.textView5);
        
        
        
    }
	
	
}

 