package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends Exception {

		private static final long serialVersionUID = 1L;
		private double amount;
		private double balance;
		public NotEnoughFoundsException(double amount, double balance) {
			this.amount = amount;
			this.balance = balance;
		}
		
		public String toString() {
			return "NotEnoughFoundsException [amountRequest=" + amount + ", balance=" + balance + "]";
		}
		public String getMessage() {
			return this.toString();
		}
		
		
}
