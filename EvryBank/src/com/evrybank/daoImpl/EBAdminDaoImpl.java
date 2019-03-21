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
import com.evrybank.entity.Customer;
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

		//ADD CUSTOMER
		@Override
		public boolean addCustomer(Customer customer) {
			PreparedStatement ps = null;
			 try {
			        ps = con.prepareStatement("INSERT INTO CUSTOMER(FIRSTNAME,LASTNAME,AGE,CITY,COUNTRY,PHONENUMBER,BALAMOUNT) VALUES (?, ?, ?, ?, ?, ?, ?)");
			        ps.setString(1, customer.getFirstname());
			        ps.setString(2, customer.getLastname());
			        ps.setInt(3, customer.getAge());
			        ps.setString(4, customer.getCity());
			        ps.setString(5, customer.getCountry());
			        ps.setInt(6, customer.getPhoneNumber());
			        ps.setInt(7, customer.getBalAmount());
			        int i = ps.executeUpdate();
			      if(i == 1) {
			    	  return true;
			      }
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			return false;
		}

		// GET ALL CUSTOMERS
		public Set<Customer> getAllCustomers() {
			Set<Customer> setOfCustomers = new HashSet<>();

			String sqlQueryString = "SELECT * FROM CUSTOMER";
			ResultSet rs = null;
			Statement statement = null;
			try {
				statement = con.createStatement();
				rs = statement.executeQuery(sqlQueryString);
				while (rs.next()) {
					Customer customer = new Customer();
					customer.setId(rs.getInt(1));
					customer.setFirstname(rs.getString(2));
					customer.setLastname(rs.getString(3));
					customer.setAge(rs.getInt(4));
					customer.setCity(rs.getString(5));
					customer.setCountry(rs.getString(6));
					customer.setPhoneNumber(rs.getInt(7));
					customer.setBalAmount(rs.getInt(8));
					setOfCustomers.add(customer);
					// System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
					// + rs.getString(3));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 

			return setOfCustomers;
		}

		//GET CUSTOMER
		@Override
		public Customer getCustomer(Integer id) {
			ResultSet rs;
			Statement statement = null;
			try {
				statement = con.createStatement();
				rs = statement.executeQuery("SELECT * FROM CUSTOMER WHERE ID=" + id);
				if (rs.next()) {
					Customer customer = new Customer();
					customer.setId(rs.getInt(1));
					customer.setFirstname(rs.getString(2));
					customer.setLastname(rs.getString(3));
					customer.setAge(rs.getInt(4));
					customer.setCity(rs.getString(5));
					customer.setCountry(rs.getString(6));
					customer.setPhoneNumber(rs.getInt(7));
					customer.setBalAmount(rs.getInt(8));

					return customer;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} 
			return null;
		}

		// DELETE CUSTOMER
		public boolean deleteCustomer(Customer customer, Integer id) {
			
			PreparedStatement ps = null;
			try {
				 ps = con.prepareStatement("DELETE FROM CUSTOMER WHERE ID = ?");
				ps.setInt(1, customer.getId());
				int i = ps.executeUpdate();
				if (i == 1) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
}
