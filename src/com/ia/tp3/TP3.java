package com.ia.tp3;

import java.util.ArrayList;

public class TP3 {

	public static PointGrapheTP3 initialiserArbre() {
		ArrayList<PointGrapheTP3> enfants = new ArrayList<PointGrapheTP3>();

		// Feuilles
		PointGrapheTP3 a5 = new PointGrapheTP3(4, "a5", null);
		PointGrapheTP3 b5 = new PointGrapheTP3(3, "b5", null);
		PointGrapheTP3 c5 = new PointGrapheTP3(8, "c5", null);
		PointGrapheTP3 d5 = new PointGrapheTP3(2, "d5", null);
		PointGrapheTP3 e5 = new PointGrapheTP3(1, "e5", null);
		PointGrapheTP3 f5 = new PointGrapheTP3(4, "f5", null);
		PointGrapheTP3 g5 = new PointGrapheTP3(2, "g5", null);
		PointGrapheTP3 h5 = new PointGrapheTP3(3, "h5", null);
		PointGrapheTP3 i5 = new PointGrapheTP3(6, "i5", null);
		PointGrapheTP3 j5 = new PointGrapheTP3(4, "j5", null);
		PointGrapheTP3 k5 = new PointGrapheTP3(7, "k5", null);
		PointGrapheTP3 l5 = new PointGrapheTP3(5, "l5", null);
		PointGrapheTP3 m5 = new PointGrapheTP3(2, "m5", null);
		PointGrapheTP3 n5 = new PointGrapheTP3(1, "n5", null);
		PointGrapheTP3 o5 = new PointGrapheTP3(9, "o5", null);
		PointGrapheTP3 p5 = new PointGrapheTP3(0, "p5", null);
		PointGrapheTP3 q5 = new PointGrapheTP3(4, "q5", null);
		PointGrapheTP3 r5 = new PointGrapheTP3(3, "r5", null);
		PointGrapheTP3 s5 = new PointGrapheTP3(0, "s5", null);
		PointGrapheTP3 t5 = new PointGrapheTP3(2, "t5", null);
		PointGrapheTP3 u5 = new PointGrapheTP3(8, "u5", null);
		PointGrapheTP3 v5 = new PointGrapheTP3(4, "v5", null);
		PointGrapheTP3 w5 = new PointGrapheTP3(3, "w5", null);
		PointGrapheTP3 x5 = new PointGrapheTP3(7, "x5", null);
		PointGrapheTP3 y5 = new PointGrapheTP3(5, "y5", null);
		PointGrapheTP3 z5 = new PointGrapheTP3(4, "z5", null);
		PointGrapheTP3 aa5 = new PointGrapheTP3(1, "aa5", null);

		// Profondeur 4
		enfants.add(a5);
		enfants.add(b5);
		enfants.add(c5);
		PointGrapheTP3 a4 = new PointGrapheTP3(-1, "a4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(d5);
		enfants.add(e5);
		PointGrapheTP3 b4 = new PointGrapheTP3(-1, "b4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(f5);
		enfants.add(g5);
		enfants.add(h5);
		PointGrapheTP3 c4 = new PointGrapheTP3(-1, "c4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(i5);
		enfants.add(j5);
		PointGrapheTP3 d4 = new PointGrapheTP3(-1, "d4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(k5);
		PointGrapheTP3 e4 = new PointGrapheTP3(-1, "e4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(l5);
		enfants.add(m5);
		PointGrapheTP3 f4 = new PointGrapheTP3(-1, "f4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(n5);
		enfants.add(o5);
		enfants.add(p5);
		PointGrapheTP3 g4 = new PointGrapheTP3(-1, "g4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(q5);
		enfants.add(r5);
		PointGrapheTP3 h4 = new PointGrapheTP3(-1, "h4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(s5);
		PointGrapheTP3 i4 = new PointGrapheTP3(-1, "i4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(t5);
		enfants.add(u5);
		enfants.add(v5);
		PointGrapheTP3 j4 = new PointGrapheTP3(-1, "j4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(w5);
		enfants.add(x5);
		PointGrapheTP3 k4 = new PointGrapheTP3(-1, "k4", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(y5);
		enfants.add(z5);
		enfants.add(aa5);
		PointGrapheTP3 l4 = new PointGrapheTP3(-1, "l4", enfants);

		// Profondeur 3
		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(a4);
		enfants.add(b4);
		PointGrapheTP3 a3 = new PointGrapheTP3(-1, "a3", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(c4);
		PointGrapheTP3 b3 = new PointGrapheTP3(-1, "b3", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(d4);
		enfants.add(e4);
		enfants.add(f4);
		PointGrapheTP3 c3 = new PointGrapheTP3(-1, "c3", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(g4);
		PointGrapheTP3 d3 = new PointGrapheTP3(-1, "d3", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(h4);
		enfants.add(i4);
		PointGrapheTP3 e3 = new PointGrapheTP3(-1, "e3", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(j4);
		enfants.add(k4);
		enfants.add(l4);
		PointGrapheTP3 f3 = new PointGrapheTP3(-1, "f3", enfants);

		// Profondeur 2
		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(a3);
		enfants.add(b3);
		enfants.add(c3);
		PointGrapheTP3 a2 = new PointGrapheTP3(-1, "a2", enfants);

		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(d3);
		enfants.add(e3);
		enfants.add(f3);
		PointGrapheTP3 b2 = new PointGrapheTP3(-1, "b2", enfants);

		// Base
		enfants = new ArrayList<PointGrapheTP3>();
		enfants.add(a2);
		enfants.add(b2);
		PointGrapheTP3 base = new PointGrapheTP3(-1, "base", enfants);

		return base;

	}

	public static double minmax(PointGrapheTP3 point, int profondeur, double alpha, double beta, boolean maxPlayer) {
		if (profondeur == 0 || point.getEnfants() == null || point.getEnfants().size() == 0) {
			System.out.println("Noeud: " + point.getNom() + ", valeur: " + point.getValeur() + ", alpha: " + alpha
					+ " , beta: " + beta);
			return point.getValeur();
		}
		if (maxPlayer) {
			double maxEval = Double.NEGATIVE_INFINITY;
			for (PointGrapheTP3 enfant : point.getEnfants()) {
				double eval = minmax(enfant, profondeur - 1, alpha, beta, false);
				maxEval = Math.max(maxEval, eval);
				alpha = Math.max(alpha, eval);
				System.out.println(
						"Noeud: " + point.getNom() + ", valeur: " + maxEval + ", alpha: " + alpha + " , beta: " + beta);
				if (beta <= alpha)
					break;
			}
			return maxEval;
		} else {
			double minEval = Double.POSITIVE_INFINITY;
			for (PointGrapheTP3 enfant : point.getEnfants()) {
				double eval = minmax(enfant, profondeur - 1, alpha, beta, true);
				minEval = Math.min(minEval, eval);
				beta = Math.min(beta, eval);
				System.out.println(
						"Noeud: " + point.getNom() + ", valeur: " + minEval + ", alpha: " + alpha + " , beta: " + beta);
				if (beta <= alpha)
					break;
			}
			return minEval;
		}
	}

	public static void main(String[] args) {
		PointGrapheTP3 pointBase = initialiserArbre();
		double res = minmax(pointBase, 4, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, true);
		System.out.println("Final: " + res);
	}

}