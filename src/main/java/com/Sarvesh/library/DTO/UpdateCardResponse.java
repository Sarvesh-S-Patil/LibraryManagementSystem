package com.Sarvesh.library.DTO;

import java.sql.Date;


public class UpdateCardResponse {
	private int cardId;
	private boolean status;
	private String email;
	private Date validUpto;
	private Date createdOn;
	private Date updatedOn;
	public UpdateCardResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateCardResponse(int cardId, boolean status, String email, Date validUpto, Date createdOn,
			Date updatedOn) {
		super();
		this.cardId = cardId;
		this.status = status;
		this.email = email;
		this.validUpto = validUpto;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
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

}
