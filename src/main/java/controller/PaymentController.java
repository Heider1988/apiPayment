package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import request.BankSlipPaymentRequest;
import request.CreditCardPaymentRequest;
import request.PixPaymentRequest;
import response.PaymentResponse;
import service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/credit-card")
    public ResponseEntity<PaymentResponse> processCreditCardPayment(@RequestBody CreditCardPaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/pix")
    public ResponseEntity<PaymentResponse> processPixPayment(@RequestBody PixPaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/bank-slip")
    public ResponseEntity<PaymentResponse> processBankSlipPayment(@RequestBody BankSlipPaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

}
