package com.example.LearningPortal.service;

import com.example.LearningPortal.entity.Payment;
import com.example.LearningPortal.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public void addPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public void updatePayment(int id, Payment updatedPayment) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + id));

        payment.setAmount(updatedPayment.getAmount());
        payment.setDate(updatedPayment.getDate());
        payment.setStudent(updatedPayment.getStudent());
        payment.setCourse(updatedPayment.getCourse());

        paymentRepository.save(payment);
    }

    public void deletePayment(int id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + id));
        paymentRepository.delete(payment);
    }
}
