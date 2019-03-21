package com.evrybank.manager;

import com.evrybank.entity.Account;
import com.evrybank.entity.Customer;
import com.evrybank.entity.Transaction;
/**
 * @author DEEPAK J A
 *
 */
public interface EBBankManager {

	//getAccountInfo
    public Account getAccountInfo(Integer accountNumber);
    
    //createAccount
    public boolean createAccount(Account account);
  
    //updateAccount
    public boolean updateAccount(Account account, Integer updatedAmount);
    
    
    //createTransaction
    public boolean  createTransaction(Transaction transaction, Customer customer);
    
  //createTransaction
    public void updateTransaction(Transaction transaction);
}
