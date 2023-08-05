package com.Sarvesh.library.Entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Entity
@Table(name="transaction")
public class Transaction  implements Serializable {
//	1. Id 2. CardID 3. BookID 4. TransactionDate 5. BookDueDate 6. IsIssued 
//	7. IsReturned 8. FineAmount 9. Status 10. CreatedOn 11. UpdatedOn
	
	@Id
	@Column(name="transactionId")
	private int transactionId;
	
	@Column(name="transactionDate")
	private Date transactionDate;
	
	@Column(name="bookDueDate")
	private Date bookDueDate;
	
	@Column(name="isIssued")
	boolean isIssued;
	
	@Column(name="isReturned")
	boolean isReturned;
	
	@Column(name="FineAmount")
	int fineAmount;
	
	@Column(name="status")
	boolean status;
	
	@Column(name="CreatedOn")
	private Date createdOn;
	
	@Column(name="updatedOn")
	private Date updatedOn;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Book transactionBook;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Card transactionCard;
	

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transaction(int transactionId, Date transactionDate, Date bookDueDate, boolean isIssued, boolean isReturned,
			int fineAmount, boolean status, Date createdOn, Date updatedOn) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.bookDueDate = bookDueDate;
		this.isIssued = isIssued;
		this.isReturned = isReturned;
		this.fineAmount = fineAmount;
		this.status = status;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;

	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public Date getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}


	public Date getBookDueDate() {
		return bookDueDate;
	}


	public void setBookDueDate(Date bookDueDate) {
		this.bookDueDate = bookDueDate;
	}


	public boolean isIssued() {
		return isIssued;
	}


	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}


	public boolean isReturned() {
		return isReturned;
	}


	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}


	public int getFineAmount() {
		return fineAmount;
	}


	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}


	public Book getTransactionBook() {
		return transactionBook;
	}


	public void setTransactionBook(Book transactionBook) {
		this.transactionBook = transactionBook;
	}


	public Card getTransactionCard() {
		return transactionCard;
	}


	public void setTransactionCard(Card transactionCard) {
		this.transactionCard = transactionCard;
	}


	
	
	
	

}
