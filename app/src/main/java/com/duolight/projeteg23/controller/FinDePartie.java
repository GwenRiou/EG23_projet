package com.duolight.projeteg23.controller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.duolight.projeteg23.R;

public class FinDePartie extends AppCompatActivity {


    private static final String SHARED_PREF_JOUEUR_GAGNANT = "SHARED_PREF_JOUEUR_GAGNANT"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_GAGNANT_KEY = "SHARED_PREF_JOUEUR_GAGNANT_KEY"; // Key

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_de_partie);

        textView=findViewById(R.id.FinDePartie_textView);
        int joueurGagnant= getSharedPreferences(SHARED_PREF_JOUEUR_GAGNANT,MODE_PRIVATE).getInt(SHARED_PREF_JOUEUR_GAGNANT_KEY,0);
        if (joueurGagnant==1){
            textView.setTextColor(Color.parseColor("#00D41A"));
        }else{
            textView.setTextColor(Color.parseColor("#F0E93A"));
        }
        textView.setText("Victoire du joueur "+joueurGagnant);

        final Button nouvellePartie = (Button ) findViewById(R.id.FinDePartie_Button_NouevellePartie);
        // Création d’un évènement qui attend un clic sur le bouton
        nouvellePartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                Intent intent = new Intent(FinDePartie.this, ChoixProgramme.class);
                // Exécution de l’activité : ouverture de la fenêtre
                startActivity(intent);
            }
        });

        final Button quitter = (Button ) findViewById(R.id.FinDePartie_Button_Quitter);
        // Création d’un évènement qui attend un clic sur le bouton
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                finish();
                System.exit(0);
            }
        });
    }
}