package com.duolight.projeteg23.model;

import com.google.android.material.tabs.TabLayout;

public class Soldats {
    private String nom;
    private int[] caracteristique  = new int [7];

    public enum IA{
        Défensif,
        Offensif,
        Aléatoire,
        ;
    }

    // constructeur
    public Soldats(String nom, int pointDeVie, int force, int dexterite, int resistance,
                   int constitution, int initiative, int position) {
        this.nom = nom;
        this.caracteristique[0]=pointDeVie;
        this.caracteristique[1]=force;
        this.caracteristique[2]=dexterite;
        this.caracteristique[3]=resistance;
        this.caracteristique[4]=constitution;
        this.caracteristique[5]=initiative;
        this.caracteristique[6]=position;
    }
    public int[] getCaracteristique(){
        return caracteristique;
    }
/*
    public int modificationDesCaractéristiques(int caracteristique, int modificaition){
        return caracteristique+=modificaition;
    }*/

}
