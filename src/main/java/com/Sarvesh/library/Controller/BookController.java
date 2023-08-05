package com.Sarvesh.library.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sarvesh.library.Entity.Book;
import com.Sarvesh.library.Repository.BookRepo;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookRepo bookRepo;
	
	@PostMapping("/add")
	public Book addBook(@RequestBody Book book) {
		return bookRepo.save(book);
	}
	
	@GetMapping("/get/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return bookRepo.findById(id);
	}
	
	@PostMapping("/update")
	public Book updateBook(@RequestBody Book book) {
		return bookRepo.save(book);
	}
	
	@DeleteMapping("/delete")
	public String deleteBook(@PathVariable int id) {
		bookRepo.deleteById(id);
		String str = "Book :"+id+" deleted successfully";
		return str;
		}
}
