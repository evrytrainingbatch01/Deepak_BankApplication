package com.evrybank.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.evrybank.dao.EBAdminDao;
import com.evrybank.entity.Admin;
import com.evrybank.util.EBDatabaseUtil;

/**
 * @author DEEPAK J A
 *
 */
public class EBAdminDaoImpl implements EBAdminDao {

	//Get connection
	Connection con = EBDatabaseUtil.getConnection();

	// GET ALL ADMINS
	public Set<Admin> getAllAdmins() {

		Set<Admin> setOfAdmins = new HashSet<>();

		String sqlQueryString = "SELECT * FROM ADMIN";
		ResultSet rs = null;
		Statement statement = null;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sqlQueryString);
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt(1));
				admin.setFirstname(rs.getString(2));
				admin.setLastname(rs.getString(3));
				admin.setAge(rs.getInt(4));
				setOfAdmins.add(admin);
				// System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
				// + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return setOfAdmins;
	}

	// GET ADMIN USING ID
	public Admin getAdmin(Integer id) {
		ResultSet rs;
		Statement statement = null;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM ADMIN WHERE ID=" + id);
			if (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt(1));
				admin.setFirstname(rs.getString(2));
				admin.setLastname(rs.getString(3));
				admin.setAge(rs.getInt(4));

				return admin;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		return null;
	}

	// DELETE ADMIN
	public boolean deleteAdmin(Admin admin, Integer id) {
		
		PreparedStatement ps = null;
		try {
			 ps = con.prepareStatement("DELETE FROM ADMIN WHERE ID = ?");
			ps.setInt(1, admin.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	// UPDATE ADMIN
		public boolean updateAdmin(Admin admin) {
			
			PreparedStatement ps = null;
			 try {
			        ps = con.prepareStatement("UPDATE ADMIN SET FIRSTNAME=?, LASTNAME=?, AGE=? WHERE ID=?");
			        ps.setString(1, admin.getFirstname());
			        ps.setString(2, admin.getLastname());
			        ps.setInt(3, admin.getAge());
			        ps.setInt(4, admin.getId());
			        int i = ps.executeUpdate();
			      if(i == 1) {
			    	  return true;
			      }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			return false;
		}

	

}
