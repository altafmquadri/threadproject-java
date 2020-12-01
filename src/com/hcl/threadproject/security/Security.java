package com.hcl.threadproject.security;
import com.hcl.threadproject.account.Account;
import com.hcl.threadproject.customer.Customer;
import com.hcl.threadproject.exception.UnauthorizedWithdrawTransactionException;

public class Security {
	public void authorization(Account account, Customer customer) throws UnauthorizedWithdrawTransactionException{
		if (account.getCustomer().getCustomerId() != customer.getCustomerId()) {
			throw new UnauthorizedWithdrawTransactionException();
		}
	}
}
