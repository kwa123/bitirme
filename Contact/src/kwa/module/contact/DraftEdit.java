package kwa.module.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DraftEdit extends Activity{

	private Button saveDraft;
	private EditText draftTxt;
	private String draftID;
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.draft_edit);
	        
	        saveDraft=(Button)findViewById(R.id.draftSAVE);
	        draftTxt=(EditText)findViewById(R.id.editDraft1);
	        
	        Intent intent = getIntent();
	        
	        
	        String draftText = intent.getExtras().get("draftText").toString();
	        draftID = intent.getExtras().get("draftID").toString();
	        
	        draftTxt.setText(draftText);
	        
	        saveDraft.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(DraftEdit.this,Drafts.class);
					intent.putExtra("draftID", draftID);
					intent.putExtra("draftText", draftTxt.getText().toString());
					startActivity(intent);
				}
			});
	  }
}
