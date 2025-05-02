package payment.service;

import payment.request.PaymentRequest;
import payment.response.PaymentResponse;

public interface PaymentProcessorService {
    PaymentResponse processPayment(PaymentRequest paymentRequest);
}
