package com.packt.roommater.web;

import com.packt.roommater.domain.Transaction;
import com.packt.roommater.domain.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @Autowired
    private TransactionRepository repository;
    @RequestMapping("/cars")
    public Iterable<Transaction>  getCars() {
        return repository.findAll();
    }
}
