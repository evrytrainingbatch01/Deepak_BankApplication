package com.evrybank.dao;

import java.util.Set;

import com.evrybank.entity.Admin;

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
	
}
