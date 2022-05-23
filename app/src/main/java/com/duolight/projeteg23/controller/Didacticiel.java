package com.duolight.projeteg23.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.duolight.projeteg23.R;

public class Didacticiel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_didacticiel);

        final TextView croix = (TextView) findViewById(R.id.didacticiel_croix);
        croix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                // Création d’une activité associée à l’exécution de MaGestionListe.class
                Intent intent = new Intent(Didacticiel.this, MainActivity.class);
                // Exécution de l’activité : ouverture de la fenêtre
                startActivity(intent);
            }
        });
        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                pageSuivanteDidacticiel();
            }
        });

        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                pageSuivanteDidacticiel();
            }
        });
    }
    public void pageSuivanteDidacticiel(){
        // Création d’une activité associée à l’exécution de MaGestionListe.class
        Intent intent = new Intent(Didacticiel.this, Didacticiel_2.class);
        // Exécution de l’activité : ouverture de la fenêtre
        startActivity(intent);
    }
}