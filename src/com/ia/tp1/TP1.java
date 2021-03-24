package com.ia.tp1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TP1 {

	public static LinkedList<PointGrapheA> trier(LinkedList<PointGrapheA> list) {
		Collections.sort(list, new Comparator<PointGrapheA>() {
			@Override
			public int compare(PointGrapheA o1, PointGrapheA o2) {
				return Double.compare((o1.getF() + o1.getH()), (o2.getF() + o2.getH()));
			}
		});
		return list;
	}

	public static void algoA(LinkedList<PointGrapheA> ouvert, LinkedList<PointGrapheA> fermer, PointGrapheA cible) {
		String resultat = "";
		String etapes = "";
		PointGrapheA n;
		PointGrapheA voisin;
		boolean trouveFinal;
		int nbVoisins, i, coutTraite = 0;

		while (resultat.isEmpty()) { // Gérer chemin succès avec liste dynamique
			if (ouvert.isEmpty())
				resultat = "Echec";
			else {
				etapes += "\n-----------------------\nouvert: ";
				for (PointGrapheA point : ouvert)
					etapes += (point.getNom() + ", ");
				etapes += "\nfermer:";
				for (PointGrapheA point : fermer)
					etapes += (point.getNom() + ", ");
				n = (PointGrapheA) ouvert.getFirst();
				ouvert.removeFirst();
				fermer.add(n);

				trouveFinal = false;
				nbVoisins = n.getVoisins().size();
				i = 0;

				while (i < nbVoisins && !trouveFinal) {
					voisin = (PointGrapheA) n.getVoisins().get(i);
					if (voisin.equalsCoor(cible)) {
						trouveFinal = true;
						resultat = "Succès";
					}
					i++;
				}

				for (PointGrapheA voisinBis : n.getVoisinsA()) {
					voisinBis.setPrecedent(n);
					voisinBis.setF(voisinBis.f());
					voisinBis.setH(voisinBis.h(cible));
					if (!ouvert.contains(voisinBis) && !fermer.contains(voisinBis))
						ouvert.add(voisinBis);
					else {
						if (coutTraite > voisinBis.getF())
							coutTraite = voisinBis.getF();
					}
				}
				ouvert = trier(ouvert);
			}
		}

		etapes += ("\n-----------------------\n\n" + resultat);

		if (resultat.equals("Succès")) {
			etapes += "\n\nSolution:\n";
			for (PointGrapheA point : fermer)
				etapes += (point.getNom() + ", ");
			etapes += cible.getNom();
		}

		fichierResultat(etapes);
	}

	public static void fichierResultat(String message) {
		try {
			FileWriter fichierEcriture = new FileWriter("TP1_Resultat.txt");
			fichierEcriture.write(message);
			fichierEcriture.close();
			System.out.println("Fichier crée: TP1_Resultat.txt");
		} catch (IOException e) {
			System.out.println("Erreur dans l'écriture du fichier.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// Création des données à l'aide de la classe PointGraphe
		PointGrapheA A = new PointGrapheA("A", 0, 0, 0);
		PointGrapheA B = new PointGrapheA("B", 0, 1, 0);
		PointGrapheA C = new PointGrapheA("C", 1, 1, 0);
		PointGrapheA D = new PointGrapheA("D", 2, 0, 0);
		PointGrapheA E = new PointGrapheA("E", 2, 2, 0);
		PointGrapheA F = new PointGrapheA("F", 1, 2, 0);
		PointGrapheA G = new PointGrapheA("G", 2, 2, 2);
		PointGrapheA H = new PointGrapheA("H", 0, 2, 2);

		// Affectation des voisins des points pour modéliser le cube sous forme d'un
		// graphe
		A.addVoisins(B);
		A.addVoisins(D);
		B.addVoisins(A);
		B.addVoisins(C);
		C.addVoisins(B);
		C.addVoisins(F);
		D.addVoisins(A);
		D.addVoisins(E);
		E.addVoisins(D);
		E.addVoisins(F);
		E.addVoisins(G);
		F.addVoisins(C);
		F.addVoisins(E);
		G.addVoisins(E);
		G.addVoisins(H);
		H.addVoisins(G);

		LinkedList<PointGrapheA> ouvert = new LinkedList<PointGrapheA>();
		LinkedList<PointGrapheA> fermer = new LinkedList<PointGrapheA>();
		ouvert.add(A);

		algoA(ouvert, fermer, H);

	}

}
