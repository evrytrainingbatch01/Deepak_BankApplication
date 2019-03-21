package com.evrybank.entity;
/**
 * @author DEEPAK J A
 *
 */
public class Transaction {
	
	private Integer id;
	private TransactionType transactionType;
	private Integer amountCredited;
	private Integer amountDebited;
	private Integer customerId;
	
	public Transaction(){
		
	}

	public Transaction(TransactionType transactionType, Integer amountCredited, Integer amountDebited,
			Integer customerId) {
		super();
		this.transactionType = transactionType;
		this.amountCredited = amountCredited;
		this.amountDebited = amountDebited;
		this.customerId = customerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getAmountCredited() {
		return amountCredited;
	}

	public void setAmountCredited(Integer amountCredited) {
		this.amountCredited = amountCredited;
	}

	public Integer getAmountDebited() {
		return amountDebited;
	}

	public void setAmountDebited(Integer amountDebited) {
		this.amountDebited = amountDebited;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
}
