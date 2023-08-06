package com.Sarvesh.library.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sarvesh.library.InvalidException;
import com.Sarvesh.library.DTO.AddTransactionRequest;
import com.Sarvesh.library.Entity.Transaction;
import com.Sarvesh.library.Repository.TransactionRepo;
import com.Sarvesh.library.Service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	TransactionService service;
	
	@GetMapping("/test")
	public String test() {
		return "Test API works ! ";
	}
	

	@PostMapping("/add")
	public Optional<Transaction> issueBook(@RequestBody AddTransactionRequest transactionRequest) throws InvalidException{
		return service.issueBook(transactionRequest.getTransaction(), transactionRequest.getBookId(), transactionRequest.getCardId());
	}

}
