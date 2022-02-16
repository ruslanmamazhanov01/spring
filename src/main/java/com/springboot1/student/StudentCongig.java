package com.springboot1.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;

@Configuration
public class StudentCongig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository) {
        return args -> {
            Student student = new Student(
                    1L, "ruslan", "ruslan@gmail.com",
                    LocalDate.of(2000, APRIL, 5),
                    29
            );
            Student alex = new Student(
                    2L, "alex", "alex.alex@gmail.com",
                    LocalDate.of(2002, APRIL, 23),
                    45
            );

            studentRepository.saveAll(
                    List.of(student , alex)
            );
        };
    }

}
