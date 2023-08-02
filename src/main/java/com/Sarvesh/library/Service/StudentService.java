package com.Sarvesh.library.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.Sarvesh.library.DTO.Student.UpdateStudentCardRequest;
import com.Sarvesh.library.Entity.Card;
import com.Sarvesh.library.Entity.Student;
import com.Sarvesh.library.Repository.CardRepo;
import com.Sarvesh.library.Repository.StudentRepo;

@Service
public class StudentService {
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	CardRepo cardRepo;
	
	public Student addCard(UpdateStudentCardRequest updateCardRequest) throws Exception {
        int studentId = updateCardRequest.getStudentId();
        Optional<Student> optionalStudent = studentRepo.findById(studentId);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            Card card = updateCardRequest.getCard();

            boolean cardExists = cardRepo.existsById(card.getCardId());
            if (!cardExists) {
                // Save the new card if it does not exist
                cardRepo.save(card);
            } else {
                // Retrieve the existing card from the database
                card = cardRepo.findById(card.getCardId()).orElse(null);
            }

            // Set the card for the student
            student.setStudentCard(card);
            
            // Save the updated student with the new card
            return studentRepo.save(student);
        } else {
            // Handle the case when studentId is not found
            throw new Exception("Student with ID " + studentId + " not found.");
        }
    }
	
	
	
	
	

}
