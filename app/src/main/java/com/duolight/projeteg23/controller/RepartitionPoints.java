package com.duolight.projeteg23.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duolight.projeteg23.R;

public class RepartitionPoints extends AppCompatActivity {

    private static final String SHARED_PREF_JOUEUR_1_INFO = "SHARED_PREF_JOUEUR_1_INFO"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_1_INFO_KEY = "SHARED_PREF_JOUEUR_1_INFO_KEY"; // Key
    private TextView mBranche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repartition_points);
        //test

        mBranche=findViewById(R.id.repartition_points_joueur_branche);
        String brancheJoueur1 = getSharedPreferences(SHARED_PREF_JOUEUR_1_INFO,MODE_PRIVATE).getString(SHARED_PREF_JOUEUR_1_INFO_KEY,null);
        mBranche.setText("Joueur 1 : " + brancheJoueur1);

        // Liaison entre l’objet graphique R.id.button et la variable listeCourseButton
        final LinearLayout mLayoutChefDeGuerre = (LinearLayout ) findViewById(R.id.repartition_points_chef_de_guerre_layout);
        // Création d’un évènement qui attend un clic sur le bouton
        mLayoutChefDeGuerre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //Appelle une pop-up
                myCustomAlertDialog();
            }
        });
    }
    private void myCustomAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View popUpView = getLayoutInflater().inflate(R.layout.popup, null);
        builder.setView(popUpView);
        builder.create();
        builder.show();
    }
}