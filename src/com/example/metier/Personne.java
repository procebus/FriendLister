package com.example.metier;

import java.io.Serializable;

public class Personne implements Serializable{
	private String nom;
	private String prenom;
	private int id;
	
	public Personne (String nom, String prenom){
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	public Personne (){
		
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}