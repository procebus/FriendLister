package com.example.metier;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ListeBDD {
	
	private static final int version = 1;
	private static final String NOM_BDD= "copains.db";
	
	private static final String TABLE_COPAINS = "table_copains";
	private static final String COL_ID = "Id";
	private static final int NUM_COL_ID =0;
	private static final String COL_NOM = "Nom";
	private static final int NUM_COL_NOM =1;
	private static final String COL_PRENOM = "Prenom";
	private static final int NUM_COL_PRENOM =2;
	
	private SQLiteDatabase bdd;
	private ListeBaseSQLite listCopains_sqliteopenhelper;
	
	public ListeBDD(Context context){
		listCopains_sqliteopenhelper = new ListeBaseSQLite(context, NOM_BDD, null, version);
	}
	public void openForWrite(){
		bdd = listCopains_sqliteopenhelper.getWritableDatabase();
	}
	public void openForRead(){
		bdd =listCopains_sqliteopenhelper.getReadableDatabase();
	}
	public void close(){
		bdd.close();
	}
	public SQLiteDatabase getBdd(){
		return bdd;
	}
	
	public long insertCopain(Personne copain){
		ContentValues content = new ContentValues();
		content.put(COL_NOM, copain.getNom());
		content.put(COL_PRENOM, copain.getPrenom());
		return bdd.insert(TABLE_COPAINS, null, content);
		
	}
	public int updateCopain(int id,Personne copain){
		ContentValues content = new ContentValues();
		content.put(COL_NOM, copain.getNom());
		content.put(COL_PRENOM, copain.getPrenom());
		return bdd.update(TABLE_COPAINS,content,COL_ID+" = "+id, null);
	}
		
	public int removeCopain(String nom, String prenom){
		return bdd.delete(TABLE_COPAINS, COL_NOM + " = "+ nom +" AND "+ COL_PRENOM + " = " + prenom, null);
	}
	
	
	public Personne cursorToCopain(Cursor c){
		
		if (c.getCount() == 0){
			c.close();
			return null;
		}
		Personne copain = new Personne();
		copain.setId(c.getInt(NUM_COL_ID));
		copain.setNom(c.getString(NUM_COL_NOM));
		copain.setPrenom(c.getString(NUM_COL_PRENOM));
		c.close();
		return copain;
	}
	
	
	
	public Personne getCopain(String nom, String prenom){
		Cursor c = bdd.query(TABLE_COPAINS, 
							new String[]{COL_ID, COL_NOM,COL_PRENOM }, 
							COL_NOM + " = "+ nom +" AND "+ COL_PRENOM + " = " + prenom, 
							null, null,null,COL_PRENOM);
		return cursorToCopain(c);
		
	}
	public ArrayList<Personne> getAllCopains(){
		
		Cursor c = bdd.query(TABLE_COPAINS, new String[]{COL_ID, COL_NOM,COL_PRENOM }, null, null, null, null, COL_PRENOM);
		if(c.getCount() == 0){
			c.close();
			return null;
		}
		
		ArrayList<Personne> listCopain = new ArrayList<Personne>();
		while(c.moveToNext()){
			Personne copain = new Personne();
			copain.setId(c.getInt(NUM_COL_ID));
			copain.setNom(c.getString(NUM_COL_NOM));
			copain.setPrenom(c.getString(NUM_COL_PRENOM));
			listCopain.add(copain);
		}
		c.close();
		return listCopain;
	}
	
	
	

}
