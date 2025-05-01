package request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditCardPaymentRequest extends PaymentRequest {

    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvv;

}
