package request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BankSlipPaymentRequest extends PaymentRequest {

    private String customerDocument;
    private String customerName;
    private String customerAddress;

}
