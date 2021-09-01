package com.ehealthcare.medicare.dto.request;

public class TransactionDetailsRequest {
	
	private String modeOfTransaction;
	private String bankName;
	private Long cardNumber;
	private String nameOnCard;
	private String quantityids;
	private String userId;
	
	public TransactionDetailsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionDetailsRequest(String modeOfTransaction, String bankName, Long cardNumber, String nameOnCard,
			String quantityids, String userId) {
		super();
		this.modeOfTransaction = modeOfTransaction;
		this.bankName = bankName;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.quantityids = quantityids;
		this.userId = userId;
	}

	public String getModeOfTransaction() {
		return modeOfTransaction;
	}

	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
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

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getQuantityids() {
		return quantityids;
	}

	public void setQuantityids(String quantityids) {
		this.quantityids = quantityids;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	

}
