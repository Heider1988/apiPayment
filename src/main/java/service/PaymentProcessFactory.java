package service;

import org.springframework.stereotype.Service;
import request.BankSlipPaymentRequest;
import request.CreditCardPaymentRequest;
import request.PaymentRequest;
import request.PixPaymentRequest;
import service.impl.BankSlipPaymentProcessorImpl;
import service.impl.CreditCardPaymentProcessorImpl;
import service.impl.PixPaymentProcessor;

@Service
public class PaymentProcessFactory {

    private final CreditCardPaymentProcessorImpl creditCardPaymentProcessorImpl;
    private final BankSlipPaymentProcessorImpl bankSlipPaymentProcessorImpl;
    private final PixPaymentProcessor pixPaymentProcessor;

    public PaymentProcessFactory(CreditCardPaymentProcessorImpl creditCardPaymentProcessorImpl, BankSlipPaymentProcessorImpl bankSlipPaymentProcessorImpl, PixPaymentProcessor pixPaymentProcessor) {
        this.creditCardPaymentProcessorImpl = creditCardPaymentProcessorImpl;
        this.bankSlipPaymentProcessorImpl = bankSlipPaymentProcessorImpl;
        this.pixPaymentProcessor = pixPaymentProcessor;
    }

    // Factory Method
    public PaymentProcessorService createProcessor(PaymentRequest paymentRequest) {
        if (paymentRequest instanceof CreditCardPaymentRequest) {
            return creditCardPaymentProcessorImpl;
        } else if (paymentRequest instanceof BankSlipPaymentRequest) {
            return bankSlipPaymentProcessorImpl;
        } else if (paymentRequest instanceof PixPaymentRequest) {
            return pixPaymentProcessor;
        } else {
            throw new IllegalArgumentException("Tipo de pagamento não suportado");
        }
    }


}
