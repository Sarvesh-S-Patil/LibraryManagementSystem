package com.Sarvesh.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sarvesh.library.Entity.Card;

public interface CardRepo extends JpaRepository<Card, Integer>{

}
