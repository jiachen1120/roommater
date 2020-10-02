package com.packt.roommater.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransactionRepository extends CrudRepository <Transaction, Long> {
    List<Transaction> findByMonth(@Param("month") String month);
}
