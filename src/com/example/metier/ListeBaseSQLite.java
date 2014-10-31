package com.example.metier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ListeBaseSQLite extends SQLiteOpenHelper{

	private static final String TABLE_COPAINS ="table_copains";
	private static final String COL_ID = "Id";
	private static final String COL_NOM = "Nom";
	private static final String COL_PRENOM = "Prenom";
	private static final String CREATE_DB = "create table " + TABLE_COPAINS 
											+ " (" +COL_ID +" integer primary key autoincrement,"
											+ " " + COL_NOM +" text not null," 
											+ COL_PRENOM + " text not null);";
	
	public ListeBaseSQLite(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("drop table if exists "+TABLE_COPAINS );
		db.execSQL(CREATE_DB);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table "+TABLE_COPAINS);
		onCreate(db);
		
	}

}
