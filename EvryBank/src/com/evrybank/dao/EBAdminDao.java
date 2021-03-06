package com.evrybank.dao;

import java.util.Set;

import com.evrybank.entity.Admin;
import com.evrybank.entity.Customer;

/**
 * @author DEEPAK J A
 *
 */
public interface EBAdminDao {
	
	// GET ALL ADMINS
	public Set<Admin> getAllAdmins();
	
	// GET ADMIN USING ID
	public Admin getAdmin(Integer id);
	
	// DELETE ADMIN
	public boolean deleteAdmin(Admin admin, Integer id);
	
	// UPDATE ADMIN
	public boolean updateAdmin(Admin admin);
	
	// ADD CUSTOMER
	public boolean addCustomer(Customer customer);
	
	
	// GET ALL CUSTOMERS
	public Set<Customer> getAllCustomers();
	
	// GET CUSTOMER USING ID
	public Customer getCustomer(Integer id);
	
	// DELETE CUSTOMER
	public boolean deleteCustomer(Customer customer, Integer id);
	
}
