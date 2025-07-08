package com.example.LearningPortal.repository;


import com.example.LearningPortal.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository <Payment,Integer>{
}
