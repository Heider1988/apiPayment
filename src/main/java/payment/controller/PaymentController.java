package payment.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import payment.request.BankSlipPaymentRequest;
import payment.request.CreditCardPaymentRequest;
import payment.request.PixPaymentRequest;
import payment.response.PaymentResponse;
import payment.service.PaymentService;

/**
 * Controller for processing different types of payments.
 * The API documentation is defined in {@link PaymentApiDocumentation}.
 */
@RestController
@RequestMapping("/api/payments")
@Tag(name = "Payment API", description = "API for processing different types of payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Process a credit card payment.
     * 
     * @param request the credit card payment request
     * @return the payment response
     * @see PaymentApiDocumentation.CreditCardEndpoint#processCreditCardPayment()
     */
    @PostMapping("/credit-card")
    public ResponseEntity<PaymentResponse> processCreditCardPayment(@RequestBody CreditCardPaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Process a PIX payment.
     * 
     * @param request the PIX payment request
     * @return the payment response
     * @see PaymentApiDocumentation.PixEndpoint#processPixPayment()
     */
    @PostMapping("/pix")
    public ResponseEntity<PaymentResponse> processPixPayment(@RequestBody PixPaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Process a bank slip payment.
     * 
     * @param request the bank slip payment request
     * @return the payment response
     * @see PaymentApiDocumentation.BankSlipEndpoint#processBankSlipPayment()
     */
    @PostMapping("/bank-slip")
    public ResponseEntity<PaymentResponse> processBankSlipPayment(@RequestBody BankSlipPaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }
}
