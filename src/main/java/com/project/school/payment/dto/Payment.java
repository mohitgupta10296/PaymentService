package com.project.school.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Payment {

    @Id
    private String id;
    private String providerOrderId;
    private String transactionId;
    private String status;
    private double amount;
    private String method;
    private Instant createdAt;
}