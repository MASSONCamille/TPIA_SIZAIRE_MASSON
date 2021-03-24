package com.ia.tp1;

import java.util.ArrayList;

public class PointGraphe { // Classe permettant de représenter un point d'un graphe

	String nom;
	int x, y, z;
	ArrayList<PointGraphe> voisins;

	public PointGraphe() {
		super();
		this.nom = "";
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.voisins = new ArrayList<PointGraphe>();
	}

	public PointGraphe(String nom, int x, int y, int z) {
		super();
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.z = z;
		this.voisins = new ArrayList<PointGraphe>();
	}

	public PointGraphe(String nom, int x, int y, int z, ArrayList<PointGraphe> voisins) {
		super();
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.z = z;
		this.voisins = voisins;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public ArrayList<PointGraphe> getVoisins() {
		return voisins;
	}

	public void setVoisins(ArrayList<PointGraphe> voisins) {
		this.voisins = voisins;
	}

	public void addVoisins(PointGraphe point) {
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
		PointGraphe other = (PointGraphe) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (voisins == null) {
			if (other.voisins != null)
				return false;
		}
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PointGraphe [nom=" + nom + ", x=" + x + ", y=" + y + ", z=" + z + ", voisins=" + voisins + "]";
	}

}
