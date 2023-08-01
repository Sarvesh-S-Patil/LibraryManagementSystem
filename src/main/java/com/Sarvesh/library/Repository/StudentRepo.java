package com.Sarvesh.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Sarvesh.library.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
