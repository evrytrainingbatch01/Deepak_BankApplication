package com.evrybank.managerImpl;

import java.util.Set;

import com.evrybank.daoImpl.EBAdminDaoImpl;
import com.evrybank.entity.Admin;
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
	
	public boolean deleteAdmin(Admin admin, Integer id) {
		return ebAdminDao.deleteAdmin(admin, id);
	}
	
	public boolean updateAdmin(Admin admin) {
		return ebAdminDao.updateAdmin(admin);
	}
	
	
	/*@Override
	public boolean addCustomer(Customer customer) {
		return dao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		return dao.deleteCustomer(customer);
		
	}*/

	
	

}
