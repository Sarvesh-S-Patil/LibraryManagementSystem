package com.Sarvesh.library.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.ToString;

@ToString
@Entity
@Table(name="Book")
public class Book implements Serializable {
	// 1. Id 2. Name 3. author_id(mapping) 4. Number of Pages 5. Language 6. Available 7. Genre 8. ISBN Number 9. Published Date
	@Id
	@Column(name="bookId")
	int bookId;
	@Column(name="name")
	String name;
	@Column(name="Number of Pages")
	int numberOfPages;
	@Column(name="Languages")
	String languages;
	@Column(name ="available")
	boolean available;
	@Column(name="Genre")
	String genre;
	@Column(name="ISBN Number")
	String isbnNumber;
	@Column(name="Published Date")
	Date publishedDate;
	
	@OneToOne(mappedBy = "book",cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;
	
	@OneToMany(mappedBy = "transactionBook",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Transaction> transaction;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public List<Transaction> getTransaction() {
		return transaction;
	}


	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}


	public Book(int bookId, String name, int numberOfPages, String languages, boolean available, String genre,
			String isbnNumber, Date publishedDate, Author author, List<Transaction> transaction) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.numberOfPages = numberOfPages;
		this.languages = languages;
		this.available = available;
		this.genre = genre;
		this.isbnNumber = isbnNumber;
		this.publishedDate = publishedDate;
		this.author = author;
		this.transaction = transaction;
	}


	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	
	
}
