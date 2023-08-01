package com.Sarvesh.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Sarvesh.library.Entity.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer>{

}
