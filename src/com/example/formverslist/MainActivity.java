package com.example.formverslist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button btnAjouter;
	private Button btnAfficher;
	private EditText saisieNom;
	private EditText saisiePrenom;
	private Button btnSqlite;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnAjouter = (Button)findViewById(R.id.btn_ajouter);
        btnAfficher = (Button) findViewById(R.id.btn_afficher);
        btnSqlite = (Button) findViewById(R.id.btn_sqlite);
        saisieNom = (EditText) findViewById(R.id.inputTxt_Nom);
        saisiePrenom = (EditText) findViewById(R.id.inputTxt_Prenom);
        
        
        btnAjouter.setOnClickListener(new OnClickListener() {
			
			private AppliText etat;

			@Override
			public void onClick(View arg0) {
				String textevide = "";
				
				if (!saisieNom.getText().equals(textevide) &&  !saisiePrenom.getText().equals(textevide)){
					etat = (AppliText) getApplication();
					etat.ajouterPersonne(saisieNom.getText().toString(), saisiePrenom.getText().toString());
					Toast.makeText(getBaseContext(), "copain ajouté ", Toast.LENGTH_LONG).show();
					saisieNom.setText("");
					saisiePrenom.setText("");
				}else{
					Toast.makeText(getBaseContext(), "les champs ne peuvent être vides", Toast.LENGTH_LONG).show();
				}
				
				
			}
		});
        
        btnAfficher.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent versList = new Intent(MainActivity.this,ListcopainsActivity.class);
				startActivity(versList);
			}
		});
        
        btnSqlite.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent verssqlite = new Intent(MainActivity.this,SQLiteActivity.class);
				startActivity(verssqlite);
			}
		});
        
        
    }
}
