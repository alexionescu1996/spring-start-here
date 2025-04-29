package com.example.spring_start_here_05;

import com.example.spring_start_here_05.model.Account;
import com.example.spring_start_here_05.model.TransferRequest;
import com.example.spring_start_here_05.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Controller {

    private final TransferService transferService;

    public Controller(TransferService transferService) {
        this.transferService = transferService;
    }


    @GetMapping("/accounts")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false) String name) {

        System.out.println(name);
        List<Account> resultList;

        if (name != null && !name.isEmpty()) {
            resultList = transferService.findAccountsByName(name);
        } else {
            resultList = transferService.findAll();
        }

        return resultList.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest transferRequest) {
        transferService.transferMoney(transferRequest.getSenderId(),
                transferRequest.getReceiverId(),
                transferRequest.getAmount());
    }

    @PutMapping("/update")
    public Account update() {
        return transferService.updateAccount();
    }
}
