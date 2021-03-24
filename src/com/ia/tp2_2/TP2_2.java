package com.ia.tp2_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TP2_2 {

	public static LinkedList<PointGrapheTP2> trierBFS(LinkedList<PointGrapheTP2> list) {
		Collections.sort(list, new Comparator<PointGrapheTP2>() {
			@Override
			public int compare(PointGrapheTP2 o1, PointGrapheTP2 o2) {
				return Double.compare(o1.getH(), o2.getH());
			}
		});
		return list;
	}

	public static LinkedList<PointGrapheTP2> trierBAB(LinkedList<PointGrapheTP2> list) {
		Collections.sort(list, new Comparator<PointGrapheTP2>() {
			@Override
			public int compare(PointGrapheTP2 o1, PointGrapheTP2 o2) {
				return Double.compare(o1.getFn(), o2.getFn());
			}
		});
		return list;
	}

	public static void bestFirstSearch(LinkedList<PointGrapheTP2> ouvert, LinkedList<PointGrapheTP2> fermer,
			ArrayList<PointGrapheTP2> cibles) {
		String resultat = "";
		String etapes = "";
		String cibleFinal = "";
		PointGrapheTP2 n;
		PointGrapheTP2 voisin;
		boolean trouveFinal;
		int nbVoisins, i, precH = 0;

		while (resultat.isEmpty()) { // Gérer chemin succès avec liste dynamique
			if (ouvert.isEmpty())
				resultat = "Echec";
			else {
				etapes += "\n-----------------------\nouvert: ";
				for (PointGrapheTP2 point : ouvert)
					etapes += (point.getNom() + ", ");
				etapes += "\nfermer: ";
				for (PointGrapheTP2 point : fermer)
					etapes += (point.getNom() + ", ");

				n = ouvert.getFirst();
				ouvert.removeFirst();
				fermer.add(n);

				trouveFinal = false;
				nbVoisins = n.getVoisins().size();
				i = 0;

				while (i < nbVoisins && !trouveFinal) {
					voisin = n.getVoisins().get(i);
					for (PointGrapheTP2 cible : cibles) {
						if (voisin.getNom().equals(cible.getNom())) {
							trouveFinal = true;
							resultat = "Succès";
							cibleFinal = cible.getNom();
						}
					}
					i++;
				}

				for (PointGrapheTP2 voisinBis : n.getVoisins()) {
					if (!ouvert.contains(voisinBis) && !fermer.contains(voisinBis))
						ouvert.add(voisinBis);
					else {
						if (precH > voisinBis.getH()) {
							precH = voisinBis.getH();
							if (fermer.contains(voisinBis)) {
								ouvert.add(voisinBis);
								fermer.remove(fermer.indexOf(voisinBis));
							}
						}
					}
				}
				ouvert = trierBFS(ouvert);
			}
		}

		etapes += ("\n-----------------------\n\n" + resultat);

		if (resultat.equals("Succès")) {
			etapes += "\n\nSolution:\n";
			for (PointGrapheTP2 point : fermer)
				etapes += (point.getNom() + ", ");
			etapes += cibleFinal;
		}

		fichierResultat("BestFirstSearch", etapes);
	}

	public static void branchAndBound(LinkedList<PointGrapheTP2> ouvert, LinkedList<PointGrapheTP2> fermer,
			ArrayList<PointGrapheTP2> cibles, Map<Cle<String, String>, Integer> mapPoids) {
		String resultat = "";
		String etapes = "";
		String cibleFinal = "";
		PointGrapheTP2 n;
		PointGrapheTP2 voisin;
		boolean trouveFinal;
		int nbVoisins;
		int i;
		int coutTraite = 0;
		int coutActu = 0;

		while (resultat.isEmpty()) { // Gérer chemin succès avec liste dynamique
			if (ouvert.isEmpty())
				resultat = "Echec";
			else {
				etapes += "\n-----------------------\nouvert: ";
				for (PointGrapheTP2 point : ouvert)
					etapes += (point.getNom() + ", ");
				etapes += "\nfermer: ";
				for (PointGrapheTP2 point : fermer)
					etapes += (point.getNom() + ", ");

				n = ouvert.getFirst();
				ouvert.removeFirst();
				fermer.add(n);

				trouveFinal = false;
				nbVoisins = n.getVoisins().size();
				i = 0;

				while (i < nbVoisins && !trouveFinal) {
					voisin = n.getVoisins().get(i);
					for (PointGrapheTP2 cible : cibles) {
						if (voisin.getNom().equals(cible.getNom())) {
							trouveFinal = true;
							resultat = "Succès";
							cibleFinal = cible.getNom();
						}
					}
					i++;
				}

				for (PointGrapheTP2 voisinBis : n.getVoisins()) {
					coutActu = mapPoids.get(new Cle<String, String>(n.getNom(), voisinBis.getNom()));
					voisinBis.setFn(coutTraite + coutActu);
					if (!ouvert.contains(voisinBis) && !fermer.contains(voisinBis))
						ouvert.add(voisinBis);
					else {
						if (coutTraite > coutActu) {
							coutTraite = coutActu;
							if (fermer.contains(voisinBis)) {
								ouvert.add(voisinBis);
								fermer.remove(fermer.indexOf(voisinBis));
							}
						}
					}
				}
				ouvert = trierBAB(ouvert);
			}
		}

		etapes += ("\n-----------------------\n\n" + resultat);

		if (resultat.equals("Succès")) {
			etapes += "\n\nSolution:\n";
			for (PointGrapheTP2 point : fermer)
				etapes += (point.getNom() + ", ");
			etapes += cibleFinal;
		}

		fichierResultat("BranchAndBound", etapes);
	}

	public static void algoA(LinkedList<PointGrapheTP2> ouvert, LinkedList<PointGrapheTP2> fermer,
			ArrayList<PointGrapheTP2> cibles, Map<Cle<String, String>, Integer> mapPoids) {
		String resultat = "";
		String etapes = "";
		String cibleFinal = "";
		PointGrapheTP2 n;
		PointGrapheTP2 voisin;
		boolean trouveFinal;
		int nbVoisins;
		int i;
		int coutTraite = 0;

		while (resultat.isEmpty()) { // Gérer chemin succès avec liste dynamique
			if (ouvert.isEmpty())
				resultat = "Echec";
			else {
				etapes += "\n-----------------------\nouvert: ";
				for (PointGrapheTP2 point : ouvert)
					etapes += (point.getNom() + ", ");
				etapes += "\nfermer:";
				for (PointGrapheTP2 point : fermer)
					etapes += (point.getNom() + ", ");

				n = ouvert.getFirst();
				ouvert.removeFirst();
				fermer.add(n);

				trouveFinal = false;
				nbVoisins = n.getVoisins().size();
				i = 0;

				while (i < nbVoisins && !trouveFinal) {
					voisin = n.getVoisins().get(i);
					for (PointGrapheTP2 cible : cibles) {
						if (voisin.getNom().equals(cible.getNom())) {
							trouveFinal = true;
							resultat = "Succès";
							cibleFinal = cible.getNom();
						}
					}
					i++;
				}

				for (PointGrapheTP2 voisinBis : n.getVoisins()) {
					voisinBis.setFn(voisinBis.getH() + n.getG()
							+ mapPoids.get(new Cle<String, String>(n.getNom(), voisinBis.getNom())));
					if (!ouvert.contains(voisinBis) && !fermer.contains(voisinBis))
						ouvert.add(voisinBis);
					else {
						if (coutTraite > voisinBis.getG())
							coutTraite = voisinBis.getG();
					}
				}
				ouvert = trierBAB(ouvert);
			}
		}

		etapes += ("\n-----------------------\n\n" + resultat);

		if (resultat.equals("Succès")) {
			etapes += "\n\nSolution:\n";
			for (PointGrapheTP2 point : fermer)
				etapes += (point.getNom() + ", ");
			etapes += cibleFinal;
		}

		fichierResultat("AlgoA", etapes);
	}

	public static void fichierResultat(String nomFichier, String message) {
		try {
			FileWriter fichierEcriture = new FileWriter(nomFichier + ".txt");
			System.out.println("Fichier crée: " + nomFichier + ".txt");
			fichierEcriture.write(message);
			fichierEcriture.close();
		} catch (IOException e) {
			System.out.println("Erreur dans l'écriture du fichier.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		// Création des données à l'aide de la classe PointGrapheTP2
		PointGrapheTP2 S = new PointGrapheTP2("S", 5);
		PointGrapheTP2 A = new PointGrapheTP2("A", 2);
		PointGrapheTP2 B = new PointGrapheTP2("B", 1);
		PointGrapheTP2 C = new PointGrapheTP2("C", 3);
		PointGrapheTP2 D = new PointGrapheTP2("D", 1);
		PointGrapheTP2 E = new PointGrapheTP2("E", 6);
		PointGrapheTP2 G1 = new PointGrapheTP2("G1", 0);
		PointGrapheTP2 G2 = new PointGrapheTP2("G2", 0);

		// Affectation des voisins des points pour modéliser le graphe
		// Les voisins sont dans le sens des flèches
		S.addVoisins(A);
		S.addVoisins(C);
		A.addVoisins(B);
		A.addVoisins(E);
		B.addVoisins(S);
		B.addVoisins(G1);
		B.addVoisins(D);
		B.addVoisins(C);
		C.addVoisins(D);
		C.addVoisins(G2);
		D.addVoisins(G1);
		D.addVoisins(G2);
		E.addVoisins(G1);
		E.addVoisins(G2);
		G1.addVoisins(S);

		// Création de la map à double clé pour stocker la valeur des poids des branches
		Map<Cle<String, String>, Integer> mapPoids = new HashMap<Cle<String, String>, Integer>();

		// Création des clés et ajout des valeurs dans la map
		Cle<String, String> cle1 = new Cle<String, String>(S.getNom(), A.getNom());
		mapPoids.put(cle1, 2);
		Cle<String, String> cle2 = new Cle<String, String>(S.getNom(), C.getNom());
		mapPoids.put(cle2, 3);
		Cle<String, String> cle3 = new Cle<String, String>(A.getNom(), B.getNom());
		mapPoids.put(cle3, 1);
		Cle<String, String> cle4 = new Cle<String, String>(A.getNom(), E.getNom());
		mapPoids.put(cle4, 8);
		Cle<String, String> cle5 = new Cle<String, String>(B.getNom(), S.getNom());
		mapPoids.put(cle5, 2);
		Cle<String, String> cle6 = new Cle<String, String>(B.getNom(), G1.getNom());
		mapPoids.put(cle6, 4);
		Cle<String, String> cle7 = new Cle<String, String>(B.getNom(), D.getNom());
		mapPoids.put(cle7, 1);
		Cle<String, String> cle8 = new Cle<String, String>(B.getNom(), C.getNom());
		mapPoids.put(cle8, 1);
		Cle<String, String> cle9 = new Cle<String, String>(C.getNom(), D.getNom());
		mapPoids.put(cle9, 1);
		Cle<String, String> cle10 = new Cle<String, String>(C.getNom(), G2.getNom());
		mapPoids.put(cle10, 5);
		Cle<String, String> cle11 = new Cle<String, String>(D.getNom(), G1.getNom());
		mapPoids.put(cle11, 5);
		Cle<String, String> cle12 = new Cle<String, String>(D.getNom(), G2.getNom());
		mapPoids.put(cle12, 1);
		Cle<String, String> cle13 = new Cle<String, String>(E.getNom(), G1.getNom());
		mapPoids.put(cle13, 9);
		Cle<String, String> cle14 = new Cle<String, String>(E.getNom(), G2.getNom());
		mapPoids.put(cle14, 2);
		Cle<String, String> cle15 = new Cle<String, String>(G1.getNom(), S.getNom());
		mapPoids.put(cle15, 4);

		LinkedList<PointGrapheTP2> ouvert = new LinkedList<PointGrapheTP2>();
		LinkedList<PointGrapheTP2> fermer = new LinkedList<PointGrapheTP2>();
		ouvert.add(S);

		ArrayList<PointGrapheTP2> cibles = new ArrayList<PointGrapheTP2>();
		cibles.add(G1);
		cibles.add(G2);

		bestFirstSearch(ouvert, fermer, cibles);

		// Réinitialisation des piles
		ouvert.clear();
		fermer.clear();
		ouvert.add(S);

		branchAndBound(ouvert, fermer, cibles, mapPoids);

		// Réinitialisation des piles
		ouvert.clear();
		fermer.clear();
		ouvert.add(S);

		algoA(ouvert, fermer, cibles, mapPoids);
	}
}
