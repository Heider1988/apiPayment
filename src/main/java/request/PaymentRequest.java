package request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "Base abstract class for all payment requests")
public abstract class PaymentRequest {

    @Schema(description = "Payment amount", example = "100.50", required = true)
    private BigDecimal amount;

}
