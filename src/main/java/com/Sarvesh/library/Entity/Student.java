package com.Sarvesh.library.Entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="student")
public class Student {
//	1. Id 2. Age 3. Name 4. Country 5. Email 6. Phone Number 7. CreatedOn 8. UpdatedOn 9. CardId
	@Id
	@Column(name="studentId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int studentId;
	
	@Column(name="age")
	private int age;
	
	@Column(name="Country")
	private String Country;
	@Column(name="email")
	private String email;
	
	@Column(name="phoneNumber")
	private int phoneNumber;
	
	@Column(name="CreatedOn")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdOn;
	
	@Column(name="UpdatedOn")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updatesOn;
	
	@OneToOne
	@JsonManagedReference
	private Card studentCard;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Student(int studentId, int age, String country, String email, int phoneNumber, Date createdOn,
			Date updatesOn, Card card) {
		super();
		this.studentId = studentId;
		this.age = age;
		this.Country = country;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.createdOn = createdOn;
		this.updatesOn = updatesOn;
		this.studentCard = card;
	}



	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatesOn() {
		return updatesOn;
	}

	public void setUpdatesOn(Date updatesOn) {
		this.updatesOn = updatesOn;
	}



	public Card getStudentCard() {
		return studentCard;
	}



	public void setStudentCard(Card studentCard) {
		this.studentCard = studentCard;
	}

	
	
	
	
	
	
}
