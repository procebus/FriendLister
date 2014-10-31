package com.example.formverslist;

import java.util.ArrayList;

import com.example.metier.ListeBDD;
import com.example.metier.ListecopainAdapter;
import com.example.metier.Personne;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class ListcopainsActivity extends Activity {

	private AppliText etat;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listcopains);
		
		
		etat  = (AppliText) getApplication();
		ListeBDD baselisteCopain = etat.baselisteCopain;
		baselisteCopain.openForWrite();
		ArrayList<Personne> listePersonne_sqlite = baselisteCopain.getAllCopains();
		baselisteCopain.close();
		
		//etat  = (AppliText) getApplication();
		final ArrayList<Personne> liste2 = new ArrayList<Personne>();
//		for (Personne copain : etat.listePersonne) {
//			liste2.add(copain);
//		}
		for (Personne copain : listePersonne_sqlite) {
			liste2.add(copain);
		}
		
		
		
		listView = (ListView) findViewById(R.id.listeVcopain);
		ListecopainAdapter adapter = new ListecopainAdapter(this, R.layout.lignecopain, liste2);
		listView.setAdapter(adapter);
		
		
	}
}
