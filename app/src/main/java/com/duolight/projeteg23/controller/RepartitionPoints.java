package com.duolight.projeteg23.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    private int Score;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repartition_points);
         Score = 400;

        //Affiche la Branche du Joueur
        mBranche=findViewById(R.id.repartition_points_joueur_branche);
        String brancheJoueur1 = getSharedPreferences(SHARED_PREF_JOUEUR_1_INFO,MODE_PRIVATE).getString(SHARED_PREF_JOUEUR_1_INFO_KEY,null);
        mBranche.setText("Joueur 1 : " + brancheJoueur1);

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

        // Liaison entre l’objet graphique R.id.button et la variable listeCourseButton
        final LinearLayout mLayoutChefDeGuerre = (LinearLayout ) findViewById(R.id.popUp_layout);
        // Création d’un évènement qui attend un clic sur le bouton
        mLayoutChefDeGuerre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // fonction déclenchée sur le clic du bouton
                //Appel une pop-up
                myCustomAlertDialog();
            }
        });
    }

    private void myCustomAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View popUpView = getLayoutInflater().inflate(R.layout.popup, null);
        builder.setView(popUpView);
        builder.create();
        builder.show();
    }

    private Armee generateArmee(int joueur){
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
                "Soldat Alpha ",
                30,
                0,
                0,
                0,
                0,
                0,
                0
        );
        Soldats soldatsCharlie1 = new Soldats(
                "Soldat Alpha ",
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