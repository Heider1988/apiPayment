package payment.service.impl;


import payment.model.PaymentMethod;
import payment.model.PaymentStatus;
import payment.model.entities.PaymentEntity;
import payment.model.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import payment.request.PaymentRequest;
import payment.request.PixPaymentRequest;
import payment.response.PaymentResponse;
import payment.service.PaymentProcessorService;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PixPaymentProcessor implements PaymentProcessorService {

    private final PaymentRepository paymentRepository;

    public PixPaymentProcessor(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        PixPaymentRequest request = (PixPaymentRequest) paymentRequest;

        // Lógica específica para processar pagamento com PIX

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setAmount(request.getAmount());
        paymentEntity.setPaymentMethod(PaymentMethod.PIX);
        paymentEntity.setTransactionId(UUID.randomUUID().toString());
        paymentEntity.setCreatedAt(LocalDateTime.now());
        paymentEntity.setStatus(PaymentStatus.COMPLETED); // PIX geralmente é instantâneo

        PaymentEntity savedPayment = paymentRepository.save(paymentEntity);

        return PaymentResponse.builder()
                .id(savedPayment.getId())
                .amount(savedPayment.getAmount())
                .paymentMethod(savedPayment.getPaymentMethod())
                .transactionId(savedPayment.getTransactionId())
                .createdAt(savedPayment.getCreatedAt())
                .status(savedPayment.getStatus())
                .receiptUrl("/receipts/pix/" + savedPayment.getId())
                .build();
    }
}