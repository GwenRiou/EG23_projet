package com.duolight.projeteg23.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.duolight.projeteg23.R;


public class ChoixProgramme extends AppCompatActivity implements View.OnClickListener {

    private static final String SHARED_PREF_JOUEUR_1_INFO = "SHARED_PREF_JOUEUR_1_INFO"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_1_INFO_KEY = "SHARED_PREF_JOUEUR_1_INFO_KEY";//Key
    private static final String SHARED_PREF_JOUEUR_2_INFO = "SHARED_PREF_JOUEUR_2_INFO"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_2_INFO_KEY = "SHARED_PREF_JOUEUR_2_INFO_KEY";//Key
    private TextView mChoixTextView;
    private Button mChoixButton1;
    private Button mChoixButton2;
    private Button mChoixButton3;
    private Button mChoixButton4;
    private Button mChoixButton5;
    private Button mChoixButton6;
    private Button mChoixButton7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_programme);

        mChoixTextView = findViewById(R.id.choix_programme_textview);
        mChoixButton1 = findViewById(R.id.choix_programme_button_1);
        mChoixButton2 = findViewById(R.id.choix_programme_button_2);
        mChoixButton3 = findViewById(R.id.choix_programme_button_3);
        mChoixButton4 = findViewById(R.id.choix_programme_button_4);
        mChoixButton5 = findViewById(R.id.choix_programme_button_5);
        mChoixButton6 = findViewById(R.id.choix_programme_button_6);
        mChoixButton7 = findViewById(R.id.choix_programme_button_7);


        // Use the same listener for the four buttons.
        // The view id value will be used to distinguish the button triggered
        mChoixButton1.setOnClickListener(this);
        mChoixButton2.setOnClickListener(this);
        mChoixButton3.setOnClickListener(this);
        mChoixButton4.setOnClickListener(this);
        mChoixButton5.setOnClickListener(this);
        mChoixButton6.setOnClickListener(this);
        mChoixButton7.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mChoixButton1) {
            sharedPref(SHARED_PREF_JOUEUR_1_INFO,SHARED_PREF_JOUEUR_1_INFO_KEY,"ISI");
        } else if (v == mChoixButton2) {
            sharedPref(SHARED_PREF_JOUEUR_1_INFO,SHARED_PREF_JOUEUR_1_INFO_KEY,"GM");
        } else if (v == mChoixButton3) {
            sharedPref(SHARED_PREF_JOUEUR_1_INFO,SHARED_PREF_JOUEUR_1_INFO_KEY,"GI");
        } else if (v == mChoixButton4) {
            sharedPref(SHARED_PREF_JOUEUR_1_INFO,SHARED_PREF_JOUEUR_1_INFO_KEY,"MTE");
        } else if (v == mChoixButton5) {
            sharedPref(SHARED_PREF_JOUEUR_1_INFO,SHARED_PREF_JOUEUR_1_INFO_KEY,"RT");
        }else if (v == mChoixButton6) {
            sharedPref(SHARED_PREF_JOUEUR_1_INFO,SHARED_PREF_JOUEUR_1_INFO_KEY,"MM");
        }else if (v == mChoixButton7) {
            sharedPref(SHARED_PREF_JOUEUR_1_INFO,SHARED_PREF_JOUEUR_1_INFO_KEY,"A2I");
        }
        else {
            throw new IllegalStateException("Unknown clicked view : " + v);
        }
        //check si joueur 2 à a choisit sa branche ;
        pageSuivante();
    }

    public void sharedPref (String nomFichier, String key,String branche){
        getSharedPreferences(nomFichier, MODE_PRIVATE)
                .edit()
                .putString(key, branche)
                .apply();
    }
    public void pageSuivante(){
        // Création d’une activité associée à l’exécution de MaGestionListe.class
        //Intent intent = new Intent(ChoixProgramme.this, RepartitionPoints.class);
        Intent intent = new Intent(ChoixProgramme.this, DeploiementArmee.class);
        // Exécution de l’activité : ouverture de la fenêtre
        startActivity(intent);
    }
}