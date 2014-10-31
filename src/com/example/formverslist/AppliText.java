package com.example.formverslist;

import java.util.ArrayList;

import com.example.metier.ListeBDD;
import com.example.metier.Personne;

import android.app.Application;




public class AppliText extends Application{
	ArrayList<Personne> listePersonne = new ArrayList<Personne>();
	ListeBDD baselisteCopain = new ListeBDD(this); 
	
	public ArrayList<Personne> affsqlite(){
		baselisteCopain.openForRead();
		ArrayList<Personne> listePersonne_sqlite = baselisteCopain.getAllCopains();
		baselisteCopain.close();
		return listePersonne_sqlite;
		
	};
	
	
	public void ajouterPersonne(String nom,String prenom){
		Personne copain = new Personne(nom, prenom);
		listePersonne.add(copain);
		
		ListeBDD baselisteCopain = new ListeBDD(this); 
		baselisteCopain.openForWrite();
		baselisteCopain.insertCopain(copain);
		baselisteCopain.close();
		
	}

}
