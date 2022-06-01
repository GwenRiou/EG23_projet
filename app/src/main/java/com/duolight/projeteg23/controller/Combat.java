package com.duolight.projeteg23.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.duolight.projeteg23.R;

public class Combat extends AppCompatActivity {
    private static final String SHARED_PREF_JOUEUR_1_INFO = "SHARED_PREF_JOUEUR_1_INFO"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_1_INFO_KEY = "SHARED_PREF_JOUEUR_1_INFO_KEY"; // Key
    private static final String SHARED_PREF_JOUEUR_GAGNANT = "SHARED_PREF_JOUEUR_GAGNANT"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_GAGNANT_KEY = "SHARED_PREF_JOUEUR_GAGNANT_KEY"; // Key
    private TextView mBranche;

    private ImageView zone1_joueur1_soldat1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

        mBranche=findViewById(R.id.joueur);
        String brancheJoueur1 = getSharedPreferences(SHARED_PREF_JOUEUR_1_INFO,MODE_PRIVATE).getString(SHARED_PREF_JOUEUR_1_INFO_KEY,null);
        mBranche.setText("Joueur 1 : " + brancheJoueur1);


        zone1_joueur1_soldat1 = findViewById(R.id.zone1_joueur1_soldat1);
        zone1_joueur1_soldat1.setVisibility(View.GONE);

        defGagnant(1);
        final TextView titre = (TextView) findViewById(R.id.combat_titre);
        titre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                // Création d’une activité associée à l’exécution de MaGestionListe.class
                Intent intent = new Intent(Combat.this, FinDePartie.class);
                // Exécution de l’activité : ouverture de la fenêtre
                startActivity(intent);
            }
        });
    }
    private void defGagnant(int Gagnant){
        getSharedPreferences(SHARED_PREF_JOUEUR_GAGNANT, MODE_PRIVATE)
                .edit()
                .putInt(SHARED_PREF_JOUEUR_GAGNANT_KEY, Gagnant)// ici le joueur 1 gagne
                .apply();
    }

}