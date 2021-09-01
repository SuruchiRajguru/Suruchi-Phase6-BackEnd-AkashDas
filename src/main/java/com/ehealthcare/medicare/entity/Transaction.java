package com.ehealthcare.medicare.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transactionId;
	private String bankName;
	private Long cardNumber;
	private LocalDateTime dateOfTrans;
	private String modeOfTransaction;
	private String nameOnCard;
	private Double transactionAmount;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Transaction(Integer transactionId, String bankName, Long cardNumber, LocalDateTime dateOfTrans,
			String modeOfTransaction, String nameOnCard, Double transactionAmount) {
		super();
		this.transactionId = transactionId;
		this.bankName = bankName;
		this.cardNumber = cardNumber;
		this.dateOfTrans = dateOfTrans;
		this.modeOfTransaction = modeOfTransaction;
		this.nameOnCard = nameOnCard;
		this.transactionAmount = transactionAmount;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDateTime getDateOfTrans() {
		return dateOfTrans;
	}

	public void setDateOfTrans(LocalDateTime dateOfTrans) {
		this.dateOfTrans = dateOfTrans;
	}

	public String getModeOfTransaction() {
		return modeOfTransaction;
	}

	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", bankName=" + bankName + ", cardNumber=" + cardNumber
				+ ", dateOfTrans=" + dateOfTrans + ", modeOfTransaction=" + modeOfTransaction + ", nameOnCard="
				+ nameOnCard + ", transactionAmount=" + transactionAmount + "]";
	}
	
	
	
	

}
