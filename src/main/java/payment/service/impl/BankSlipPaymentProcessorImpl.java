package payment.service.impl;

import payment.model.PaymentMethod;
import payment.model.PaymentStatus;
import payment.model.entities.PaymentEntity;
import payment.model.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payment.request.BankSlipPaymentRequest;
import payment.request.PaymentRequest;
import payment.response.PaymentResponse;
import payment.service.PaymentProcessorService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BankSlipPaymentProcessorImpl implements PaymentProcessorService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public BankSlipPaymentProcessorImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        BankSlipPaymentRequest request = (BankSlipPaymentRequest) paymentRequest;

        // Lógica específica para processar pagamento com boleto
        // Aqui você geraria o código de barras do boleto

        PaymentEntity paymentEntity = new PaymentEntity();
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