package com.anarghya.entity;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payment_Table")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cardNumber;
	private String uplNumber;
	private String expirationDate;
	private Integer cvv;
	
	private String transactionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	

	

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUplNumber() {
		return uplNumber;
	}

	public void setUplNumber(String uplNumber) {
		this.uplNumber = uplNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	@PrePersist
	private void onCreate() {
		if (transactionId == null) {
			this.transactionId = generateRandomtransactionId(12);
		}

	}

	private String generateRandomtransactionId(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder orderIdBuilder = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			orderIdBuilder.append(characters.charAt(random.nextInt(characters.length())));
		}
		return orderIdBuilder.toString();
	}
}
