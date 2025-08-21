package com.project.school.payment.repository;

import com.project.school.payment.dto.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
    Payment findByProviderOrderId(String providerOrderId);
}