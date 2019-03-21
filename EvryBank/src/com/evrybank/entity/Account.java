package com.evrybank.entity;

import java.util.List;

public class Account {
	
	private Integer id;
	private Integer accountNumber;
	private Integer accountbalance;
	private Integer customerId;
	private Integer transactionId;
	
	private List<Transaction> transactions;
	
	public Account() {
		
	}

	public Account(Integer id, Integer accountNumber, Integer accountbalance, Integer customerId,
			Integer transactionId) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountbalance = accountbalance;
		this.customerId = customerId;
		this.transactionId = transactionId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getAccountbalance() {
		return accountbalance;
	}

	public void setAccountbalance(Integer accountbalance) {
		this.accountbalance = accountbalance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
}
