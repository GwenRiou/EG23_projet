package com.duolight.projeteg23.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.duolight.projeteg23.R;

public class Combat extends AppCompatActivity {
    private static final String SHARED_PREF_JOUEUR_1_INFO = "SHARED_PREF_JOUEUR_1_INFO"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_1_INFO_KEY = "SHARED_PREF_JOUEUR_1_INFO_KEY"; // Key
    private static final String SHARED_PREF_JOUEUR_GAGNANT = "SHARED_PREF_JOUEUR_GAGNANT"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_GAGNANT_KEY = "SHARED_PREF_JOUEUR_GAGNANT_KEY"; // Key

    private static final String SHARED_PREF_NOMBRE_DE_TOUR = "SHARED_PREF_NOMBRE_DE_TOUR"; // nom du fichier
    private static final String SHARED_PREF_NOMBRE_DE_TOUR_KEY = "SHARED_PREF_NOMBRE_DE_TOUR_KEY"; // Key

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

    //soldats du joueur2
    private ImageView zone1Soldat0Joueur2Image;
    private ImageView zone1Soldat1Joueur2Image;
    private ImageView zone1Soldat3Joueur2Image;
    private ImageView zone1Soldat4Joueur2Image;

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

    //soldats du joueur2
    private TextView zone1Soldat0Joueur2Text;
    private TextView zone1Soldat1Joueur2Text;
    private TextView zone1Soldat3Joueur2Text;
    private TextView zone1Soldat4Joueur2Text;

    private LinearLayout zone1;
    private LinearLayout zone2;
    private LinearLayout zone3;
    private LinearLayout zone4;
    private LinearLayout zone5;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combat);

       mBranche=findViewById(R.id.joueur);
        String brancheJoueur1 = getSharedPreferences(SHARED_PREF_JOUEUR_1_INFO,MODE_PRIVATE).getString(SHARED_PREF_JOUEUR_1_INFO_KEY,null);
        mBranche.setText("Joueur 1 : " + brancheJoueur1);

        //Ajoute un tour
        /*int tour = getSharedPreferences(SHARED_PREF_NOMBRE_DE_TOUR,MODE_PRIVATE).getInt(SHARED_PREF_NOMBRE_DE_TOUR_KEY,0);
        tour++;
        getSharedPreferences(SHARED_PREF_NOMBRE_DE_TOUR, MODE_PRIVATE)
                .edit()
                .putInt("SHARED_PREF_NOMBRE_DE_TOUR_KEY", tour)
                .apply();*/

        //Recuper les soldats de la page d'avant
        Intent intent = getIntent();
        int []soldatsZone1 = intent.getIntArrayExtra("SOLDATS_ZONE1");
        int []soldatsZone2 = intent.getIntArrayExtra("SOLDATS_ZONE2");
        int []soldatsZone3 = intent.getIntArrayExtra("SOLDATS_ZONE3");
        int []soldatsZone4 = intent.getIntArrayExtra("SOLDATS_ZONE4");
        int []soldatsZone5 = intent.getIntArrayExtra("SOLDATS_ZONE5");

        int[]controleZone = intent.getIntArrayExtra("CONTROLE_ZONE");

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

        //Lier les layouts des zones
        zone1 = findViewById(R.id.combat_zone1);
        zone2 = findViewById(R.id.combat_zone2);
        zone3 = findViewById(R.id.combat_zone3);
        zone4 = findViewById(R.id.combat_zone4);
        zone5 = findViewById(R.id.combat_zone5);

        Drawable dZone1 = getResources().getDrawable(R.drawable.zone_combat);
        Drawable dZone2 = getResources().getDrawable(R.drawable.zone_combat);
        Drawable dZone3 = getResources().getDrawable(R.drawable.zone_combat);
        Drawable dZone4 = getResources().getDrawable(R.drawable.zone_combat);
        Drawable dZone5 = getResources().getDrawable(R.drawable.zone_combat);


        //Affichage Zone 1
        if (controleZone[1]!=2) {
            if (soldatsZone1[0] == 0) {
                zone1Soldat0Image.setVisibility(View.GONE);
                zone1Soldat0Text.setVisibility(View.GONE);
            } else {
                zone1Soldat0Text.setText("" + soldatsZone1[0]);
            }
            if (soldatsZone1[1] == 0) {
                zone1Soldat1Image.setVisibility(View.GONE);
                zone1Soldat1Text.setVisibility(View.GONE);
            } else {
                zone1Soldat1Text.setText("" + soldatsZone1[1]);
            }
            if (soldatsZone1[2] == 0) {
                zone1Soldat2Image.setVisibility(View.GONE);
                zone1Soldat2Text.setVisibility(View.GONE);
            } else {
                zone1Soldat2Text.setText("" + soldatsZone1[2]);
            }
            if (soldatsZone1[3] == 0) {
                zone1Soldat3Image.setVisibility(View.GONE);
                zone1Soldat3Text.setVisibility(View.GONE);
            } else {
                zone1Soldat3Text.setText("" + soldatsZone1[3]);
            }
            if (soldatsZone1[4] == 0) {
                zone1Soldat4Image.setVisibility(View.GONE);
                zone1Soldat4Text.setVisibility(View.GONE);
            } else {
                zone1Soldat4Text.setText("" + soldatsZone1[4]);
            }
        }else{
            zone1Soldat0Image.setVisibility(View.GONE);
            zone1Soldat0Text.setVisibility(View.GONE);
            zone1Soldat1Image.setVisibility(View.GONE);
            zone1Soldat1Text.setVisibility(View.GONE);
            zone1Soldat2Image.setVisibility(View.GONE);
            zone1Soldat2Text.setVisibility(View.GONE);
            zone1Soldat3Image.setVisibility(View.GONE);
            zone1Soldat3Text.setVisibility(View.GONE);
            zone1Soldat4Image.setVisibility(View.GONE);
            zone1Soldat4Text.setVisibility(View.GONE);

            dZone1.setColorFilter( Color.parseColor("#F0E93A"), PorterDuff.Mode.SRC_ATOP);
            zone1.setBackground(dZone1);
        }
        if (controleZone[1]==1){
            dZone1.setColorFilter( Color.parseColor("#00D41A"), PorterDuff.Mode.SRC_ATOP);
            zone1.setBackground(dZone1);
        }
        //Affichage Zone 2

        if (controleZone[2]!=2) {
            if (soldatsZone2[0] == 0) {
                zone2Soldat0Image.setVisibility(View.GONE);
                zone2Soldat0Text.setVisibility(View.GONE);
            } else {
                zone2Soldat0Text.setText("" + soldatsZone2[0]);
            }
            if (soldatsZone2[1] == 0) {
                zone2Soldat1Image.setVisibility(View.GONE);
                zone2Soldat1Text.setVisibility(View.GONE);
            } else {
                zone2Soldat1Text.setText("" + soldatsZone2[1]);
            }
            if (soldatsZone2[2] == 0) {
                zone2Soldat2Image.setVisibility(View.GONE);
                zone2Soldat2Text.setVisibility(View.GONE);
            } else {
                zone2Soldat2Text.setText("" + soldatsZone2[2]);
            }
            if (soldatsZone2[3] == 0) {
                zone2Soldat3Image.setVisibility(View.GONE);
                zone2Soldat3Text.setVisibility(View.GONE);
            } else {
                zone2Soldat3Text.setText("" + soldatsZone2[3]);
            }
            if (soldatsZone2[4] == 0) {
                zone2Soldat4Image.setVisibility(View.GONE);
                zone2Soldat4Text.setVisibility(View.GONE);
            } else {
                zone2Soldat4Text.setText("" + soldatsZone2[4]);
            }
        }else{
            zone2Soldat0Image.setVisibility(View.GONE);
            zone2Soldat0Text.setVisibility(View.GONE);
            zone2Soldat1Image.setVisibility(View.GONE);
            zone2Soldat1Text.setVisibility(View.GONE);
            zone2Soldat2Image.setVisibility(View.GONE);
            zone2Soldat2Text.setVisibility(View.GONE);
            zone2Soldat3Image.setVisibility(View.GONE);
            zone2Soldat3Text.setVisibility(View.GONE);
            zone2Soldat4Image.setVisibility(View.GONE);
            zone2Soldat4Text.setVisibility(View.GONE);
            dZone2.setColorFilter( Color.parseColor("#F0E93A"), PorterDuff.Mode.SRC_ATOP);
            zone2.setBackground(dZone2);
        }
        if (controleZone[2]==1){
            dZone2.setColorFilter( Color.parseColor("#00D41A"), PorterDuff.Mode.SRC_ATOP);
            zone2.setBackground(dZone2);
        }
        //Affichage Zone3
        if(controleZone[3]!=2) {
            if (soldatsZone3[0] == 0) {
                zone3Soldat0Image.setVisibility(View.GONE);
                zone3Soldat0Text.setVisibility(View.GONE);
            } else {
                zone3Soldat0Text.setText("" + soldatsZone3[0]);
            }
            if (soldatsZone3[1] == 0) {
                zone3Soldat1Image.setVisibility(View.GONE);
                zone3Soldat1Text.setVisibility(View.GONE);
            } else {
                zone3Soldat1Text.setText("" + soldatsZone3[1]);
            }
            if (soldatsZone3[2] == 0) {
                zone3Soldat2Image.setVisibility(View.GONE);
                zone3Soldat2Text.setVisibility(View.GONE);
            } else {
                zone3Soldat2Text.setText("" + soldatsZone3[2]);
            }
            if (soldatsZone3[3] == 0) {
                zone3Soldat3Image.setVisibility(View.GONE);
                zone3Soldat3Text.setVisibility(View.GONE);
            } else {
                zone3Soldat3Text.setText("" + soldatsZone3[3]);
            }
            if (soldatsZone3[4] == 0) {
                zone3Soldat4Image.setVisibility(View.GONE);
                zone3Soldat4Text.setVisibility(View.GONE);
            } else {
                zone3Soldat4Text.setText("" + soldatsZone3[4]);
            }
        }else{
            zone3Soldat0Image.setVisibility(View.GONE);
            zone3Soldat0Text.setVisibility(View.GONE);
            zone3Soldat1Image.setVisibility(View.GONE);
            zone3Soldat1Text.setVisibility(View.GONE);
            zone3Soldat2Image.setVisibility(View.GONE);
            zone3Soldat2Text.setVisibility(View.GONE);
            zone3Soldat3Image.setVisibility(View.GONE);
            zone3Soldat3Text.setVisibility(View.GONE);
            zone3Soldat4Image.setVisibility(View.GONE);
            zone3Soldat4Text.setVisibility(View.GONE);

            dZone3.setColorFilter( Color.parseColor("#F0E93A"), PorterDuff.Mode.SRC_ATOP);
            zone3.setBackground(dZone1);
        }
        if (controleZone[3]==1){
            dZone3.setColorFilter( Color.parseColor("#00D41A"), PorterDuff.Mode.SRC_ATOP);
            zone3.setBackground(dZone3);
        }

        //Affichage Zone4
        if(controleZone[4]!=2) {
            if (soldatsZone4[0] == 0) {
                zone4Soldat0Image.setVisibility(View.GONE);
                zone4Soldat0Text.setVisibility(View.GONE);
            } else {
                zone4Soldat0Text.setText("" + soldatsZone4[0]);
            }
            if (soldatsZone4[1] == 0) {
                zone4Soldat1Image.setVisibility(View.GONE);
                zone4Soldat1Text.setVisibility(View.GONE);
            } else {
                zone4Soldat1Text.setText("" + soldatsZone4[1]);
            }
            if (soldatsZone4[2] == 0) {
                zone4Soldat2Image.setVisibility(View.GONE);
                zone4Soldat2Text.setVisibility(View.GONE);
            } else {
                zone4Soldat2Text.setText("" + soldatsZone4[2]);
            }
            if (soldatsZone4[3] == 0) {
                zone4Soldat3Image.setVisibility(View.GONE);
                zone4Soldat3Text.setVisibility(View.GONE);
            } else {
                zone4Soldat3Text.setText("" + soldatsZone4[3]);
            }
            if (soldatsZone4[4] == 0) {
                zone4Soldat4Image.setVisibility(View.GONE);
                zone4Soldat4Text.setVisibility(View.GONE);
            } else {
                zone4Soldat4Text.setText("" + soldatsZone4[4]);
            }
        }else{
            zone4Soldat0Image.setVisibility(View.GONE);
            zone4Soldat0Text.setVisibility(View.GONE);
            zone4Soldat1Image.setVisibility(View.GONE);
            zone4Soldat1Text.setVisibility(View.GONE);
            zone4Soldat2Image.setVisibility(View.GONE);
            zone4Soldat2Text.setVisibility(View.GONE);
            zone4Soldat3Image.setVisibility(View.GONE);
            zone4Soldat3Text.setVisibility(View.GONE);
            zone4Soldat4Image.setVisibility(View.GONE);
            zone4Soldat4Text.setVisibility(View.GONE);

            dZone4.setColorFilter( Color.parseColor("#F0E93A"), PorterDuff.Mode.SRC_ATOP);
            zone4.setBackground(dZone1);
        }
        if (controleZone[4]==1) {
            dZone4.setColorFilter(Color.parseColor("#00D41A"), PorterDuff.Mode.SRC_ATOP);
            zone4.setBackground(dZone4);
        }

        //Affichage Zone5
        if(controleZone[5]!=2) {
            if (soldatsZone5[0] == 0) {
                zone5Soldat0Image.setVisibility(View.GONE);
                zone5Soldat0Text.setVisibility(View.GONE);
            } else {
                zone5Soldat0Text.setText("" + soldatsZone5[0]);
            }
            if (soldatsZone5[1] == 0) {
                zone5Soldat1Image.setVisibility(View.GONE);
                zone5Soldat1Text.setVisibility(View.GONE);
            } else {
                zone5Soldat1Text.setText("" + soldatsZone5[1]);
            }
            if (soldatsZone5[2] == 0) {
                zone5Soldat2Image.setVisibility(View.GONE);
                zone5Soldat2Text.setVisibility(View.GONE);
            } else {
                zone5Soldat2Text.setText("" + soldatsZone5[2]);
            }
            if (soldatsZone5[3] == 0) {
                zone5Soldat3Image.setVisibility(View.GONE);
                zone5Soldat3Text.setVisibility(View.GONE);
            } else {
                zone5Soldat3Text.setText("" + soldatsZone5[3]);
            }
            if (soldatsZone5[4] == 0) {
                zone5Soldat4Image.setVisibility(View.GONE);
                zone5Soldat4Text.setVisibility(View.GONE);
            } else {
                zone5Soldat4Text.setText("" + soldatsZone5[4]);
            }
        }else{
            zone5Soldat0Image.setVisibility(View.GONE);
            zone5Soldat0Text.setVisibility(View.GONE);
            zone5Soldat1Image.setVisibility(View.GONE);
            zone5Soldat1Text.setVisibility(View.GONE);
            zone5Soldat2Image.setVisibility(View.GONE);
            zone5Soldat2Text.setVisibility(View.GONE);
            zone5Soldat3Image.setVisibility(View.GONE);
            zone5Soldat3Text.setVisibility(View.GONE);
            zone5Soldat4Image.setVisibility(View.GONE);
            zone5Soldat4Text.setVisibility(View.GONE);

            dZone5.setColorFilter( Color.parseColor("#F0E93A"), PorterDuff.Mode.SRC_ATOP);
            zone5.setBackground(dZone1);
        }
        if (controleZone[5]==1){
            dZone5.setColorFilter( Color.parseColor("#00D41A"), PorterDuff.Mode.SRC_ATOP);
            zone5.setBackground(dZone5);
            //faire disparaitre les  soldats du joueur2
        }



        //regardde si la zone est est controlé et si non ou regarde qui gagne le combat
        int sommeSodats=0;
        if(controleZone[1]==0){
            sommeSodats=sommeSodats(soldatsZone1);
            if (sommeSodats>8){
                controleZone[1]=1;
                Toast.makeText(this, "Zone 1 controler par le Joueur 1", Toast.LENGTH_LONG).show();
            }else{
                controleZone[1]=2;
                Toast.makeText(this, "Zone 1 controler par le Joueur 2", Toast.LENGTH_LONG).show();
            }
        }else if (controleZone[2]==0){
            sommeSodats=sommeSodats(soldatsZone2);
            if (sommeSodats>=1){
                controleZone[2]=1;
                Toast.makeText(this, "Zone 2 controler par le Joueur 1", Toast.LENGTH_LONG).show();
            }else{
                controleZone[2]=2;
                Toast.makeText(this, "Zone 2 controler par le Joueur 2", Toast.LENGTH_LONG).show();
            }
        }else if (controleZone[4]==0){
            sommeSodats=sommeSodats(soldatsZone4);
            if (sommeSodats>=1){
                controleZone[4]=1;
                Toast.makeText(this, "Zone 4 controler par le Joueur 1", Toast.LENGTH_LONG).show();
            }else{
                controleZone[4]=2;
                Toast.makeText(this, "Zone 4 controler par le Joueur 2", Toast.LENGTH_LONG).show();
            }
        }else if (controleZone[5]==0){
            sommeSodats=sommeSodats(soldatsZone5);
            if (sommeSodats>3){
                controleZone[5]=1;
                Toast.makeText(this, "Zone 5 controler par le Joueur 1", Toast.LENGTH_LONG).show();
            }else{
                controleZone[5]=2;
                Toast.makeText(this, "Zone 5 controler par le Joueur 2", Toast.LENGTH_LONG).show();
            }
        }else if (controleZone[3]==0){
            sommeSodats=sommeSodats(soldatsZone3);
            if (sommeSodats>=2){
                controleZone[3]=1;
                Toast.makeText(this, "Zone 3 controler par le Joueur 1", Toast.LENGTH_LONG).show();
            }else{
                controleZone[3]=2;
                Toast.makeText(this, "Zone 3 controler par le Joueur 2", Toast.LENGTH_LONG).show();
            }
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                //Apartir d'ici on page à la page suivant = REdeploiement ou fin de patie selon les cas

                //Regarde la controle de la zone
                int zoneControlerParJoueur1=0;
                int zoneConrtolerParJoueur2=0;
                for (int i=0;i<5;i++){
                    if(controleZone[i]==1){
                        zoneControlerParJoueur1++;
                    }else if(controleZone[i]==2){
                        zoneConrtolerParJoueur2++;
                    }
                }

                if(zoneControlerParJoueur1==3){
                    defGagnant(1);
                }else if(zoneConrtolerParJoueur2==3){
                    defGagnant(2);
                }else{
                    //------------------------------------------------------------------Appel le redeploiement des soldats
                    Intent intentNextPage = new Intent(Combat.this, Combat.class);
                    intentNextPage.putExtra("SOLDATS_ZONE1", soldatsZone1);
                    intentNextPage.putExtra("SOLDATS_ZONE2", soldatsZone2);
                    intentNextPage.putExtra("SOLDATS_ZONE3", soldatsZone3);
                    intentNextPage.putExtra("SOLDATS_ZONE4", soldatsZone4);
                    intentNextPage.putExtra("SOLDATS_ZONE5", soldatsZone5);
                    intentNextPage.putExtra("CONTROLE_ZONE", controleZone);
                    // Exécution de l’activité : ouverture de la fenêtre
                    startActivity(intentNextPage);
                }
            }
        }, 5000);   //5 seconds


    }

    private int sommeSodats(int[] soldatsZone){
        int somme=0;
        for(int i=0;i<5;i++){
            somme+=soldatsZone[i];
        }
        return somme;
    }
    private void defGagnant(int Gagnant){
        getSharedPreferences(SHARED_PREF_JOUEUR_GAGNANT, MODE_PRIVATE)
                .edit()
                .putInt(SHARED_PREF_JOUEUR_GAGNANT_KEY, Gagnant)// ici le joueur 1 gagne
                .apply();

        Intent intentFinDePartie = new Intent(Combat.this, FinDePartie.class);
        // Exécution de l’activité : ouverture de la fenêtre
        startActivity(intentFinDePartie);
    }

}