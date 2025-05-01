package response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.PaymentMethod;
import model.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private long id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private String transactionId;
    private LocalDateTime createdAt;
    private PaymentStatus status;
    private String receiptUrl;
}
