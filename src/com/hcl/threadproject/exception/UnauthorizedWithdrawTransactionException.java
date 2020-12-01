package com.hcl.threadproject.exception;

public class UnauthorizedWithdrawTransactionException extends Exception {

	public UnauthorizedWithdrawTransactionException(){
		super("The user is unauthorized for the withdrawl");
	}
}
