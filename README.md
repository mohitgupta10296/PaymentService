## 4. Payment Service
## Overview
The **Payment Service** simulates interactions with a payment provider. It allows creation of payment orders and capturing transactions.

---
**Purpose:** Simulates integration with an external payment gateway.

**Responsibilities:** Create payment orders.
Capture payments.
Track payment status and transactions.

**Benefit:** Isolates payment logic, making it easier to switch to a real payment provider without impacting other services.
**File:** `README_PaymentService.md`

---

## API Endpoints

- `GET /api/payments` : Get all payments
- `GET /api/payments/{providerOrderId}` : Get payment by provider order ID
- `POST /api/payments/create-order` : Create a new payment order
- `POST /api/payments/capture/{providerOrderId}` : Capture payment for an order

---

## POSTMAN 
End-Points are added in single project that is in Fee-Collection Service.
---

## Author
Mohit Gupta
```

