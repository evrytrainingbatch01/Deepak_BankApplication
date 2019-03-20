package com.evrybank.manager;

import java.util.Set;
import com.evrybank.entity.Admin;
import com.evrybank.entity.Customer;

/**
 * @author DEEPAK J A
 *
 */

public interface EBAdminManager {
	
		//getAllAdmins
		public Set<Admin> getAllAdmins();
		
		//getAdmin
	    public Admin getAdmin(Integer id);
	    
	    //deleteAdmin
	    public boolean deleteAdmin(Admin admin,Integer id);
	    
	    //updateAdmin
	    public boolean updateAdmin(Admin admin);
	
	    //add customer
	    public boolean addCustomer(Customer customer);
}
