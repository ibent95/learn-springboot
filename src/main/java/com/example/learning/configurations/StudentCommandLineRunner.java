package com.example.learning.configurations;

import com.example.learning.entities.StudentEntity;
import com.example.learning.repositories.StudentRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ibent95
 */
@Configuration
public class StudentCommandLineRunner {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {

            StudentEntity student1 = new StudentEntity(
                    "Aku",
                    LocalDate.of(2000, Month.JANUARY, 1),
                    21,
                    "aku@gmail.com",
                    "aku",
                    "aku"
                    
            );
            
            StudentEntity student2 = new StudentEntity(
                    "Dia",
                    LocalDate.of(1998, Month.FEBRUARY, 10),
                    34,
                    "dia@gmail.com",
                    "dia",
                    "dia"
                    
            );
            
            repository.saveAll(
                    List.of(student1, student2)
            );

        };
    }
    
}
