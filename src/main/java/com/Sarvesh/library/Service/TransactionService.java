package com.Sarvesh.library.Service;

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
	
	@Value("${books.max_number_of_allowed}")
	int max_allowed_books;
	
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

}
