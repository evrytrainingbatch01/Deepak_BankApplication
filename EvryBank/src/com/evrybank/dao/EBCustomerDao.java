package com.evrybank.dao;

import com.evrybank.entity.Customer;

/**
 * @author DEEPAK J A
 *
 */
public interface EBCustomerDao {

	public boolean updateCustomer(Customer customer, Integer idOfCustomer);
}
