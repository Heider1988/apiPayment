package service.impl;

import model.PaymentMethod;
import model.PaymentStatus;
import model.entities.PaymentEntity;
import model.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import request.BankSlipPaymentRequest;
import request.PaymentRequest;
import response.PaymentResponse;
import service.PaymentProcessorService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BankSlipPaymentProcessorImpl implements PaymentProcessorService {

    private final PaymentRepository paymentRepository;
    private final PaymentEntity paymentEntity;

    @Autowired
    public BankSlipPaymentProcessorImpl(PaymentRepository paymentRepository, PaymentEntity paymentEntity) {
        this.paymentRepository = paymentRepository;
        this.paymentEntity = paymentEntity;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        BankSlipPaymentRequest request = (BankSlipPaymentRequest) paymentRequest;

        // Lógica específica para processar pagamento com boleto
        // Aqui você geraria o código de barras do boleto

        paymentEntity.setAmount(request.getAmount());
        paymentEntity.setPaymentMethod(PaymentMethod.BANK_SLIP);
        paymentEntity.setTransactionId(UUID.randomUUID().toString());
        paymentEntity.setCreatedAt(LocalDateTime.now());
        paymentEntity.setStatus(PaymentStatus.PENDING); // Boletos começam como pendentes

        PaymentEntity savedPayment = paymentRepository.save(paymentEntity);

        return PaymentResponse.builder()
                .id(savedPayment.getId())
                .amount(savedPayment.getAmount())
                .paymentMethod(savedPayment.getPaymentMethod())
                .transactionId(savedPayment.getTransactionId())
                .createdAt(savedPayment.getCreatedAt())
                .status(savedPayment.getStatus())
                .receiptUrl("/bank-slips/" + savedPayment.getId())
                .build();
    }
}