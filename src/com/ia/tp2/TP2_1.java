package com.ia.tp2;

import java.util.Scanner;
import java.util.Stack;

public class TP2_1 {

	public static void Initialiser(int nbDisques) { // Intialisation des piles
		PileNommee depart = new PileNommee("Départ", new Stack<Disque>());
		PileNommee intermediaire = new PileNommee("Intermediaire", new Stack<Disque>());
		PileNommee arrivee = new PileNommee("Arrivée", new Stack<Disque>());

		for (int i = nbDisques; i > 0; i--) {
			depart.getPile().push(new Disque(i));
		}

		System.out.println(depart.toStringAlgo());
		System.out.println(intermediaire.toStringAlgo());
		System.out.println(arrivee.toStringAlgo());
		Hanoi(nbDisques, depart, arrivee, intermediaire);
	}

	public static void Hanoi(int nbDisques, PileNommee depart, PileNommee intermediaire, PileNommee arrivee) {
		// Fonction récursive qui permet de résoudre le problème des tours de Hanoi
		if (nbDisques > 0) {
			Hanoi(nbDisques - 1, depart, arrivee, intermediaire);
			arrivee.getPile().push(depart.getPile().pop());
			System.out.println("--------------------------------------------");
			System.out.println(depart.toStringAlgo());
			System.out.println(intermediaire.toStringAlgo());
			System.out.println(arrivee.toStringAlgo());
			Hanoi(nbDisques - 1, intermediaire, depart, arrivee);
		}
	}

	public static void main(String[] args) {
		// Récupération du nombre de disque
		System.out.println("Veuillez saisir le nombre de disque:");
		Scanner scan = new Scanner(System.in);
		Initialiser(scan.nextInt());
		scan.close();

	}
}
