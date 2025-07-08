package com.example.CropEase.service;

import com.example.CropEase.model.PaymentDetails;
import com.example.CropEase.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentDetailsService {

    @Autowired
    private PaymentDetailsRepository paymentDetailsRepository;

    public PaymentDetails savePayment(PaymentDetails paymentDetails) {
        return paymentDetailsRepository.save(paymentDetails);
    }

    public List<PaymentDetails> getAllPayments() {
        return paymentDetailsRepository.findAll();
    }

    public Optional<PaymentDetails> getPaymentById(Long id) {
        return paymentDetailsRepository.findById(id);
    }

    public void deletePayment(Long id) {
        paymentDetailsRepository.deleteById(id);
    }
}
