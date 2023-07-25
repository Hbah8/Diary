package com.utitlities.application.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.SEPTEMBER;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student roman = new Student(
                    "Roman",
                    "gimatdinov.roman@gmail.com",
                    LocalDate.of(1999, JANUARY, 18));
            Student elina = new Student(
                    "Elina",
                    "shafikova.elina@gmail.com",
                    LocalDate.of(1998, SEPTEMBER, 18));
            Student unknown = new Student(
                    "?",
                    "anonymous@gmail.com",
                    LocalDate.of(1996, SEPTEMBER, 18));

            repository.saveAll(List.of(roman,elina, unknown));
        };
    }
}
