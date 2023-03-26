
package com.example.learning.repositories;

import com.example.learning.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ibent95
 */
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    
}
