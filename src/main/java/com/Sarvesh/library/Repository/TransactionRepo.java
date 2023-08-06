package com.Sarvesh.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sarvesh.library.Entity.Card;
import com.Sarvesh.library.Entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
	public long countByTransactionCard(Card card);

}
