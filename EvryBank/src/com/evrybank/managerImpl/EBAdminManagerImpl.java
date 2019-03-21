package com.evrybank.managerImpl;

import java.util.Set;

import com.evrybank.daoImpl.EBAdminDaoImpl;
import com.evrybank.entity.Admin;
import com.evrybank.entity.Customer;
import com.evrybank.manager.EBAdminManager;

/**
 * @author DEEPAK J A
 *
 */
public class EBAdminManagerImpl implements EBAdminManager{

	
	EBAdminDaoImpl ebAdminDao = new EBAdminDaoImpl();
	

	@Override
	public Set<Admin> getAllAdmins() {
		return ebAdminDao.getAllAdmins();
	}

	@Override
	public Admin getAdmin(Integer id) {
		return ebAdminDao.getAdmin(id);
	}
	
	@Override
	public boolean deleteAdmin(Admin admin, Integer id) {
		return ebAdminDao.deleteAdmin(admin, id);
	}
	
	@Override
	public boolean updateAdmin(Admin admin) {
		return ebAdminDao.updateAdmin(admin);
	}
	
	@Override
	public Set<Customer> getAllCustomers() {
		return ebAdminDao.getAllCustomers();
	}
	
	@Override
	public boolean addCustomer(Customer customer) {
		return ebAdminDao.addCustomer(customer);
	}
	
	@Override
	public Customer getCustomer(Integer id) {
		return ebAdminDao.getCustomer(id);
	}

	@Override
	public boolean deleteCustomer(Customer customer, Integer id) {
		return ebAdminDao.deleteCustomer(customer, id);
	}
	

}
