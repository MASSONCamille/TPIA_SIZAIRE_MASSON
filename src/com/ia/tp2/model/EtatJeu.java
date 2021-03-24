package com.ia.tp2.model;

import java.util.ArrayList;

public class EtatJeu {
	private Tour depart;
	private Tour intermediaire;
	private Tour arrivee;
	private int nbt;
	
	public EtatJeu(Tour depart, Tour intermediaire, Tour arrivee, int nbt) {
		super();
		this.depart = depart;
		this.intermediaire = intermediaire;
		this.arrivee = arrivee;
		this.nbt = nbt;
	}
	public EtatJeu(EtatJeu j) {
		super();
		ArrayList<Tour> lst = new ArrayList<Tour>();
		lst.add(j.depart);
		lst.add(j.intermediaire);
		lst.add(j.arrivee);
		
		for (Tour t : lst) {
			if (t.getType() == TypeTour.D) this.depart = t;
			else if (t.getType() == TypeTour.I) this.intermediaire = t;	
			else if (t.getType() == TypeTour.A) this.arrivee = t;
		}
		
		this.nbt = j.nbt;
	}
	
	public Tour getDepart() {
		return depart;
	}
	public void setDepart(Tour depart) {
		this.depart = depart;
	}
	public Tour getIntermediaire() {
		return intermediaire;
	}
	public void setIntermediaire(Tour intermediaire) {
		this.intermediaire = intermediaire;
	}
	public Tour getArrivee() {
		return arrivee;
	}
	public void setArrivee(Tour arrivee) {
		this.arrivee = arrivee;
	}
	public int getNbt() {
		return nbt;
	}
	public void setNbt(int nbt) {
		this.nbt = nbt;
	}
	
	public void inverse(Boolean mode) {
		if(!mode) {
			Tour x = arrivee;
			arrivee = intermediaire;
			intermediaire = x;
		}else {
			Tour x = depart;
			depart = intermediaire;
			intermediaire = x;
		}
	}
	
	
	@Override
	public String toString() {
		return "Tour " + nbt + "\n"
			+ "Depart : " + depart.toString() + "\n"
			+ "Intermediaire : " + intermediaire.toString() + "\n"
			+ "Arrivee : " + arrivee.toString();
	}
	
}
