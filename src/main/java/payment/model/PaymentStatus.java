package payment.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Possible payment status values")
public enum PaymentStatus {

    @Schema(description = "Payment is pending processing")
    PENDING,

    @Schema(description = "Payment is currently being processed")
    PROCESSING,

    @Schema(description = "Payment has been successfully completed")
    COMPLETED,

    @Schema(description = "Payment processing has failed")
    FAILED,

    @Schema(description = "Payment has been refunded")
    REFUNDED

}
