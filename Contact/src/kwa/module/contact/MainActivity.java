package kwa.module.contact;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button save;
	private EditText name;
	private EditText number;
	private Contact contact;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=(Button)findViewById(R.id.button1);
        name=(EditText)findViewById(R.id.editText1);
        number=(EditText)findViewById(R.id.editText2);
        
        save.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				contact = new Contact(name.getText().toString(), number.getText().toString());
			
				Intent intent=new Intent(MainActivity.this,ViewContact.class);
				startActivity(intent);
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
