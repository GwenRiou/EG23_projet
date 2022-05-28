package com.duolight.projeteg23.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.duolight.projeteg23.R;

public class DeploiementArmee extends AppCompatActivity implements View.OnClickListener {
    private static final String SHARED_PREF_JOUEUR_1_INFO = "SHARED_PREF_JOUEUR_1_INFO"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_1_INFO_KEY = "SHARED_PREF_JOUEUR_1_INFO_KEY"; // Key
    private TextView mBranche;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deploiement_armee);

        mBranche=findViewById(R.id.joueur1);
        String brancheJoueur1 = getSharedPreferences(SHARED_PREF_JOUEUR_1_INFO,MODE_PRIVATE).getString(SHARED_PREF_JOUEUR_1_INFO_KEY,null);
        mBranche.setText("Joueur 1 : " + brancheJoueur1);

        next = findViewById(R.id.nextButton);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == next) {
            pageSuivante();
        }
        else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }
    }

    public void pageSuivante() {
        // Création d’une activité associée à l’exécution de MaGestionListe.class
        Intent intent = new Intent(DeploiementArmee.this, Reserve.class);
        // Exécution de l’activité : ouverture de la fenêtre
        startActivity(intent);
    }
}