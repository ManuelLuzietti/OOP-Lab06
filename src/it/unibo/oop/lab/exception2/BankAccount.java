package it.unibo.oop.lab.exception2;

/**
 * Models a generic bank account.
 * 
 */
public interface BankAccount {

    /**
     * @param usrID
     *            id of the user requesting this operation
     * @param amount
     *            amount to be withdrawn
     * @throws WrongAccountHolderException 
     * @throws NotEnoughFoundsException 
     */
    void withdraw(int usrID, double amount) throws WrongAccountHolderException, NotEnoughFoundsException;

    /**
     * 
     * @param usrID
     *            id of the user requesting this operation
     * @param amount
     *            amount to be credited
     * @throws WrongAccountHolderException 
     */
    void deposit(int usrID, double amount) throws WrongAccountHolderException;

    /**
     * 
     * @param usrID
     *            id of the user requesting this opera
     * @param amount
     *            amount to be deposited via ATM
     * @throws WrongAccountHolderException 
     * @throws TransactionsOverQuotaException 
     */
    void depositFromATM(int usrID, double amount) throws WrongAccountHolderException, TransactionsOverQuotaException;

    /**
     * 
     * @param usrID
     *            id of the user requesting this opera
     * @param amount
     *            amount to be withdrawn via AT
     * @throws WrongAccountHolderException 
     * @throws NotEnoughFoundsException 
     * @throws TransactionsOverQuotaException 
     */
    void withdrawFromATM(int usrID, double amount) throws WrongAccountHolderException, NotEnoughFoundsException, TransactionsOverQuotaException;

    /**
     * 
     * @return The current balance
     */
    double getBalance();

    /**
     * 
     * @return The total number of transaction for the account
     */
    int getNTransactions();
}
