package com.project.school.payment.controller;

import com.project.school.payment.dto.Payment;
import com.project.school.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
@Tag(name = "Payments API", description = "Endpoints for managing payments")
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @Autowired
    private PaymentService service;

    @GetMapping
    @Operation(summary = "Fetch all payments")
    public List<Payment> all() {
        logger.info("Fetching all payments");
        return service.getAll();
    }

    @GetMapping("/{providerOrderId}")
    @Operation(summary = "Get payment by provider order ID")
    public ResponseEntity<Payment> byProviderOrderId(@PathVariable String providerOrderId) {
        logger.info("Fetching payment by providerOrderId: {}", providerOrderId);
        return service.getByProviderOrderId(providerOrderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create-order")
    @Operation(summary = "Create a new payment order")
    public Payment createOrder(@RequestBody Payment request) {
        request.setId(UUID.randomUUID().toString());
        request.setProviderOrderId("prov_" + UUID.randomUUID().toString().substring(0, 8));
        request.setStatus("CREATED");
        request.setCreatedAt(Instant.now());
        logger.info("Creating new payment order: {}", request);
        return service.createPayment(request);
    }

    @PostMapping("/capture/{providerOrderId}")
    @Operation(summary = "Capture a payment by provider order ID")
    public ResponseEntity<Payment> capture(@PathVariable String providerOrderId) {
        logger.info("Capturing payment with providerOrderId: {}", providerOrderId);
        return service.getByProviderOrderId(providerOrderId)
                .map(p -> {
                    p.setTransactionId("txn_" + UUID.randomUUID().toString().substring(0, 8));
                    p.setStatus("CAPTURED");
                    logger.info("Payment captured: {}", p);
                    return ResponseEntity.ok(service.createPayment(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
