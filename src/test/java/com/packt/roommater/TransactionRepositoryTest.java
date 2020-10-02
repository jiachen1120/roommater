package com.packt.roommater;

import static org.assertj.core.api.Assertions.assertThat;
import com.packt.roommater.domain.Transaction;
import com.packt.roommater.domain.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransactionRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private TransactionRepository repository;

    @Test
    public void saveCar() {
        Transaction transaction = new Transaction("Tesla", 1f, 12, 86000);
        entityManager.persistAndFlush(transaction);
        assertThat(transaction.getId()).isNotNull();
    }

    @Test
    public void deleteCars() {
        entityManager.persistAndFlush(new Transaction("Tesla", 1f, 12, 86000));
        entityManager.persistAndFlush(new Transaction("Mini", 1f, 12, 86000));

        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }
}
