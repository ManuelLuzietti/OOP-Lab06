package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private int idAspected;
	private int idActual;
	public WrongAccountHolderException(final int idaspected, final int idactual) {
		this.idAspected = idaspected;
		this.idActual = idactual;
	}
	
	public String toString() {
		return "Wrong usrID, operation not permitted, aspected: " + this.idAspected + " Actual: " + this.idActual;
	}
	
	public String getMessage() {
		return this.toString();
	}
	
	
}
