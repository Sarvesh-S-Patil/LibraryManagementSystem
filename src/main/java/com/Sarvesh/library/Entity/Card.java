package com.Sarvesh.library.Entity;

import java.io.Serializable;

import java.sql.Date;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;




@Entity
@Table(name="card")
public class Card implements Serializable {
//	1. Id 2. Status 3. Email 4. ValidUpto 5. CreatedOn 6. UpdatedOn
	@Id
	@Column(name="cardId")
	private int cardId;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ValidUpto")
	private Date validUpto;
	
	@Column(name="CreatedOn")
	private Date createdOn;
	
	@Column(name="updatedOn")
	private Date updatedOn;
	
	@OneToOne(mappedBy = "studentCard",cascade = CascadeType.ALL)
	@JoinColumn(name = "student_id")
	@JsonIgnore
	private Student student;
	
	@OneToMany(mappedBy = "transactionCard")
	private List<Transaction> transaction;
	

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Card(int cardId, boolean status, String email, Date validUpto, Date createdOn, Date updatedOn) {
		super();
		this.cardId = cardId;
		this.status = status;
		this.email = email;
		this.validUpto = validUpto;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	
	
	public Card(int cardId, boolean status, String email, Date validUpto, Date createdOn, Date updatedOn,
			Student student, List<Transaction> transaction) {
		super();
		this.cardId = cardId;
		this.status = status;
		this.email = email;
		this.validUpto = validUpto;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.student = student;
		this.transaction = transaction;
	}




	public int getCardId() {
		return cardId;
	}


	public void setCardId(int cardId) {
		this.cardId = cardId;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getValidUpto() {
		return validUpto;
	}


	public void setValidUpto(Date validUpto) {
		this.validUpto = validUpto;
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


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public List<Transaction> getTransaction() {
		return transaction;
	}


	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	
	
	
	

}
