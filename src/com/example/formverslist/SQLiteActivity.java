package com.example.formverslist;

import java.util.ArrayList;

import com.example.metier.ListeBDD;
import com.example.metier.Personne;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SQLiteActivity extends Activity {

	private AppliText etat;
	private ListView listeviewSQLite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite);
		
		
//		Personne copain1 = new Personne("bob","morane");
//		Personne copain2 = new Personne("nana","mouscori");
		
		
		etat  = (AppliText) getApplication();
//		ListeBDD baselisteCopain = new ListeBDD(this);
		ListeBDD baselisteCopain = etat.baselisteCopain;
		baselisteCopain.openForWrite();
//		baselisteCopain.insertCopain(copain1);
//		baselisteCopain.insertCopain(copain2);
		ArrayList<Personne> listePersonne_sqlite = baselisteCopain.getAllCopains();
		baselisteCopain.close();
		
		
		//ArrayList<Personne> listesqlite = etat.affsqlite();
		
		
		
		
		listeviewSQLite = (ListView) findViewById(R.id.lv_Sqlite);
		ArrayAdapter<Personne> adapter = new ArrayAdapter<Personne>(this, android.R.layout.simple_list_item_1, listePersonne_sqlite);
		listeviewSQLite.setAdapter(adapter);
		
	}
}
