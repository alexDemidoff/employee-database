package com.example.employeedatabase.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee jack = new Employee(
                    "Jack",
                    "Sparrow",
                    "Captain",
                    LocalDate.of(1980, Month.JANUARY, 7),
                    LocalDate.of(2000, Month.JANUARY, 7),
                    LocalDate.of(2021, Month.JANUARY, 8),
                    "Pirate"
            );

            repository.save(jack);
        };
    }
}
