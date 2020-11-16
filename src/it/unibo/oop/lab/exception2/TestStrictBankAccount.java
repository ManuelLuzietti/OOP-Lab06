package it.unibo.oop.lab.exception2;

import org.junit.Test;

import static org.junit.Assert.fail;

import org.junit.*;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
	private final static int  NMAXATMTRANSACTIONS = 10;
	private final static int INITIALBALANCE = 10_000;
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	AccountHolder accHolder1 = new AccountHolder("Oliver", "Sykes", 1);
    	AccountHolder accHolder2 = new AccountHolder("Lil", "Peep", 2);
    	
    	BankAccount bankAcc1 = new StrictBankAccount(accHolder1.getUserID(),TestStrictBankAccount.INITIALBALANCE, TestStrictBankAccount.NMAXATMTRANSACTIONS);
    	BankAccount bankAcc2 = new StrictBankAccount(accHolder2.getUserID(),TestStrictBankAccount.INITIALBALANCE, TestStrictBankAccount.NMAXATMTRANSACTIONS);
    	
    	try {
    		bankAcc1.deposit(5, 5000);
    		fail("failed 1° test");
    	} catch (WrongAccountHolderException e) {
    		e.getMessage();
    	}

    	try { 
    		bankAcc1.withdraw(accHolder1.getUserID(), 150000);
    		fail("failed 2° test");
    	} catch (NotEnoughFoundsException e) {
    		e.getMessage();    		
    	} catch (WrongAccountHolderException d) {
    		d.getMessage();
    	}
    	try {
    		int i=0;
    		while(i++ < TestStrictBankAccount.NMAXATMTRANSACTIONS + 50) {
    			bankAcc2.depositFromATM(accHolder2.getUserID(), 1);
    		}
    		fail("failed 3° test");
    	} catch(WrongAccountHolderException e) {
    		e.getMessage();
    	} catch( TransactionsOverQuotaException d) {
    		d.getMessage();
    	}
    }
}
