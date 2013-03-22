package kwa.module.contact;

import java.util.ArrayList;

import android.content.Context;

public class Database {

	private static DatabaseAdapter databaseAdapter;
	
	public Database(Context context) {
		// TODO Auto-generated method stub
		if(databaseAdapter == null)
		{
			databaseAdapter = new DatabaseAdapter(context);
		}
	}
	
	public static void insertContact(Contact contact)
	{
		databaseAdapter.open();
		databaseAdapter.insertEntry(contact);
		databaseAdapter.close();
	}
	
	public static ArrayList<Contact> getAllContacts()
	{
		return databaseAdapter.getAllEntries();
	}
	
	public static ArrayList<String> getAllContactNames()
	{
		databaseAdapter.open();
		ArrayList<String> str = databaseAdapter.getAllEntryNames();
		int a = 1;
		return str;
	}
}
