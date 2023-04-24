
package com.example.learning.controllers.v1;

import com.example.learning.entities.StudentEntity;
import com.example.learning.services.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author ibent95
 */
@RestController
@RequestMapping(value = "/students")
public class StudentController {
	
	private Map<String, Object> response;
    
    private final StudentService studentSvc;

    @Autowired
    public StudentController(StudentService studentSvc) {
    	this.response = new HashMap<>();
    	this.response.put("data", null);
    	this.response.put("message", "There is no process is running...");
    	this.response.put("status", 200);

        this.studentSvc = studentSvc;
    }

    @GetMapping()
    public List<StudentEntity> index() {
        return this.studentSvc.getAll();
    }

    @PostMapping()
    public ResponseEntity<?> insert(WebRequest request) {
    	System.out.println(request);
        return new ResponseEntity<>(this.response, HttpStatus.OK);
    }

}
