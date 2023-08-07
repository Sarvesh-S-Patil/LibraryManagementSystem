package com.Sarvesh.library.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Sarvesh.library.InvalidException;
import com.Sarvesh.library.Entity.Book;
import com.Sarvesh.library.Entity.Card;
import com.Sarvesh.library.Entity.Transaction;
import com.Sarvesh.library.Repository.BookRepo;
import com.Sarvesh.library.Repository.CardRepo;
import com.Sarvesh.library.Repository.StudentRepo;
import com.Sarvesh.library.Repository.TransactionRepo;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	CardRepo cardRepo;
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	BookRepo bookRepo;
	
	@Value("${books.max_allowed}")
	int max_allowed_books;
	
	@Value("${fine_per_day}")
	int fine_per_day;
	
	public Optional<Transaction> issueBook(Transaction transaction,int bookId, int cardId) throws InvalidException {
		Optional<Card> optionalCard = cardRepo.findById(cardId);
		if(optionalCard.isPresent()) {
			Card card = optionalCard.get();
			if(card.isStatus()==true) {
				Optional<Book> optionalBook = bookRepo.findById(bookId);
				if(optionalBook.isPresent()) {
					Book book = optionalBook.get();
					if(book.isAvailable()==true) {
						long cardTransactions = transactionRepo.countByTransactionCard(card);
						if(cardTransactions < max_allowed_books) {
							book.setAvailable(false);
							transaction.setTransactionBook(book);
							transaction.setTransactionCard(card);
							transactionRepo.save(transaction);
							return transactionRepo.findById(transaction.getTransactionId());
						}
						else {
							throw new InvalidException("Card Transactions exceed limit");
						}
					}
				}
				else {
					throw new InvalidException("Book not found");
				}
			}
			else {
				throw new InvalidException("Card not found ");
			}
		}
		else {
			throw new InvalidException("Card is not present");
		}
		return null;
	}
	
	
	public Optional<Transaction> returnBook(Transaction transaction,int bookId, int cardId) throws InvalidException{
		if(bookRepo.existsById(bookId)) {
			Optional<Book> optionalBook = bookRepo.findById(bookId);
			Book book = optionalBook.get();
			if(cardRepo.existsById(cardId)) {
				Optional<Card> optionalCard = cardRepo.findById(cardId);
				Card card = optionalCard.get();
				if(transactionRepo.existsByTransactionBookAndTransactionCard(book, card)){
					Optional<Transaction> transactionRecord = transactionRepo.findByTransactionBookAndTransactionCard(book, card);
					Transaction t = transactionRecord.get();
					if(card.isStatus() && !book.isAvailable()) {
						book.setAvailable(true);
						t.setTransactionCard(null);
						t.setFineAmount(calculateFine(t.getBookDueDate(),transaction.getTransactionDate()));
						transactionRepo.save(t);
						return transactionRepo.findById(t.getTransactionId());
					}
					else throw new InvalidException("Card is not active or book is not yet issued");
				}
				else throw new InvalidException("Book & Card combination is inavlid");
				
			}
			else throw new InvalidException("Card does not exist");
			
		}
		else throw new InvalidException("Book does not exist");
	}
	
	public int calculateFine(Date dueDate,Date returnDate) {
		long difference_In_Time = returnDate.getTime() - dueDate.getTime();
		long difference_In_Days= (difference_In_Time/ (1000 * 60 * 60 * 24))% 365;
		return (int) Math.ceil(difference_In_Days*fine_per_day);
				
	}
	
	

}
