package model.entities;

import payment.model.PaymentMethod;
import payment.model.PaymentStatus;
import payment.model.entities.PaymentEntity;
import payment.model.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestConfig.class)
@Transactional
public class PaymentEntityTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void testSaveAndRetrievePaymentEntity() {

        PaymentEntity payment = new PaymentEntity();
        payment.setAmount(new BigDecimal("100.50"));
        payment.setPaymentMethod(PaymentMethod.CREDIT_CARD);
        payment.setTransactionId("TX123456");
        payment.setCreatedAt(LocalDateTime.now());
        payment.setStatus(PaymentStatus.PENDING);


        PaymentEntity savedPayment = paymentRepository.save(payment);


        System.out.println("[DEBUG_LOG] Payment entity saved with ID: " + savedPayment.getId());


        Optional<PaymentEntity> retrievedPaymentOpt = paymentRepository.findById(savedPayment.getId());


        assertTrue(retrievedPaymentOpt.isPresent(), "Payment entity should be found in the database");

        PaymentEntity retrievedPayment = retrievedPaymentOpt.get();
        assertEquals(payment.getAmount(), retrievedPayment.getAmount(), "Amount should match");
        assertEquals(payment.getPaymentMethod(), retrievedPayment.getPaymentMethod(), "Payment method should match");
        assertEquals(payment.getTransactionId(), retrievedPayment.getTransactionId(), "Transaction ID should match");
        assertEquals(payment.getStatus(), retrievedPayment.getStatus(), "Status should match");


        System.out.println("[DEBUG_LOG] Payment entity saved and retrieved successfully");
        System.out.println("[DEBUG_LOG] Saved ID: " + savedPayment.getId());
        System.out.println("[DEBUG_LOG] Retrieved ID: " + retrievedPayment.getId());
    }
}
