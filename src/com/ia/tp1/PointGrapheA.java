package com.ia.tp1;

import java.util.ArrayList;

public class PointGrapheA extends PointGraphe {
	PointGrapheA precedent;
	int f;
	double h;

	public PointGrapheA() {
		super();
		this.precedent = null;
	}

	public PointGrapheA(String nom, int x, int y, int z) {
		super(nom, x, y, z);
		this.precedent = null;
		this.f = 0;
		this.h = 0;
	}

	public PointGrapheA(String nom, int x, int y, int z, ArrayList<PointGraphe> voisins) {
		super(nom, x, y, z, voisins);
		this.precedent = null;
		this.f = 0;
		this.h = 0;
	}

	public PointGrapheA(String nom, int x, int y, int z, ArrayList<PointGraphe> voisins, PointGrapheA precedent,
			PointGraphe cible) {
		super(nom, x, y, z, voisins);
		this.precedent = precedent;
		this.f = this.f();
		this.h = this.h(cible);
	}

	public PointGraphe getPrecedent() {
		return precedent;
	}

	public void setPrecedent(PointGrapheA precedent) {
		this.precedent = precedent;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public int C() {
		int coutChemin = 0;
		if (this.x != this.precedent.getX())
			coutChemin = this.x - this.precedent.getX();
		else if (this.y != this.precedent.getY())
			coutChemin = this.y - this.precedent.getY();
		else
			coutChemin = this.z - this.precedent.getZ();
		if (coutChemin < 0)
			coutChemin = -coutChemin;
		return coutChemin;
	}

	public int f() {
		if (this.precedent != null) {
			return this.precedent.f() + C();
		}
		return 0;
	}

	public double h(PointGraphe cible) {
		return Math.sqrt(Math.pow((cible.getX() - this.x), 2) + Math.pow((cible.getY() - this.y), 2)
				+ Math.pow((cible.getZ() - this.z), 2));
	}

	public ArrayList<PointGrapheA> getVoisinsA() {
		ArrayList<PointGrapheA> res = new ArrayList<PointGrapheA>();
		for (PointGraphe elem : this.getVoisins()) {
			if (!elem.equals(this.getPrecedent()))
				res.add((PointGrapheA) elem);
		}
		return res;
	}

	public boolean equalsCoor(PointGraphe autre) {
		if ((autre.getX() == this.x) && (autre.getY() == this.y) && (autre.getZ() == this.z))
			return true;
		else
			return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointGrapheA other = (PointGrapheA) obj;
		if (f != other.f)
			return false;
		if (Double.doubleToLongBits(h) != Double.doubleToLongBits(other.h))
			return false;
		if (precedent == null) {
			if (other.precedent != null)
				return false;
		} else if (!precedent.equals(other.precedent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PointGrapheA [nom=" + nom + ", x=" + x + ", y=" + y + ", z=" + z + ", precedent=" + precedent + ", f="
				+ f + ", h=" + h + "]";
	}

}
