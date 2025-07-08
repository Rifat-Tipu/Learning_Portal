package com.example.LearningPortal.controller;

import com.example.LearningPortal.entity.Payment;
import com.example.LearningPortal.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portal")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/payment/add")
    public ResponseEntity<String> addPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
        return ResponseEntity.ok("Payment added successfully!");
    }

    @GetMapping("/payment/get")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PutMapping("/payment/update/{id}")
    public ResponseEntity<String> updatePayment(@PathVariable int id, @RequestBody Payment payment) {
        paymentService.updatePayment(id, payment);
        return ResponseEntity.ok("Payment updated successfully!");
    }

    @DeleteMapping("/payment/delete/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok("Payment deleted successfully!");
    }
}
