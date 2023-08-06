package com.Sarvesh.library.Controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Sarvesh.library.Entity.Card;
import com.Sarvesh.library.Repository.CardRepo;

@RestController
@RequestMapping("/card")
public class CardController {
	@Autowired
	CardRepo cardRepo;
	
	@GetMapping("/test")
	public String test() {
		return "Card Test API Works ! ";
	}
	
	@PostMapping("/add")
	public Card addCard(@RequestBody Card card) {
		return cardRepo.save(card);
	}
	
	@GetMapping("/getCard")
	public Card getCard(@RequestParam int cardId) {
		Optional<Card> optionalCard = cardRepo.findById(cardId);
		if(optionalCard.isPresent()) {
			Card card = optionalCard.get() ;
			return card;
		}
		return new Card();
		
	}
	
	@RequestMapping("/updateCardStudent")
	public Card updateCard(@RequestBody Card card) {
		return cardRepo.save(card);
	}
	
	
	
	@DeleteMapping("/delete")
	public String deleteCard(@RequestParam int cardId) {
		cardRepo.deleteById(cardId);
		return "Delete Succesful";
	}
	
	
	
}
