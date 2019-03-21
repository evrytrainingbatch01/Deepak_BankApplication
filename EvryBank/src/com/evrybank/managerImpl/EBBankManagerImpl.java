package com.evrybank.managerImpl;

import com.evrybank.daoImpl.EBBankDaoImpl;
import com.evrybank.entity.Account;
import com.evrybank.entity.Customer;
import com.evrybank.entity.Transaction;
import com.evrybank.manager.EBBankManager;
/**
 * @author DEEPAK J A
 *
 */
public class EBBankManagerImpl implements EBBankManager{

	EBBankDaoImpl ebAccountDao = new EBBankDaoImpl();
	
	@Override
	public Account getAccountInfo(Integer accountNumber) {
		return ebAccountDao.getAccountInfo(accountNumber);
	}
	
	@Override
	public boolean createAccount(Account account) {
		return ebAccountDao.createAccount(account);
	}
	
	@Override
	public boolean updateAccount(Account account, Integer updatedAmount) {
		return ebAccountDao.updateAccount(account,updatedAmount);
	}

	@Override
	public boolean createTransaction(Transaction transaction, Customer customer) {
		return ebAccountDao.createTransaction(transaction, customer);
		
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		
	}
}
