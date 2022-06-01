package com.duolight.projeteg23.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duolight.projeteg23.R;
import com.duolight.projeteg23.model.Armee;
import com.duolight.projeteg23.model.Soldats;

import java.util.Arrays;

public class RepartitionPoints extends AppCompatActivity {

    private static final String SHARED_PREF_JOUEUR_1_INFO = "SHARED_PREF_JOUEUR_1_INFO"; // nom du fichier
    private static final String SHARED_PREF_JOUEUR_1_INFO_KEY = "SHARED_PREF_JOUEUR_1_INFO_KEY";//Key
    private TextView mBranche;
    private int points;

    private TextView mPointsRestants;
    //Création de text View pour les caractéristique des soldats de l'armée
    private TextView mForceChef;
    private TextView mDexteriteChef;
    private TextView mResistanceChef;
    private TextView mConstitutionChef;
    private TextView mInitiativeChef;

    private TextView mForceElite;
    private TextView mDexteriteElite;
    private TextView mResistanceElite;
    private TextView mConstitutionElite;
    private TextView mInitiativeElite;

    private TextView mForceAlpha;
    private TextView mDexteriteAlpha;
    private TextView mResistanceAlpha;
    private TextView mConstitutionAlpha;
    private TextView mInitiativeAlpha;

    private TextView mForceBravo;
    private TextView mDexteriteBravo;
    private TextView mResistanceBravo;
    private TextView mConstitutionBravo;
    private TextView mInitiativeBravo;

    private TextView mForceCharlie;
    private TextView mDexteriteCharlie;
    private TextView mResistanceCharlie;
    private TextView mConstitutionCharlie;
    private TextView mInitiativeCharlie;

    Armee armeeDeBase = generateArmee(1);

    int[] caraccteristiqueChef;
    int[] caraccteristiqueElite;
    int[] caraccteristiqueAlpha;
    int[] caraccteristiqueBravo;
    int[] caraccteristiqueCharlie;

    //Creation des TextView de la popUp
    private TextView mPopUp_title;
    private TextView mPopUp_force;
    private TextView mPopUp_dexterite;
    private TextView mPopUp_resistance;
    private TextView mPopUp_constitution;
    private TextView mPopUp_initiative;
    private TextView mPopUp_offensive;

    private Button mForceMoins;
    private Button mForcePlus;
    private Button mDexteriteMoins;
    private Button mDexteritePlus;
    private Button mResistanceMoins;
    private Button mResistancePlus;
    private Button mConstitutionMoins;
    private Button mConstitutionPlus;
    private Button mInitiativeMoins;
    private Button mInitiativePlus;

    private static int compteurForce=0;
    private static int compteurDexterite=0;
    private static int compteurResistance=0;
    private static int compteurConstitution=0;
    private static int compteurInitiative=0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repartition_points);
         points = 400;

        //Affiche la Branche du Joueur
        mBranche=findViewById(R.id.repartition_points_joueur_branche);
        String brancheJoueur1 = getSharedPreferences(SHARED_PREF_JOUEUR_1_INFO,MODE_PRIVATE).getString(SHARED_PREF_JOUEUR_1_INFO_KEY,null);
        mBranche.setText("Joueur 1 : " + brancheJoueur1);


        mPointsRestants = findViewById(R.id.repartition_points_restants);
        //Affiche les caractérisque des Soldats de l'Armee
        mForceChef = findViewById(R.id.repartition_points_textView_Chef_force);
        mDexteriteChef= findViewById(R.id.repartition_points_textView_Chef_dexterite);
        mResistanceChef= findViewById(R.id.repartition_points_textView_Chef_resistance);
        mConstitutionChef= findViewById(R.id.repartition_points_textView_Chef_constitution);
        mInitiativeChef= findViewById(R.id.repartition_points_textView_Chef_initiative);

        mForceElite = findViewById(R.id.repartition_points_textView_Elite_force);
        mDexteriteElite = findViewById(R.id.repartition_points_textView_Elite_dexterite);
        mResistanceElite = findViewById(R.id.repartition_points_textView_Elite_resistance);
        mConstitutionElite = findViewById(R.id.repartition_points_textView_Elite_constitution);
        mInitiativeElite = findViewById(R.id.repartition_points_textView_Elite_initiative);

        mForceAlpha = findViewById(R.id.repartition_points_textView_Alpha_force);
        mDexteriteAlpha = findViewById(R.id.repartition_points_textView_Alpha_dexterite);
        mResistanceAlpha = findViewById(R.id.repartition_points_textView_Alpha_resistance);
        mConstitutionAlpha = findViewById(R.id.repartition_points_textView_Alpha_constitution);
        mInitiativeAlpha = findViewById(R.id.repartition_points_textView_Alpha_initiative);

        mForceBravo = findViewById(R.id.repartition_points_textView_Bravo_force);
        mDexteriteBravo = findViewById(R.id.repartition_points_textView_Bravo_dexterite);
        mResistanceBravo = findViewById(R.id.repartition_points_textView_Bravo_resistance);
        mConstitutionBravo = findViewById(R.id.repartition_points_textView_Bravo_constitution);
        mInitiativeBravo = findViewById(R.id.repartition_points_textView_Bravo_initiative);

        mForceCharlie = findViewById(R.id.repartition_points_textView_Charlie_force);
        mDexteriteCharlie = findViewById(R.id.repartition_points_textView_Charlie_dexterite);
        mResistanceCharlie = findViewById(R.id.repartition_points_textView_Charlie_resistance);
        mConstitutionCharlie = findViewById(R.id.repartition_points_textView_Charlie_constitution);
        mInitiativeCharlie = findViewById(R.id.repartition_points_textView_Charlie_initiative);

        caraccteristiqueChef=armeeDeBase.getCaracteristiqueSoldat(0);
        caraccteristiqueElite=armeeDeBase.getCaracteristiqueSoldat(1);
        caraccteristiqueAlpha=armeeDeBase.getCaracteristiqueSoldat(2);
        caraccteristiqueBravo=armeeDeBase.getCaracteristiqueSoldat(3);
        caraccteristiqueCharlie=armeeDeBase.getCaracteristiqueSoldat(4);

        mPointsRestants.setText("Points Restants : "+points);

        mForceChef.setText("Force : "+caraccteristiqueChef[1]);
        mDexteriteChef.setText("Dexterité : "+caraccteristiqueChef[2]);
        mResistanceChef.setText("Resistannce : "+caraccteristiqueChef[3]);
        mConstitutionChef.setText("Consititution : "+caraccteristiqueChef[4]);
        mInitiativeChef.setText("Initiative : "+caraccteristiqueChef[5]);

        mForceElite.setText("Force : "+caraccteristiqueElite[1]);
        mDexteriteElite.setText("Dexterité : "+caraccteristiqueElite[2]);
        mResistanceElite.setText("Resistannce : "+caraccteristiqueElite[3]);
        mConstitutionElite.setText("Consititution : "+caraccteristiqueElite[4]);
        mInitiativeElite.setText("Initiative : "+caraccteristiqueElite[5]);

        mForceAlpha.setText("Force : "+caraccteristiqueAlpha[1]);
        mDexteriteAlpha.setText("Dexterité : "+caraccteristiqueAlpha[2]);
        mResistanceAlpha.setText("Resistannce : "+caraccteristiqueAlpha[3]);
        mConstitutionAlpha.setText("Consititution : "+caraccteristiqueAlpha[4]);
        mInitiativeAlpha.setText("Initiative : "+caraccteristiqueAlpha[5]);

        mForceBravo.setText("Force : "+caraccteristiqueBravo[1]);
        mDexteriteBravo.setText("Dexterité : "+caraccteristiqueBravo[2]);
        mResistanceBravo.setText("Resistannce : "+caraccteristiqueBravo[3]);
        mConstitutionBravo.setText("Consititution : "+caraccteristiqueBravo[4]);
        mInitiativeBravo.setText("Initiative : "+caraccteristiqueBravo[5]);

        mForceCharlie.setText("Force : "+caraccteristiqueCharlie[1]);
        mDexteriteCharlie.setText("Dexterité : "+caraccteristiqueCharlie[2]);
        mResistanceCharlie.setText("Resistannce : "+caraccteristiqueCharlie[3]);
        mConstitutionCharlie.setText("Consititution : "+caraccteristiqueCharlie[4]);
        mInitiativeCharlie.setText("Initiative : "+caraccteristiqueCharlie[5]);


        final ImageView mArrowRight= findViewById(R.id.repartition_points_arrow_right);
        mArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----------------------------------------ICI changement de Page------------------------------------//
                Intent intent = new Intent(RepartitionPoints.this, DeploiementArmee.class);
                // Exécution de l’activité : ouverture de la fenêtre
                startActivity(intent);
            }
        });
        // Liaison entre l’objet graphique R.id.button et la variable listeCourseButton
        final LinearLayout mLayoutChefDeGuerre = (LinearLayout ) findViewById(R.id.repartition_points_chefDeGuerre);
        // Création d’un évènement qui attend un clic sur le bouton
        mLayoutChefDeGuerre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //Appel une pop-up
                compteurForce=0;
                compteurDexterite=0;
                Soldats newSoldats = myCustomAlertDialog(0);
            }
        });
        // Liaison entre l’objet graphique R.id.button et la variable listeCourseButton
        final LinearLayout mLayoutSoldatElite = (LinearLayout ) findViewById(R.id.repartition_points_soldatElite);
        // Création d’un évènement qui attend un clic sur le bouton
        mLayoutSoldatElite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //Appel une pop-up
                initialisationCompteur();
                Soldats newSoldats = myCustomAlertDialog(1);
            }
        });
        // Liaison entre l’objet graphique R.id.button et la variable listeCourseButton
        final LinearLayout mLayoutAlpha = (LinearLayout ) findViewById(R.id.repartition_points_Alpha);
        // Création d’un évènement qui attend un clic sur le bouton
        mLayoutAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //Appel une pop-up
                initialisationCompteur();
                Soldats newSoldats = myCustomAlertDialog(2);
            }
        });
        // Liaison entre l’objet graphique R.id.button et la variable listeCourseButton
        final LinearLayout mLayoutBravo = (LinearLayout ) findViewById(R.id.repartition_points_Bravo);
        // Création d’un évènement qui attend un clic sur le bouton
        mLayoutBravo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //Appel une pop-up
                initialisationCompteur();
                Soldats newSoldats = myCustomAlertDialog(3);
            }
        });
        // Liaison entre l’objet graphique R.id.button et la variable listeCourseButton
        final LinearLayout mLayoutCharlie = (LinearLayout ) findViewById(R.id.repartition_points_Charlie);
        // Création d’un évènement qui attend un clic sur le bouton
        mLayoutCharlie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //Appel une pop-up
                initialisationCompteur();
                Soldats newSoldats = myCustomAlertDialog(4);
            }
        });

    }

    private Soldats myCustomAlertDialog(int typeSoldat){

        //récuper le soldat
        Soldats soldat = armeeDeBase.getSoldat(typeSoldat);
        //crée la popUp
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View popUpView = getLayoutInflater().inflate(R.layout.popup, null);

        mPopUp_title = (TextView) popUpView.findViewById(R.id.popUp_title);
        mPopUp_force = (TextView) popUpView.findViewById(R.id.popUp_force);
        mPopUp_dexterite = (TextView) popUpView.findViewById(R.id.popUp_dexterite);
        mPopUp_resistance = (TextView) popUpView.findViewById(R.id.popUp_resistance);
        mPopUp_constitution = (TextView) popUpView.findViewById(R.id.popUp_constitution);
        mPopUp_initiative = (TextView) popUpView.findViewById(R.id.popUp_initiative);

        mForcePlus = (Button) popUpView.findViewById(R.id.popUp_button_force_plus);
        mForceMoins = (Button) popUpView.findViewById(R.id.popUp_button_force_moins);
        mDexteritePlus = (Button) popUpView.findViewById(R.id.popUp_button_dexterite_plus);
        mDexteriteMoins = (Button) popUpView.findViewById(R.id.popUp_button_dexterite_moins);
        mResistancePlus = (Button) popUpView.findViewById(R.id.popUp_button_resistance_plus);
        mResistanceMoins = (Button) popUpView.findViewById(R.id.popUp_button_resistance_moins);
        mConstitutionPlus = (Button) popUpView.findViewById(R.id.popUp_button_constitution_plus);
        mConstitutionMoins = (Button) popUpView.findViewById(R.id.popUp_button_consititution_moins);
        mInitiativePlus = (Button) popUpView.findViewById(R.id.popUp_button_initiative_plus);
        mInitiativeMoins = (Button) popUpView.findViewById(R.id.popUp_button_initiative_moins);

        mPopUp_title.setText(soldat.nom());
        mPopUp_force.setText("Force : " +soldat.getForce());
        mPopUp_dexterite.setText("Dexterite : " +soldat.getDexterite());
        mPopUp_resistance.setText("Resistance : " +soldat.getResistance());
        mPopUp_constitution.setText("Constitution : " +soldat.getConstitution());
        mPopUp_initiative.setText("Initiative : " +soldat.getInitiative());

        // on clic
        mForcePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //augemente la force
                compteurForce++;
                mPopUp_force.setText("Force : " +(soldat.getForce() + compteurForce));
                displayforce(typeSoldat,1,(soldat.getForce() + compteurForce));
            }
        });
        mForceMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //augemente la force
                compteurForce--;
                mPopUp_force.setText("Force : " +(soldat.getForce()+compteurForce));
                displayforce(typeSoldat,-1,(soldat.getForce() + compteurForce));
            }
        });

        mDexteritePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //augemente la force
                compteurDexterite++;
                mPopUp_dexterite.setText("Dexterite : " +(soldat.getDexterite() + compteurDexterite));
                displayDexterite(typeSoldat,1,(soldat.getDexterite() + compteurDexterite));
            }
        });
        mDexteriteMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //augemente la force
                compteurDexterite--;
                mPopUp_dexterite.setText("Dexterite : " +(soldat.getDexterite()+compteurDexterite));
                displayDexterite(typeSoldat,-1,(soldat.getDexterite() + compteurDexterite));
            }
        });

        mResistancePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //augemente la force
                compteurResistance++;
                mPopUp_resistance.setText("Resistance : " +(soldat.getResistance() + compteurResistance));
                displayResistance(typeSoldat,1,(soldat.getResistance() + compteurResistance));
            }
        });
        mResistanceMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //augemente la force
                compteurResistance--;
                mPopUp_resistance.setText("Resistance : " +(soldat.getResistance()+compteurResistance));
                displayResistance(typeSoldat,-1,(soldat.getResistance() + compteurResistance));
            }
        });

        mConstitutionPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //augemente la force
                compteurConstitution++;
                mPopUp_constitution.setText("Constitution : " +(soldat.getConstitution() + compteurConstitution));
                displayConstitution(typeSoldat,1,(soldat.getConstitution() + compteurConstitution));
            }
        });
        mConstitutionMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //augemente la force
                compteurConstitution--;
                mPopUp_constitution.setText("Constitution : " +(soldat.getConstitution()+compteurConstitution));
                displayConstitution(typeSoldat,-1,(soldat.getConstitution() + compteurConstitution));
            }
        });

        mInitiativePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //augemente la force
                compteurInitiative++;
                mPopUp_initiative.setText("Initiative : " +(soldat.getInitiative() + compteurInitiative));
                displayInitiative(typeSoldat,1,(soldat.getInitiative() + compteurInitiative));
            }
        });
        mInitiativeMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //augemente la force
                compteurInitiative--;
                mPopUp_initiative.setText("Initiative : " +(soldat.getInitiative()+compteurInitiative));
                displayInitiative(typeSoldat,-1,(soldat.getInitiative() + compteurInitiative));
            }
        });
        builder.setView(popUpView);
        builder.create();
        builder.show();
        Soldats newSoldat = new Soldats(soldat.nom(),30,compteurForce,2,2,2,2,2);
        return newSoldat;
    }

    public void displayforce(int typeSoldat,int signe, int valeur) {
        switch (typeSoldat) {
            case 0:
                mForceChef.setText("Force : " + valeur);
                points-=signe;
                break;
            case 1:
                mForceElite.setText("Force : " + valeur);
                points-=(4*signe);
                break;
            case 2:
                mForceAlpha.setText("Force : " + valeur);
                points-=(5*signe);
                break;
            case 3:
                mForceBravo.setText("Force : " + valeur);
                points-=(5*signe);
                break;
            case 4:
                mForceCharlie.setText("Force : " + valeur);
                points-=(5*signe);
                break;
        }
        mPointsRestants.setText("Points Restants : "+points);
    }
    public void displayDexterite(int typeSoldat,int signe, int valeur){
        switch (typeSoldat){
            case 0 :
                mDexteriteChef.setText("Dexterite : "+valeur);
                points-=signe;
                break;
            case 1 :
                mDexteriteElite.setText("Dexterite : "+valeur);
                points-=(4*signe);
                break;
            case 2 :
                mDexteriteAlpha.setText("Dexterite : "+valeur);
                points-=(5*signe);
                break;
            case 3 :
                mDexteriteBravo.setText("Dexterite : "+valeur);
                points-=(5*signe);
                break;
            case 4 :
                mDexteriteCharlie.setText("Dexterite : "+valeur);
                points-=(5*signe);
                break;
        }
        mPointsRestants.setText("Points Restants : "+points);
    }

    public void displayResistance(int typeSoldat,int signe, int valeur){
        switch (typeSoldat){
            case 0 :
                mResistanceChef.setText("Resistance : "+valeur);
                points-=signe;
                break;
            case 1 :
                mResistanceElite.setText("Resistance : "+valeur);
                points-=(4*signe);
                break;
            case 2 :
                mResistanceAlpha.setText("Resistance : "+valeur);
                points-=(5*signe);
                break;
            case 3 :
                mResistanceBravo.setText("Resistance : "+valeur);
                points-=(5*signe);
                break;
            case 4 :
                mResistanceCharlie.setText("Resistance : "+valeur);
                points-=(5*signe);
                break;
        }
        mPointsRestants.setText("Points Restants : "+points);
    }
    public void displayConstitution(int typeSoldat,int signe, int valeur){
        switch (typeSoldat){
            case 0 :
                mConstitutionChef.setText("Constitution : "+valeur);
                points-=signe;
                break;
            case 1 :
                mConstitutionElite.setText("Constitution : "+valeur);
                points-=(4*signe);
                break;
            case 2 :
                mConstitutionAlpha.setText("Constitution : "+valeur);
                points-=(5*signe);
                break;
            case 3 :
                mConstitutionBravo.setText("Constitution : "+valeur);
                points-=(5*signe);
                break;
            case 4 :
                mConstitutionCharlie.setText("Constitution : "+valeur);
                points-=(5*signe);
                break;
        }
        mPointsRestants.setText("Points Restants : "+points);
    }
    public void displayInitiative(int typeSoldat,int signe, int valeur){
        switch (typeSoldat){
            case 0 :
                mInitiativeChef.setText("Initiative : "+valeur);
                points-=signe;
                break;
            case 1 :
                mInitiativeElite.setText("Initiative : "+valeur);
                points-=(4*signe);
                break;
            case 2 :
                mInitiativeAlpha.setText("Initiative : "+valeur);
                points-=(5*signe);
                break;
            case 3 :
                mInitiativeBravo.setText("Initiative : "+valeur);
                points-=(5*signe);
                break;
            case 4 :
                mInitiativeCharlie.setText("Initiative : "+valeur);
                points-=(5*signe);
                break;
        }
        mPointsRestants.setText("Points Restants : "+points);
    }

    public void initialisationCompteur(){
        compteurForce=0;
        compteurDexterite=0;
        compteurResistance=0;
        compteurConstitution=0;
        compteurInitiative=0;
    }
    public Armee generateArmee(int joueur){
        Soldats chefDeGuerre = new Soldats(
                "chef de Guerre ",
                30,
                2,
                2,
                2,
                10,
                2,
                0

        );
        Soldats soldatsElite1 = new Soldats(
                "Soldat d'élite ",
                30,
                1,
                1,
                1,
                5,
                1,
                0
        );

        Soldats soldatsAlpha1 = new Soldats(
                "Soldat Alpha ",
                30,
                0,
                0,
                0,
                0,
                0,
                0
        );
        Soldats soldatsBravo1 = new Soldats(
                "Soldat Bravo ",
                30,
                0,
                0,
                0,
                0,
                0,
                0
        );
        Soldats soldatsCharlie1 = new Soldats(
                "Soldat Charlie ",
                30,
                0,
                0,
                0,
                0,
                0,
                0
        );
        return new Armee(Arrays.asList(chefDeGuerre), Arrays.asList(soldatsElite1),
                Arrays.asList(soldatsAlpha1),Arrays.asList(soldatsBravo1),Arrays.asList(soldatsCharlie1),joueur);
    }
}