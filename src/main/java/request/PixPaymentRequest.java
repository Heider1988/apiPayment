package request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PixPaymentRequest extends PaymentRequest {

    private String pixKey;
    private String pixKeyType;

}
