package com.ia.tp2_2;

class Cle<C1, C2> {
	public C1 cle1;
	public C2 cle2;

	public Cle(C1 cle1, C2 cle2) {
		this.cle1 = cle1;
		this.cle2 = cle2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Cle cle = (Cle) o;

		if (cle1 != null ? !cle1.equals(cle.cle1) : cle.cle1 != null)
			return false;
		if (cle2 != null ? !cle2.equals(cle.cle2) : cle.cle2 != null)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = cle1 != null ? cle1.hashCode() : 0;
		result = 31 * result + (cle2 != null ? cle2.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "[" + cle1 + ", " + cle2 + "]";
	}
}