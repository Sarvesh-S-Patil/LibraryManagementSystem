package com.Sarvesh.library.Entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.ToString;

@ToString
@Entity
@Table(name="Author")
public class Author implements Serializable{
	// 1. Id 2. Name 3. Email 4. Age 5. Country
	@Id
	@Column(name="authorId")
	private int authorId;
	@Column(name="name")
	private int name;
	@Column(name="email")
	private String email;
	@Column(name="age")
	private int age;
	@Column(name="country")
	private String country;
	@OneToOne
	@PrimaryKeyJoinColumn
	@JsonIgnore
	private Book book;
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(int authorId, int name, String email, int age, String country, Book book) {
		super();
		this.authorId = authorId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.country = country;
		this.book = book;
	}
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getName() {
		return name;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}
