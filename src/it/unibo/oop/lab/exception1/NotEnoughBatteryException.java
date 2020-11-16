package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private final int x;
	private final int y;
	
	public NotEnoughBatteryException(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	public String getMessage() {
		return this.toString();
	}
	
	public String toString() {
		return "Not enough battery level to move into position: (" + this.x + ", " + this.y + ")";
	}
}
