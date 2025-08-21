package com.project.school.payment.service;

import com.project.school.payment.dto.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Optional<Payment> getByProviderOrderId(String providerOrderId);
    List<Payment> getAll();
}