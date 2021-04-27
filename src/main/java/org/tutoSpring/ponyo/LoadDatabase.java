package org.tutoSpring.ponyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tutoSpring.ponyo.entity.Employee;
import org.tutoSpring.ponyo.repository.EmployeeRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Ponyo", "Poisson volant")));
            log.info("Preloading " + repository.save(new Employee("Sosuke", "Marin")));
        };
    }
}
