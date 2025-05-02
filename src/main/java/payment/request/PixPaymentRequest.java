package payment.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Request object for PIX payment processing (Brazilian instant payment system)")
public class PixPaymentRequest extends PaymentRequest {

    @Schema(description = "PIX key for the transaction", example = "user@example.com", required = true)
    private String pixKey;

    @Schema(description = "Type of PIX key (CPF, CNPJ, EMAIL, PHONE, RANDOM)", example = "EMAIL", required = true)
    private String pixKeyType;

}
