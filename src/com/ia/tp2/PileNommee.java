package com.ia.tp2;

import java.util.Stack;

public class PileNommee {

	String nom;
	Stack<Disque> pile;

	public PileNommee(String nom, Stack<Disque> pile) {
		super();
		this.nom = nom;
		this.pile = pile;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Stack<Disque> getPile() {
		return pile;
	}

	public void setPile(Stack<Disque> pile) {
		this.pile = pile;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PileNommee other = (PileNommee) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pile == null) {
			if (other.pile != null)
				return false;
		} else if (!pile.equals(other.pile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PileNommee [nom=" + nom + ", pile=" + pile.toString() + "]";
	}

	public String toStringAlgo() {
		return nom + ": " + pile.toString();
	}

}
