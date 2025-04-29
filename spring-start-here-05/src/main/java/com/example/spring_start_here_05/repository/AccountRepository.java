package com.example.spring_start_here_05.repository;

import com.example.spring_start_here_05.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository
        extends CrudRepository<Account, Long> {

    @Query("SELECT * FROM account where name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void updateAccount(BigDecimal amount, Long id);

}
