package com.example.spring_start_here_05.service;

import com.example.spring_start_here_05.exception.AccountNotFoundException;
import com.example.spring_start_here_05.model.Account;
import com.example.spring_start_here_05.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transferMoney(Long senderId,
                              Long receiverId,
                              BigDecimal amount) {

        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(AccountNotFoundException::new);
        Account sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new AccountNotFoundException());

        BigDecimal newAmountReceiver = receiver.getAmount().subtract(amount);
        BigDecimal newAmountSender = sender.getAmount().add(amount);

        accountRepository.updateAccount(newAmountReceiver, receiverId);
        accountRepository.updateAccount(newAmountSender, senderId);
    }

    public List<Account> findAll() {
        return (List<Account>) accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }

    public Account updateAccount() {
        Account account = accountRepository.findById(1L).orElseThrow();
        account.setName("___CHANGED___");
        return account;
    }
}
