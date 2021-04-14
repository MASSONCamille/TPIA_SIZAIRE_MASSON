package com.ia.tp3;

import java.util.ArrayList;

public class PointGrapheTP3 {
    private int valeur;
    private String nom;
    private ArrayList<PointGrapheTP3> enfants = new ArrayList<PointGrapheTP3>();

    public PointGrapheTP3(int valeur, String nom, ArrayList<PointGrapheTP3> enfants) {
        super();
        this.valeur = valeur;
        this.nom = nom;
        this.enfants = enfants;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<PointGrapheTP3> getEnfants() {
        return enfants;
    }

    public void setEnfants(ArrayList<PointGrapheTP3> enfants) {
        this.enfants = enfants;
    }

    @Override
    public String toString() {
        return "PointGrapheTP3 [valeur=" + valeur + ", nom=" + nom + ", enfants=" + enfants + "]";
    }

}