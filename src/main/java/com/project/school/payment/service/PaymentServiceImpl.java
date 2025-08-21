package com.project.school.payment.service;

import com.project.school.payment.dto.Payment;
import com.project.school.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repo;

        public PaymentServiceImpl(PaymentRepository repo) {
            this.repo = repo;
        }

        @Override
        public Payment createPayment(Payment payment) {
            return repo.save(payment);
        }

        @Override
        public Optional<Payment> getByProviderOrderId(String providerOrderId) {
            return Optional.ofNullable(repo.findByProviderOrderId(providerOrderId));
        }

        @Override
        public List<Payment> getAll() {
            return repo.findAll();
        }
    }
