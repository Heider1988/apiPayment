package payment.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Available payment methods")
public enum PaymentMethod {
    @Schema(description = "Credit card payment")
    CREDIT_CARD,

    @Schema(description = "Bank slip (boleto) payment")
    BANK_SLIP,

    @Schema(description = "PIX instant payment (Brazilian payment system)")
    PIX
}
