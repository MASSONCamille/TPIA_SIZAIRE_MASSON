package com.ia.tp2.model;

public class Disque {
	private int num;

	
	public Disque(int num) {
		super();
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Disque_" + num;
	}
	
}
