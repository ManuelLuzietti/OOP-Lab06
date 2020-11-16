package it.unibo.oop.lab.exception2;

/**
 * Class modeling a BankAccount with strict policies: getting money is allowed
 * only with enough founds, and there are also a limited number of free ATM
 * transaction (this number is provided as a input in the constructor).
 * 
 */
public class StrictBankAccount implements BankAccount {

    private final int usrID;
    private double balance;
    private int nTransactions;
    private final int nMaxATMTransactions;
    private static final double ATM_TRANSACTION_FEE = 1;
    private static final double MANAGEMENT_FEE = 5;
    private static final double TRANSACTION_FEE = 0.1;

    /**
     * 
     * @param usrID
     *            user id
     * @param balance
     *            initial balance
     * @param nMaxATMTransactions
     *            max no of ATM transactions allowed
     */
    public StrictBankAccount(final int usrID, final double balance, final int nMaxATMTransactions) {
        this.usrID = usrID;
        this.balance = balance;
        this.nMaxATMTransactions = nMaxATMTransactions;
    }

    /**
     * 
     * {@inheritDoc}
     * @throws WrongAccountHolderException 
     */
    public void deposit(final int usrID, final double amount) throws WrongAccountHolderException {
        	checkUser(usrID);
            this.balance += amount;
            incTransactions();
        
    }

    /**
     * 
     * {@inheritDoc}
     * @throws NotEnoughFoundsException 
     */
    public void withdraw(final int usrID, final double amount) throws WrongAccountHolderException, NotEnoughFoundsException{
    	checkUser(usrID);
    	isWithdrawAllowed(amount) ;
    	this.balance -= amount;
    	incTransactions();


    }

    /**
     * 
     * {@inheritDoc}
     * @throws WrongAccountHolderException 
     * @throws TransactionsOverQuotaException 
     */
    public void depositFromATM(final int usrID, final double amount) throws WrongAccountHolderException, TransactionsOverQuotaException {
        if (nTransactions < nMaxATMTransactions) {
            this.deposit(usrID, amount - StrictBankAccount.ATM_TRANSACTION_FEE);
            nTransactions++;
        } else {
        	throw new TransactionsOverQuotaException(nMaxATMTransactions);
        }
    }

    /**
     * 
     * {@inheritDoc}
     * @throws WrongAccountHolderException 
     * @throws NotEnoughFoundsException 
     */
    public void withdrawFromATM(final int usrID, final double amount) throws WrongAccountHolderException, NotEnoughFoundsException, TransactionsOverQuotaException {
        if (nTransactions < nMaxATMTransactions) {
            this.withdraw(usrID, amount + StrictBankAccount.ATM_TRANSACTION_FEE);
        } else {
        	throw new TransactionsOverQuotaException(nMaxATMTransactions);
        }
    }

    /**
     * 
     * {@inheritDoc}
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public int getNTransactions() {
        return nTransactions;
    }

    /**
     * 
     * @param usrID
     *            id of the user related to these fees
     * @throws NotEnoughFoundsException 
     */
    public void computeManagementFees(final int usrID) throws WrongAccountHolderException, NotEnoughFoundsException{
    	final double feeAmount = MANAGEMENT_FEE + (nTransactions * StrictBankAccount.TRANSACTION_FEE);
    	checkUser(usrID);
    	isWithdrawAllowed(feeAmount) ;
    	balance -= MANAGEMENT_FEE + nTransactions * StrictBankAccount.TRANSACTION_FEE;
    	nTransactions = 0;


    }

    private void checkUser(final int id) throws WrongAccountHolderException{
        if(this.usrID != id) {
        	throw new WrongAccountHolderException(this.usrID, id);
        }
    }

    private void isWithdrawAllowed(final double amount) throws NotEnoughFoundsException{
        if(this.balance > amount) {
        	throw new NotEnoughFoundsException(amount, this.balance);
        }
    }

    private void incTransactions() {
        nTransactions++;
    }
}
