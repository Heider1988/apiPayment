package request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Request object for credit card payment processing")
public class CreditCardPaymentRequest extends PaymentRequest {

    @Schema(description = "Credit card number", example = "4111111111111111", required = true)
    private String cardNumber;

    @Schema(description = "Name of the card holder", example = "John Doe", required = true)
    private String cardHolderName;

    @Schema(description = "Card expiration date in MM/YY format", example = "12/25", required = true)
    private String expirationDate;

    @Schema(description = "Card verification value (3-4 digits)", example = "123", required = true)
    private String cvv;

}
