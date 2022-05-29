package com.duolight.projeteg23.model;

import java.util.Arrays;
import java.util.List;

public class Armee {

    private final List<Soldats> mChefDeGuerre;
    private final List<Soldats> mSoldatsElite;
    private final List<Soldats> mAlpha;
    private final List<Soldats> mBravo;
    private final List<Soldats> mCharlie;
    private final int mJoueur;

    public Armee(List<Soldats> chefDeGuerre,List<Soldats> soldatsElite,List<Soldats> alpha,List<Soldats> bravo,List<Soldats> charlie, int joueur) {
        mChefDeGuerre = chefDeGuerre;
        mSoldatsElite = soldatsElite;
        mAlpha=alpha;
        mBravo=bravo;
        mCharlie=charlie;
        mJoueur=joueur;
    }

    public Soldats getSoldat (int typeSoldat) {
        switch (typeSoldat){
            case 0:
                return mChefDeGuerre.get(0);
            case 1:
                return mSoldatsElite.get(0);
            case 2:
                return mAlpha.get(0);
            case 3:
                return mBravo.get(0);
            case 4:
                return mCharlie.get(0);
            }
        return mChefDeGuerre.get(0);
    }


    public int[] getCaracteristiqueSoldat(int typeSoldat) {
        switch (typeSoldat){
            case 0:
                return mChefDeGuerre.get(0).getCaracteristique();
            case 1:
                return mSoldatsElite.get(0).getCaracteristique();
            case 2:
                return mAlpha.get(0).getCaracteristique();
            case 3:
                return mBravo.get(0).getCaracteristique();
            case 4:
                return mCharlie.get(0).getCaracteristique();
        }
        return mChefDeGuerre.get(0).getCaracteristique();
    }

}
