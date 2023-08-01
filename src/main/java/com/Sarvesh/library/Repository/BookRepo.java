package com.Sarvesh.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sarvesh.library.Entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
