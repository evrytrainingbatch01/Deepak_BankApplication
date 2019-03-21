package com.evrybank.managerImpl;

import com.evrybank.daoImpl.EBCustomerDaoImpl;
import com.evrybank.entity.Customer;
import com.evrybank.manager.EBCustomerManager;

/**
 * @author DEEPAK J A
 *
 */
public class EBCustomerManagerImpl implements EBCustomerManager{
	
	EBCustomerDaoImpl ebCustomerDao = new EBCustomerDaoImpl();
	
	
	@Override
	public boolean updateCustomer(Customer customer, Integer accountNumberOfCustomer) {
		return ebCustomerDao.updateCustomer(customer,accountNumberOfCustomer);
	}
	
}
