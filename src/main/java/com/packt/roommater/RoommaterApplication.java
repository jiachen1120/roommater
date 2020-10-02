package com.packt.roommater;

import com.packt.roommater.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoommaterApplication {
    private static final Logger logger = LoggerFactory.getLogger(RoommaterApplication.class);
    @Autowired
    private TransactionRepository repository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(RoommaterApplication.class, args);
        logger.info("Hello Spring Boot");
    }
    @Bean
    CommandLineRunner runner() {
        return args -> {
            // save demo data to database
            User user1 = new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER");
            User user2 = new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN");
            userRepository.save(user1);
            userRepository.save(user2);
            Owner owner1 = new Owner("John", "Johnson", user1);
            Owner owner2 = new Owner("Mary", "Robinson", user2);
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);
            repository.save(new Transaction("Rent", 1f, 10, 1100, owner1));
            repository.save(new Transaction("Rent", 1f, 10, 700, owner2));
            repository.save(new Transaction("Jianbing", 1f, 10, 12, owner2));
        };
    }
}
