package com.Sarvesh.library.DTO.Student;

import com.Sarvesh.library.Entity.Card;

public class UpdateCardRequest {
	
	private int studentId;
	private Card card;
	public UpdateCardRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateCardRequest(int studentId, Card card) {
		super();
		this.studentId = studentId;
		this.card = card;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	
	

}
