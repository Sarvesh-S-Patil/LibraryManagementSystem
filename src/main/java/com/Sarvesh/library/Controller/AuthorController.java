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

import com.Sarvesh.library.Entity.Author;
import com.Sarvesh.library.Repository.AuthorRepo;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	AuthorRepo authorRepo;
	
	@GetMapping("/test")
	public  String test() {
		return "Test API works";
	}
	
	@PostMapping("/add")
	public Author addAuthor(@RequestBody Author author) {
		return authorRepo.save(author);
	}
	
	@GetMapping("/get/{id}")
	public Author getAuthor(@PathVariable int id) {
		Optional<Author> auth=  authorRepo.findById(id);
		if(auth.isPresent()) {
			Author author = auth.get();
			return author;
		}
		return new Author();
	}
	
	@PostMapping("/update")
	public Author updateAuthor(@RequestBody Author author) {
		return authorRepo.save(author);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAuthor(@PathVariable int id) {
		authorRepo.deleteById(id);
		String str = "Author "+id+" delted successfully";
		return str;
	}
	

}
