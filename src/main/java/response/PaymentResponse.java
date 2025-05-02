package response;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Response object containing payment processing result details")
public class PaymentResponse {
    @Schema(description = "Unique identifier for the payment", example = "123456")
    private long id;

    @Schema(description = "Payment amount", example = "100.50")
    private BigDecimal amount;

    @Schema(description = "Method used for payment (CREDIT_CARD, PIX, BANK_SLIP)")
    private PaymentMethod paymentMethod;

    @Schema(description = "Unique transaction identifier", example = "tx_123456789")
    private String transactionId;

    @Schema(description = "Date and time when the payment was created", example = "2023-06-15T14:30:00")
    private LocalDateTime createdAt;

    @Schema(description = "Current status of the payment (PENDING, COMPLETED, FAILED, REFUNDED)")
    private PaymentStatus status;

    @Schema(description = "URL to access the payment receipt", example = "https://example.com/receipts/123456")
    private String receiptUrl;
}
