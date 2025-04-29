package com.example.spring_start_here_05.model;

import java.math.BigDecimal;

public class TransferRequest {

    BigDecimal amount;
    Long senderId;
    Long receiverId;

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getSenderId() {
        return senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }
}
