
package com.example.learning.controllers.v1;

import com.example.learning.entities.StudentEntity;
import com.example.learning.services.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ibent95
 */
@RestController
public class StudentController {
    
    private final StudentService studentSvc;

    @Autowired
    public StudentController(StudentService studentSvc) {
        this.studentSvc = studentSvc;
    }

    @RequestMapping(path="/students", method=RequestMethod.GET)
    public List<StudentEntity> index() {
        return this.studentSvc.getAll();
    }

}
