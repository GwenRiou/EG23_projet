package com.duolight.projeteg23.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.duolight.projeteg23.R;

public class Combat extends AppCompatActivity {
    private static final String SHARED_PREF_JOUEUR_1_INFO = "SHARED_PREF_JOUEUR_1_INFO"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_1_INFO_KEY = "SHARED_PREF_JOUEUR_1_INFO_KEY"; // Key
    private static final String SHARED_PREF_JOUEUR_GAGNANT = "SHARED_PREF_JOUEUR_GAGNANT"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_GAGNANT_KEY = "SHARED_PREF_JOUEUR_GAGNANT_KEY"; // Key
    private TextView mBranche;

    private ImageView zone1Soldat0Image;
    private ImageView zone1Soldat1Image;
    private ImageView zone1Soldat2Image;
    private ImageView zone1Soldat3Image;
    private ImageView zone1Soldat4Image;

    private ImageView zone2Soldat0Image;
    private ImageView zone2Soldat1Image;
    private ImageView zone2Soldat2Image;
    private ImageView zone2Soldat3Image;
    private ImageView zone2Soldat4Image;

    private ImageView zone3Soldat0Image;
    private ImageView zone3Soldat1Image;
    private ImageView zone3Soldat2Image;
    private ImageView zone3Soldat3Image;
    private ImageView zone3Soldat4Image;

    private ImageView zone4Soldat0Image;
    private ImageView zone4Soldat1Image;
    private ImageView zone4Soldat2Image;
    private ImageView zone4Soldat3Image;
    private ImageView zone4Soldat4Image;

    private ImageView zone5Soldat0Image;
    private ImageView zone5Soldat1Image;
    private ImageView zone5Soldat2Image;
    private ImageView zone5Soldat3Image;
    private ImageView zone5Soldat4Image;



    private TextView zone1Soldat0Text;
    private TextView zone1Soldat1Text;
    private TextView zone1Soldat2Text;
    private TextView zone1Soldat3Text;
    private TextView zone1Soldat4Text;

    private TextView zone2Soldat0Text;
    private TextView zone2Soldat1Text;
    private TextView zone2Soldat2Text;
    private TextView zone2Soldat3Text;
    private TextView zone2Soldat4Text;

    private TextView zone3Soldat0Text;
    private TextView zone3Soldat1Text;
    private TextView zone3Soldat2Text;
    private TextView zone3Soldat3Text;
    private TextView zone3Soldat4Text;

    private TextView zone4Soldat0Text;
    private TextView zone4Soldat1Text;
    private TextView zone4Soldat2Text;
    private TextView zone4Soldat3Text;
    private TextView zone4Soldat4Text;

    private TextView zone5Soldat0Text;
    private TextView zone5Soldat1Text;
    private TextView zone5Soldat2Text;
    private TextView zone5Soldat3Text;
    private TextView zone5Soldat4Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

       mBranche=findViewById(R.id.joueur);
        String brancheJoueur1 = getSharedPreferences(SHARED_PREF_JOUEUR_1_INFO,MODE_PRIVATE).getString(SHARED_PREF_JOUEUR_1_INFO_KEY,null);
        mBranche.setText("Joueur 1 : " + brancheJoueur1);


        //Recuper les soldats de la page d'avant
        Intent intent = getIntent();
        int []soldatsZone1 = intent.getIntArrayExtra("SOLDATS_ZONE1");
        int []soldatsZone2 = intent.getIntArrayExtra("SOLDATS_ZONE2");
        int []soldatsZone3 = intent.getIntArrayExtra("SOLDATS_ZONE3");
        int []soldatsZone4 = intent.getIntArrayExtra("SOLDATS_ZONE4");
        int []soldatsZone5 = intent.getIntArrayExtra("SOLDATS_ZONE5");

        // lier les images
        zone1Soldat4Image = findViewById(R.id.zone1_soldat4_image);
        zone1Soldat3Image = findViewById(R.id.zone1_soldat3_image);
        zone1Soldat2Image = findViewById(R.id.zone1_soldat2_image);
        zone1Soldat1Image = findViewById(R.id.zone1_soldat1_image);
        zone1Soldat0Image = findViewById(R.id.zone1_soldat0_image);

        zone2Soldat4Image = findViewById(R.id.zone2_soldat4_image);
        zone2Soldat3Image = findViewById(R.id.zone2_soldat3_image);
        zone2Soldat2Image = findViewById(R.id.zone2_soldat2_image);
        zone2Soldat1Image = findViewById(R.id.zone2_soldat1_image);
        zone2Soldat0Image = findViewById(R.id.zone2_soldat0_image);

        zone3Soldat4Image = findViewById(R.id.zone3_soldat4_image);
        zone3Soldat3Image = findViewById(R.id.zone3_soldat3_image);
        zone3Soldat2Image = findViewById(R.id.zone3_soldat2_image);
        zone3Soldat1Image = findViewById(R.id.zone3_soldat1_image);
        zone3Soldat0Image = findViewById(R.id.zone3_soldat0_image);

        zone4Soldat4Image = findViewById(R.id.zone4_soldat4_image);
        zone4Soldat3Image = findViewById(R.id.zone4_soldat3_image);
        zone4Soldat2Image = findViewById(R.id.zone4_soldat2_image);
        zone4Soldat1Image = findViewById(R.id.zone4_soldat1_image);
        zone4Soldat0Image = findViewById(R.id.zone4_soldat0_image);

        zone5Soldat4Image = findViewById(R.id.zone5_soldat4_image);
        zone5Soldat3Image = findViewById(R.id.zone5_soldat3_image);
        zone5Soldat2Image = findViewById(R.id.zone5_soldat2_image);
        zone5Soldat1Image = findViewById(R.id.zone5_soldat1_image);
        zone5Soldat0Image = findViewById(R.id.zone5_soldat0_image);


        //lier les texts
        zone1Soldat0Text = findViewById(R.id.zone1_soldat0_text);
        zone1Soldat1Text = findViewById(R.id.zone1_soldat1_text);
        zone1Soldat2Text = findViewById(R.id.zone1_soldat2_text);
        zone1Soldat3Text = findViewById(R.id.zone1_soldat3_text);
        zone1Soldat4Text = findViewById(R.id.zone1_soldat4_text);

        zone2Soldat0Text = findViewById(R.id.zone2_soldat0_text);
        zone2Soldat1Text = findViewById(R.id.zone2_soldat1_text);
        zone2Soldat2Text = findViewById(R.id.zone2_soldat2_text);
        zone2Soldat3Text = findViewById(R.id.zone2_soldat3_text);
        zone2Soldat4Text = findViewById(R.id.zone2_soldat4_text);

        zone3Soldat0Text = findViewById(R.id.zone3_soldat0_text);
        zone3Soldat1Text = findViewById(R.id.zone3_soldat1_text);
        zone3Soldat2Text = findViewById(R.id.zone3_soldat2_text);
        zone3Soldat3Text = findViewById(R.id.zone3_soldat3_text);
        zone3Soldat4Text = findViewById(R.id.zone3_soldat4_text);

        zone4Soldat0Text = findViewById(R.id.zone4_soldat0_text);
        zone4Soldat1Text = findViewById(R.id.zone4_soldat1_text);
        zone4Soldat2Text = findViewById(R.id.zone4_soldat2_text);
        zone4Soldat3Text = findViewById(R.id.zone4_soldat3_text);
        zone4Soldat4Text = findViewById(R.id.zone4_soldat4_text);

        zone5Soldat0Text = findViewById(R.id.zone5_soldat0_text);
        zone5Soldat1Text = findViewById(R.id.zone5_soldat1_text);
        zone5Soldat2Text = findViewById(R.id.zone5_soldat2_text);
        zone5Soldat3Text = findViewById(R.id.zone5_soldat3_text);
        zone5Soldat4Text = findViewById(R.id.zone5_soldat4_text);


        Toast.makeText(this, "Nb de chef de geurre dans la zone 1 :  " + soldatsZone1[0], Toast.LENGTH_SHORT).show();

        //Affichage Zone 1
        if (soldatsZone1[0]==0) {
            zone1Soldat0Image.setVisibility(View.GONE);
            zone1Soldat0Text.setVisibility(View.GONE);
        }else{
            zone1Soldat0Text.setText(""+soldatsZone1[0]);
        }
        if (soldatsZone1[1]==0) {
            zone1Soldat1Image.setVisibility(View.GONE);
            zone1Soldat1Text.setVisibility(View.GONE);
        }else{
            zone1Soldat1Text.setText(""+soldatsZone1[1]);
        }
        if (soldatsZone1[2]==0) {
            zone1Soldat2Image.setVisibility(View.GONE);
            zone1Soldat2Text.setVisibility(View.GONE);
        }else{
            zone1Soldat2Text.setText(""+soldatsZone1[2]);
        }
        if (soldatsZone1[3]==0) {
            zone1Soldat3Image.setVisibility(View.GONE);
            zone1Soldat3Text.setVisibility(View.GONE);
        }else{
            zone1Soldat3Text.setText(""+soldatsZone1[3]);
        }
        if (soldatsZone1[4]==0) {
            zone1Soldat4Image.setVisibility(View.GONE);
            zone1Soldat4Text.setVisibility(View.GONE);
        }else{
            zone1Soldat4Text.setText(""+soldatsZone1[4]);
        }
        //Affichage Zone 2
        if (soldatsZone2[0]==0) {
            zone2Soldat0Image.setVisibility(View.GONE);
            zone2Soldat0Text.setVisibility(View.GONE);
        }else{
            zone2Soldat0Text.setText(""+soldatsZone2[0]);
        }
        if (soldatsZone2[1]==0) {
            zone2Soldat1Image.setVisibility(View.GONE);
            zone2Soldat1Text.setVisibility(View.GONE);
        }else{
            zone2Soldat1Text.setText(""+soldatsZone2[1]);
        }
        if (soldatsZone2[2]==0) {
            zone2Soldat2Image.setVisibility(View.GONE);
            zone2Soldat2Text.setVisibility(View.GONE);
        }else{
            zone2Soldat2Text.setText(""+soldatsZone2[2]);
        }
        if (soldatsZone2[3]==0) {
            zone2Soldat3Image.setVisibility(View.GONE);
            zone2Soldat3Text.setVisibility(View.GONE);
        }else{
            zone2Soldat3Text.setText(""+soldatsZone2[3]);
        }
        if (soldatsZone2[4]==0) {
            zone2Soldat4Image.setVisibility(View.GONE);
            zone2Soldat4Text.setVisibility(View.GONE);
        }else{
            zone2Soldat4Text.setText(""+soldatsZone2[4]);
        }

        //Affichage Zone3
        if (soldatsZone3[0]==0) {
            zone3Soldat0Image.setVisibility(View.GONE);
            zone3Soldat0Text.setVisibility(View.GONE);
        }else{
            zone3Soldat0Text.setText(""+soldatsZone3[0]);
        }
        if (soldatsZone3[1]==0) {
            zone3Soldat1Image.setVisibility(View.GONE);
            zone3Soldat1Text.setVisibility(View.GONE);
        }else{
            zone3Soldat1Text.setText(""+soldatsZone3[1]);
        }
        if (soldatsZone3[2]==0) {
            zone3Soldat2Image.setVisibility(View.GONE);
            zone3Soldat2Text.setVisibility(View.GONE);
        }else{
            zone3Soldat2Text.setText(""+soldatsZone3[2]);
        }
        if (soldatsZone3[3]==0) {
            zone3Soldat3Image.setVisibility(View.GONE);
            zone3Soldat3Text.setVisibility(View.GONE);
        }else{
            zone3Soldat3Text.setText(""+soldatsZone3[3]);
        }
        if (soldatsZone3[4]==0) {
            zone3Soldat4Image.setVisibility(View.GONE);
            zone3Soldat4Text.setVisibility(View.GONE);
        }else{
            zone3Soldat4Text.setText(""+soldatsZone3[4]);
        }

        //Affichage Zone4
        if (soldatsZone4[0]==0) {
            zone4Soldat0Image.setVisibility(View.GONE);
            zone4Soldat0Text.setVisibility(View.GONE);
        }else{
            zone4Soldat0Text.setText(""+soldatsZone4[0]);
        }
        if (soldatsZone4[1]==0) {
            zone4Soldat1Image.setVisibility(View.GONE);
            zone4Soldat1Text.setVisibility(View.GONE);
        }else{
            zone4Soldat1Text.setText(""+soldatsZone4[1]);
        }
        if (soldatsZone4[2]==0) {
            zone4Soldat2Image.setVisibility(View.GONE);
            zone4Soldat2Text.setVisibility(View.GONE);
        }else{
            zone4Soldat2Text.setText(""+soldatsZone4[2]);
        }
        if (soldatsZone4[3]==0) {
            zone4Soldat3Image.setVisibility(View.GONE);
            zone4Soldat3Text.setVisibility(View.GONE);
        }else{
            zone4Soldat3Text.setText(""+soldatsZone4[3]);
        }
        if (soldatsZone4[4]==0) {
            zone4Soldat4Image.setVisibility(View.GONE);
            zone4Soldat4Text.setVisibility(View.GONE);
        }else{
            zone4Soldat4Text.setText(""+soldatsZone4[4]);
        }

        //Affichage Zone5
        if (soldatsZone5[0]==0) {
            zone5Soldat0Image.setVisibility(View.GONE);
            zone5Soldat0Text.setVisibility(View.GONE);
        }else{
            zone5Soldat0Text.setText(""+soldatsZone5[0]);
        }
        if (soldatsZone5[1]==0) {
            zone5Soldat1Image.setVisibility(View.GONE);
            zone5Soldat1Text.setVisibility(View.GONE);
        }else{
            zone5Soldat1Text.setText(""+soldatsZone5[1]);
        }
        if (soldatsZone5[2]==0) {
            zone5Soldat2Image.setVisibility(View.GONE);
            zone5Soldat2Text.setVisibility(View.GONE);
        }else{
            zone5Soldat2Text.setText(""+soldatsZone5[2]);
        }
        if (soldatsZone5[3]==0) {
            zone5Soldat3Image.setVisibility(View.GONE);
            zone5Soldat3Text.setVisibility(View.GONE);
        }else{
            zone5Soldat3Text.setText(""+soldatsZone5[3]);
        }
        if (soldatsZone5[4]==0) {
            zone5Soldat4Image.setVisibility(View.GONE);
            zone5Soldat4Text.setVisibility(View.GONE);
        }else{
            zone5Soldat4Text.setText(""+soldatsZone5[4]);
        }






        //defGagnant(1);
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