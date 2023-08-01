package com.Sarvesh.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sarvesh.library.Entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}
