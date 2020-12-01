package com.hcl.threadproject.transaction;
import com.hcl.threadproject.security.Security;
import com.hcl.threadproject.account.Account;
import com.hcl.threadproject.customer.Customer;
import com.hcl.threadproject.exception.*;

public class WithdrawTransaction extends Security implements Runnable {
	
	private int transactionId;
	private Account account;
	private Customer customer;
	private double amount;
	
	public WithdrawTransaction(int transactionId, Account account, Customer customer, double amount) {
		super();
		this.transactionId = transactionId;
		this.account = account;
		this.customer = customer;
		this.amount = amount;
	}
	
	public double withdraw(Account account, double amount) throws InsufficientBalanceException {
		if (account.getBalance() >= amount) {
			account.setBalance(account.getBalance() - amount);
		}else {
			throw new InsufficientBalanceException();
		}
		return account.getBalance();
	}

	@Override
	public void run() {
		try {
			authorization(account, customer);
			double balance = withdraw(account, amount);
			System.out.println(transactionId +  " transaction " + "completed "  + " and the balance amount is " + account.getBalance() );
		} catch (UnauthorizedWithdrawTransactionException unauthorizedWithdrawTransactionException) {
			System.out.println(transactionId + " transaction failed " + unauthorizedWithdrawTransactionException.getMessage());
		} catch (InsufficientBalanceException insufficientBalanceException) {
			System.out.println(transactionId + " transaction failed your account has insufficient balance" );
		}
	}
	
}
