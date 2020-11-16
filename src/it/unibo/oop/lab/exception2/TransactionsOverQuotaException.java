package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private int maxAtmTrans;

	public TransactionsOverQuotaException(final int maxAtmTrans) {
		this.maxAtmTrans = maxAtmTrans;
	}

	public String toString() {
		return "TransactionsOverQuotaException, NmaxTransaction: " + this.maxAtmTrans ;
	}
	
	public String getMessage() {
		return this.toString();
	}
	
	
}
