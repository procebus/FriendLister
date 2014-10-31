package com.example.metier;

import java.util.ArrayList;

import com.example.formverslist.R;
import com.example.formverslist.R.id;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListecopainAdapter extends ArrayAdapter<Personne>{

	private ArrayList<Personne> listeCopain;
	private Context context;
	private int viewres;
	private TextView txtvue_nom;
	private TextView txtvue_prenom;

	public ListecopainAdapter(Context context, int textViewResourceId,ArrayList<Personne> listeCopain) {
		super(context, textViewResourceId, listeCopain);
		this.listeCopain = listeCopain;
		this.viewres = textViewResourceId;
		this.context = context;

	}
	@Override
	public View getView (int position , View convertView , ViewGroup parent ){
		View v = convertView;
		LayoutInflater inflater = LayoutInflater.from(context);
		v = inflater.inflate(viewres, parent, false);
		txtvue_nom = (TextView) v.findViewById(R.id.txt_nomCopain);
		txtvue_prenom = (TextView)v.findViewById(R.id.txt_PrenomCopain);
		txtvue_prenom.setText(listeCopain.get(position).getPrenom());
		txtvue_nom.setText(listeCopain.get(position).getNom());
		Log.i("maliste",txtvue_prenom.getText() + " " + txtvue_prenom.getText());
		
		
		
		return v;
		
	}
	

}
