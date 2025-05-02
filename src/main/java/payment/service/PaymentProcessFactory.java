package payment.service;

import org.springframework.stereotype.Service;
import payment.request.BankSlipPaymentRequest;
import payment.request.CreditCardPaymentRequest;
import payment.request.PaymentRequest;
import payment.request.PixPaymentRequest;
import payment.service.impl.BankSlipPaymentProcessorImpl;
import payment.service.impl.CreditCardPaymentProcessorImpl;
import payment.service.impl.PixPaymentProcessor;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentProcessFactory {

    private final Map<Class<? extends PaymentRequest>, PaymentProcessorService> processors = new HashMap<>();

    public PaymentProcessFactory(CreditCardPaymentProcessorImpl creditCardPaymentProcessorImpl,
                                 BankSlipPaymentProcessorImpl bankSlipPaymentProcessorImpl,
                                 PixPaymentProcessor pixPaymentProcessor) {
        processors.put(CreditCardPaymentRequest.class, creditCardPaymentProcessorImpl);
        processors.put(BankSlipPaymentRequest.class, bankSlipPaymentProcessorImpl);
        processors.put(PixPaymentRequest.class, pixPaymentProcessor);
    }

    // FÁBRICA DE MÉTODOS DE PROCESSAMENTO DE PAGAMENTO
    public PaymentProcessorService createProcessor(PaymentRequest paymentRequest) {
        PaymentProcessorService processor = processors.get(paymentRequest.getClass());

        if (processor == null) {
            throw new IllegalArgumentException("Tipo de pagamento não suportado: " + paymentRequest.getClass().getSimpleName());
        }

        return processor;
    }
}