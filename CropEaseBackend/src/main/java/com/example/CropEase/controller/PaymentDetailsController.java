package com.example.CropEase.controller;

import com.example.CropEase.model.PaymentDetails;
import com.example.CropEase.service.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/CropEase")
@CrossOrigin(origins = "http://localhost:5500")  // Allow frontend to access this
public class PaymentDetailsController {

    @Autowired
    private PaymentDetailsService paymentDetailsService;

    @PostMapping("/savePayment")
    public PaymentDetails savePayment(@RequestBody PaymentDetails paymentDetails) {
        return paymentDetailsService.savePayment(paymentDetails);
    }

    @GetMapping("/payments")
    public List<PaymentDetails> getAllPayments() {
        return paymentDetailsService.getAllPayments();
    }

    @GetMapping("/payment/{id}")
    public Optional<PaymentDetails> getPaymentById(@PathVariable Long id) {
        return paymentDetailsService.getPaymentById(id);
    }

    @DeleteMapping("/payment/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentDetailsService.deletePayment(id);
    }
}
