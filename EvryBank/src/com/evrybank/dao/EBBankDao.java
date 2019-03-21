package com.evrybank.dao;

import com.evrybank.entity.Account;
import com.evrybank.entity.Customer;
import com.evrybank.entity.Transaction;

/**
 * @author DEEPAK J A
 *
 */
public interface EBBankDao {

	
	// GET ACCOUNT INFO USING ID
	public Account getAccountInfo(Integer accountNumber);
	
	// UPDATE ACCOUNT
	public boolean updateAccount(Account account, Integer updatedAmount);
	
	// CREATE ACCOUNT
	public boolean createAccount(Account account);
	
	
	// UPDATE TRANSACTION
	public boolean updateTransaction(Transaction transaction);
		
	//CREATE TRANSACTION
	boolean createTransaction(Transaction transaction, Customer customer);
}
