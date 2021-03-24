package com.ia.tp2.model;

import java.util.Stack;

public class Tour {
	private Stack<Disque> pile;
	private TypeTour type;
	
	public Tour(TypeTour type) {
		super();
		this.pile = new Stack<Disque>();
		this.type = type;
	}
	
	public Tour(Stack<Disque> pile, TypeTour type) {
		super();
		this.pile = pile;
		this.type = type;
	}
	public Stack<Disque> getPile() {
		return pile;
	}
	public void setPile(Stack<Disque> pile) {
		this.pile = pile;
	}
	public TypeTour getType() {
		return type;
	}
	public void setType(TypeTour type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "type = " + this.type + "\n" + pile.toString();
	}
}
