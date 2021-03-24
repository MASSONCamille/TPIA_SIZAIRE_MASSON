package com.ia.tp2_2;

import java.util.ArrayList;

public class PointGrapheTP2 {

	private String nom;
	private int g;
	private int h;
	private int fn;
	private ArrayList<PointGrapheTP2> voisins;

	public PointGrapheTP2(String nom) {
		super();
		this.nom = nom;
		this.g = 0;
		this.h = 0;
		this.fn = 0;
		this.voisins = new ArrayList<PointGrapheTP2>();
	}

	public PointGrapheTP2(String nom, int h) {
		super();
		this.nom = nom;
		this.g = 0;
		this.h = h;
		this.fn = 0;
		this.voisins = new ArrayList<PointGrapheTP2>();
	}

	public PointGrapheTP2(String nom, int g, int h, ArrayList<PointGrapheTP2> voisins) {
		super();
		this.nom = nom;
		this.g = g;
		this.h = h;
		this.fn = 0;
		this.voisins = voisins;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getFn() {
		return fn;
	}

	public void setFn(int fn) {
		this.fn = fn;
	}

	public ArrayList<PointGrapheTP2> getVoisins() {
		return voisins;
	}

	public void setVoisins(ArrayList<PointGrapheTP2> voisins) {
		this.voisins = voisins;
	}

	public void addVoisins(PointGrapheTP2 point) {
		this.voisins.add(point);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointGrapheTP2 other = (PointGrapheTP2) obj;
		if (fn != other.fn)
			return false;
		if (g != other.g)
			return false;
		if (h != other.h)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (voisins == null) {
			if (other.voisins != null)
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PointGrapheTP2 [nom=" + nom + ", g=" + g + ", h=" + h + ", fn=" + fn + ", voisins=" + voisins + "]";
	}

}
