package com.Sarvesh.library.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import com.Sarvesh.library.Entity.Card;
import com.Sarvesh.library.Entity.Transaction;
import com.Sarvesh.library.Repository.CardRepo;
import com.Sarvesh.library.Repository.StudentRepo;
import com.Sarvesh.library.Repository.TransactionRepo;

public class TransactionService {
	
	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	CardRepo cardRepo;
	@Autowired
	StudentRepo studentRepo;
	
	public Transaction addTransaction(Transaction transaction) {
		Card tcard = transaction.getTransactionCard();
		if(cardRepo.existsById(tcard.getCardId())) {
			
		}
		return null;
	}

}
