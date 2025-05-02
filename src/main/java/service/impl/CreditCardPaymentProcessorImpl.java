package service.impl;

import model.PaymentMethod;
import model.PaymentStatus;
import model.entities.PaymentEntity;
import model.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import request.CreditCardPaymentRequest;
import request.PaymentRequest;
import response.PaymentResponse;
import service.PaymentProcessorService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CreditCardPaymentProcessorImpl implements PaymentProcessorService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public CreditCardPaymentProcessorImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        CreditCardPaymentRequest request = (CreditCardPaymentRequest) paymentRequest;

        // Lógica específica para processar pagamento com cartão de crédito
        // Aqui você poderia integrar com um gateway de pagamento real

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setAmount(request.getAmount());
        paymentEntity.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        paymentEntity.setTransactionId(UUID.randomUUID().toString());
        paymentEntity.setCreatedAt(LocalDateTime.now());
        paymentEntity.setStatus(PaymentStatus.COMPLETED);

        PaymentEntity savedPayment = paymentRepository.save(paymentEntity);

        return PaymentResponse.builder()
                .id(savedPayment.getId())
                .amount(savedPayment.getAmount())
                .paymentMethod(savedPayment.getPaymentMethod())
                .transactionId(savedPayment.getTransactionId())
                .createdAt(savedPayment.getCreatedAt())
                .status(savedPayment.getStatus())
                .receiptUrl("/receipts/credit-card-payment" + savedPayment.getId())
                .build();


    }
}
