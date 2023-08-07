package com.Sarvesh.library.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sarvesh.library.Entity.Book;
import com.Sarvesh.library.Entity.Card;
import com.Sarvesh.library.Entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	public long countByTransactionCard(Card card);
	public boolean existsByTransactionBookAndTransactionCard(Book book,Card card);
	public Optional<Transaction> findByTransactionBookAndTransactionCard(Book book,Card card);

}
