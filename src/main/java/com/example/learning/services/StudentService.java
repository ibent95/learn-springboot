
package com.example.learning.services;

import com.example.learning.entities.StudentEntity;
import com.example.learning.repositories.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ibent95
 */
@Service
public class StudentService {
    
    private final StudentRepository studentRepo;

    @Autowired
    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }
    
    public List<StudentEntity> getAll() {
        return this.studentRepo.findAll();
    }

    public void insert(Object data) {
		
	}

}
