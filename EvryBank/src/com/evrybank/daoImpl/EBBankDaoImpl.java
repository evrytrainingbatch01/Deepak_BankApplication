package com.evrybank.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.evrybank.dao.EBBankDao;
import com.evrybank.entity.Account;
import com.evrybank.entity.Admin;
import com.evrybank.entity.Customer;
import com.evrybank.entity.Transaction;
import com.evrybank.util.EBDatabaseUtil;

public class EBBankDaoImpl implements EBBankDao{

	//Get connection
	Connection con = EBDatabaseUtil.getConnection();
	
	//GET ACCOUNT
	@Override
	public Account getAccountInfo(Integer accountNumber) {
		ResultSet rs;
		Statement statement = null;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery("SELECT * FROM ACCOUNT WHERE ACC_NUMBER=" + accountNumber);
			if (rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt(1));
				account.setAccountNumber(rs.getInt(2));
				account.setAccountbalance(rs.getInt(3));

				return account;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		return null;
	}
	
	// UPDATE ACCOUNT
	public boolean updateAccount(Account account, Integer updatedAmount) {
		PreparedStatement ps = null;
		 try {
		        ps = con.prepareStatement("UPDATE ACCOUNT SET ACC_BALANCE=? WHERE ID=?");
		        ps.setInt(1, updatedAmount);
		        ps.setInt(2, account.getId());
		        int i = ps.executeUpdate();
		      if(i == 1) {
		    	  return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return false;
	}

	// CREATE ACCOUNT
	@Override
	public boolean createAccount(Account account) {
		PreparedStatement ps = null;
		 try {
		        ps = con.prepareStatement("INSERT INTO ACCOUNT(ACC_NUMBER, ACC_BALANCE) VALUES(?, ?)");
		        ps.setInt(1, account.getAccountNumber());
		        ps.setInt(2, account.getAccountbalance());
		        
//		        ps.setInt(3, new Integer(0)); //for now later it will be transaction id
		        int i = ps.executeUpdate();
		      if(i == 1) {
		    	  return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return false;
	}

	// CREATE TRANSACTION
	@Override
	public boolean createTransaction(Transaction transaction, Customer customer) {
		PreparedStatement ps = null;
		 try {
		        ps = con.prepareStatement("INSERT INTO TRANSACTION VALUES(TRANSACTION_TYPE=?, AMT_CREDITED=?, AMT_DEBITED=?, CUSTOMER_ID=?, ACC_ID=?, TRANSACTION_ID=?)");
		        ps.setString(1, transaction.getTransactionType().toString());
		        ps.setInt(2, transaction.getAmountCredited());
		        ps.setInt(3, transaction.getAmountDebited());
		        ps.setInt(4, customer.getId());
		        ps.setInt(4, customer.getCustomerAccountId());
		        ps.setInt(6, transaction.getId());
		        int i = ps.executeUpdate();
		      if(i == 1) {
		    	  return true;
		      }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		return false;
	}
	
	// UPDATE TRANSACTION
		@Override
		public boolean updateTransaction(Transaction transaction) {
			// TODO Auto-generated method stub
			return false;
		}

}
