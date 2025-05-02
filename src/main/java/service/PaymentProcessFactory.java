package service;

import org.springframework.stereotype.Service;
import request.BankSlipPaymentRequest;
import request.CreditCardPaymentRequest;
import request.PaymentRequest;
import request.PixPaymentRequest;
import service.impl.BankSlipPaymentProcessorImpl;
import service.impl.CreditCardPaymentProcessorImpl;
import service.impl.PixPaymentProcessor;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentProcessFactory {

    private final Map<Class<? extends PaymentRequest>, PaymentProcessorService> processors = new HashMap<>();

    public PaymentProcessFactory(CreditCardPaymentProcessorImpl creditCardPaymentProcessorImpl,
                                 BankSlipPaymentProcessorImpl bankSlipPaymentProcessorImpl,
                                 PixPaymentProcessor pixPaymentProcessor) {
        // Registra os processadores no mapa
        processors.put(CreditCardPaymentRequest.class, creditCardPaymentProcessorImpl);
        processors.put(BankSlipPaymentRequest.class, bankSlipPaymentProcessorImpl);
        processors.put(PixPaymentRequest.class, pixPaymentProcessor);
    }

    // Factory Method
    public PaymentProcessorService createProcessor(PaymentRequest paymentRequest) {
        PaymentProcessorService processor = processors.get(paymentRequest.getClass());

        if (processor == null) {
            throw new IllegalArgumentException("Tipo de pagamento não suportado: " + paymentRequest.getClass().getSimpleName());
        }

        return processor;
    }
}