package payment.service;

import org.springframework.stereotype.Service;
import payment.request.PaymentRequest;
import payment.response.PaymentResponse;

@Service
public class PaymentService {

    private final PaymentProcessFactory paymentProcessFactory;

    public PaymentService(PaymentProcessFactory paymentProcessFactory) {
        this.paymentProcessFactory = paymentProcessFactory;
    }

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        // Utiliza a fábrica para obter o processador correto
        PaymentProcessorService processor =  paymentProcessFactory.createProcessor(paymentRequest);

        return processor.processPayment(paymentRequest);

    }

}
