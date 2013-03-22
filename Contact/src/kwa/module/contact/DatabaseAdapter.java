package kwa.module.contact;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DatabaseAdapter {
	private static String DATABASE_NAME = "database.db";
	private static int DATABASE_VERSION = 4;
	private static String DATABASE_TABLE = "contacts";
	private static String KEY_ID="id";
	private static String KEY_NAME="name";
	public static final int NAME_COLUMN = 1;
	private static String KEY_TEL="tel";
	public static final int TEL_COLUMN = 2;
	
	
	
	// SQL Statement to create a new database.
	private static final String SQL_DATABASE_CREATE = 
			"create table " + DATABASE_TABLE + 
			" (" + KEY_ID + " integer primary key autoincrement, " +
				   KEY_NAME + " text not null, " + 
				   KEY_TEL + " text not null);";
	// Variable to hold the database instance
	private SQLiteDatabase db;
	// Context of the application using the database.
	private final Context context;
	// Database open/upgrade helper
	private SimpleDatabaseHelper dbHelper;
	
	SimpleDatabaseHelper getDbHelper() {
		return dbHelper;
	}
	public DatabaseAdapter(Context context) {
		this.context = context;
		dbHelper = new SimpleDatabaseHelper(context, DATABASE_NAME, 
				null, DATABASE_VERSION);
	}
	public DatabaseAdapter open() throws SQLException {
		db = dbHelper.getWritableDatabase();
		return this;
	}
	public void close() {
		db.close();
	}
	public int insertEntry(Contact contact) {
		// TODO: Create a new ContentValues to represent contact
		// and insert it into the database.
		ContentValues newEntry = new ContentValues();
		//assign values for each row
		newEntry.put(KEY_NAME, contact.getName());
		newEntry.put(KEY_TEL, contact.getTel());
		return (int) db.insert(DATABASE_TABLE, null, newEntry);
	}
	
	public boolean removeEntry(long keyId) {
		return db.delete(DATABASE_TABLE, KEY_ID+"=" 
				+ keyId, null) > 0;
	}
	
	/*
	public Cursor getAllEntries () {
		return db.query(DATABASE_TABLE, new String[] {KEY_ID, KEY_NAME},
					KEY_TEL, null, null, null, null);
	}
	*/
	
	public Contact getEntry(long rowIndex){
		Cursor cursor = db.query(true, DATABASE_TABLE,
				new String[] {KEY_ID, KEY_NAME, KEY_TEL},
				KEY_ID + "=" + rowIndex, null, null, null,
				null, null);
		if ((cursor.getCount() == 0) || !cursor.moveToFirst()) {
			throw new SQLException
					("No to do item found for row: " + rowIndex);
		}
		String name = cursor.getString(NAME_COLUMN);
		String surname = cursor.getString(TEL_COLUMN);
		Contact contact = new Contact(name, surname);
		return contact;
	}	
	
	public int getId(Contact contact){
		String where = KEY_NAME + "=" + contact.getName()+ 
						" and "+
					   KEY_TEL + "="+ contact.getTel();		
		Cursor cursor = db.query(true, DATABASE_TABLE,
				new String[] {KEY_ID, KEY_NAME, KEY_TEL},where, 
				null, null, null,null, null);
		if ((cursor.getCount() == 0) || !cursor.moveToFirst()) {
			throw new SQLException
					("No to do item found for row: " + 
							contact.getName()+"," +
							contact.getTel());
		}
		int id = cursor.getInt(0);
		return id;
	}
	
	
	public boolean updateEntry(long rowIndex, Contact contact) {		
		ContentValues updateAnEntry = new ContentValues();
		updateAnEntry.put(KEY_NAME, "John M.");
		String whereStr = KEY_ID + "="+ rowIndex;
		db.update(DATABASE_TABLE, updateAnEntry, whereStr, null);
		return true;
	}
	
	static class SimpleDatabaseHelper extends SQLiteOpenHelper{
		public SimpleDatabaseHelper(Context context, String name,
				CursorFactory factory, int version) {
			super(context, name, factory, version);
		}
		// Called when no database exists in disk 
		// and the helper class needs
		// to create a new one.
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(SQL_DATABASE_CREATE);
		}
		// Called when there is a database version 
		// mismatch meaning that the version
		// of the database on disk needs to be 
		// upgraded to the current version.
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// Log the version upgrade.
			Log.w("TaskDBAdapter", "Upgrading from version " +
					oldVersion + " to " +
					newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);			
		}		
	}
	
	public ArrayList<Contact> getAllEntries(){
		ArrayList<Contact> allContacts = new ArrayList<Contact>();
		Cursor cursor1 = db.query(true, DATABASE_TABLE,new String[] { KEY_NAME, KEY_TEL},null, null, null, null, null, null);

		
		if((cursor1.getCount() == 0) || !cursor1.moveToFirst())
			return null;
		else
		{
			cursor1.moveToFirst();
			do{
				int i = cursor1.getInt(2);
				if(cursor1.getInt(2) == -1)
				{
					Contact newContact = new Contact(cursor1.getString(0),cursor1.getString(1));
					allContacts.add(newContact);
				}
			}while(cursor1.moveToNext());
			
			return allContacts;
		}
		
	}
	
	public ArrayList<String> getAllEntryNames(){
		ArrayList<String> allContacts = new ArrayList<String>();
		Cursor cursor1 = db.query(true, DATABASE_TABLE,new String[] { KEY_NAME, KEY_TEL},null, null, null, null, null, null);

		
		if((cursor1.getCount() == 0) || !cursor1.moveToFirst())
			return null;
		else
		{
			cursor1.moveToFirst();
			do{
				allContacts.add(cursor1.getString(0));
			}while(cursor1.moveToNext());
			
			return allContacts;
		}
		
	}
	
	public void updateContact (Contact contact)
	{
		db.execSQL("UPDATE "+DATABASE_TABLE+" SET "+KEY_TEL+"=\""+contact.getTel()+"\" WHERE "+KEY_NAME+"="+contact.getName());
		
	}
	
	public void deleteContact (Contact contact) 
	{
		String sql = "DELETE FROM "+DATABASE_TABLE+" WHERE name = '" + contact.getName()+"'";
		db.execSQL(sql);
	}
}
