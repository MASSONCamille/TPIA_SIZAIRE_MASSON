package com.ia.tp2.model;

import java.util.Stack;
import java.util.Scanner;

public class AlgoMain {
	
	
	public static EtatJeu Hanoi(int nbdisque, EtatJeu j) {
		if(nbdisque !=0) {
			j.inverse(false);
			j = Hanoi(nbdisque-1, j);
			j.inverse(false);
			
			j.getArrivee().getPile().push(j.getDepart().getPile().pop());
			j.setNbt(j.getNbt()+1);
			System.out.println("--------------------------");
			System.out.println(new EtatJeu(j).toString());
			
			
			j.inverse(true);
			j = Hanoi(nbdisque-1, j);
			j.inverse(true);
		}
		return j;
	}
	
	
	
	
	
	public static void main (String[] arg) {
		Scanner sc = new Scanner(System.in);
		System.out.println("NB de disque : ");
		int nbDisque = sc.nextInt();
		

		Stack<Disque> pd = new Stack<Disque>();
		Stack<Disque> pi = new Stack<Disque>();
		Stack<Disque> pa = new Stack<Disque>();
		
		for (int i = 0; i < nbDisque; i++) {
			pd.push(new Disque(nbDisque - i));
		}
		
		Tour d = new Tour(pd, TypeTour.D);
		Tour i = new Tour(pi, TypeTour.I);
		Tour a = new Tour(pa, TypeTour.A);
		
		EtatJeu j = new EtatJeu(d, i, a, 0);
		
		System.out.println("--------------------------");
		System.out.println(j.toString());
		Hanoi(nbDisque, j);
	}
}
