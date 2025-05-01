package service;

import request.PaymentRequest;
import response.PaymentResponse;

public interface PaymentProcessorService {
    PaymentResponse processPayment(PaymentRequest paymentRequest);
}
