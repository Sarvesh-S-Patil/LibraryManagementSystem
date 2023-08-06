package com.Sarvesh.library.DTO;

import com.Sarvesh.library.Entity.Transaction;

public class AddTransactionRequest {
	Transaction transaction;
	int bookId;
	int cardId;
	
	
	public Transaction getTransaction() {
		return transaction;
	}


	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public int getCardId() {
		return cardId;
	}


	public void setCardId(int cardId) {
		this.cardId = cardId;
	}


	public AddTransactionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AddTransactionRequest(Transaction transaction, int bookId, int cardId) {
		super();
		this.transaction = transaction;
		this.bookId = bookId;
		this.cardId = cardId;
	}
	
	

}
