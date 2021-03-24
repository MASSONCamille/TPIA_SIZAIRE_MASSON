package com.ia.tp2;

public class Disque {

	int numero;

	public Disque(int numero) {
		super();
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disque other = (Disque) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disque [numero=" + numero + "]";
	}

}
