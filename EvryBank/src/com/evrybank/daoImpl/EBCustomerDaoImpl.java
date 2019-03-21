package com.evrybank.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.evrybank.dao.EBCustomerDao;
import com.evrybank.entity.Admin;
import com.evrybank.entity.Customer;
import com.evrybank.util.EBDatabaseUtil;

/**
 * @author DEEPAK J A
 *
 */
public class EBCustomerDaoImpl implements EBCustomerDao{

		//Get connection
		Connection con = EBDatabaseUtil.getConnection();
		
			// UPDATE CUSTOMER
			public boolean updateCustomer(Customer customer, Integer accountNumberOfCustomer) {
				PreparedStatement ps = null;
				 try {
				        ps = con.prepareStatement("UPDATE CUSTOMER SET FIRSTNAME=?, LASTNAME=?, AGE=?, CITY=?, COUNTRY=?, PHONENUMBER=?, BALAMOUNT=?, ACC_ID=?");
				        ps.setString(1, customer.getFirstname());
				        ps.setString(2, customer.getLastname());
				        ps.setInt(3, customer.getAge());
				        ps.setString(4, customer.getCity());
				        ps.setString(5, customer.getCountry());
				        ps.setInt(6, customer.getPhoneNumber());
				        ps.setInt(7, customer.getBalAmount());
				        ps.setInt(8, customer.getCustomerAccountId());
//				        ps.setInt(9, idOfCustomer);
				        
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
