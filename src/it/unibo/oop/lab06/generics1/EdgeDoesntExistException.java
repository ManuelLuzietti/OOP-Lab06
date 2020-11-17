package it.unibo.oop.lab06.generics1;

public class EdgeDoesntExistException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public String toString() {
		return "edge doesn't exist";
	}
	public String getMessage() {
		return this.toString();
	}

}
