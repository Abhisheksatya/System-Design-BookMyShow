package in.scaler.bookmyshow.services;

import in.scaler.bookmyshow.models.Payment;
import in.scaler.bookmyshow.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    public Payment processPayment(Payment paymentRequest) {
        return paymentRepository.save(paymentRequest);
    }

    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElseGet((Supplier<? extends Payment>) new RuntimeException("No Record found"));
    }
}
