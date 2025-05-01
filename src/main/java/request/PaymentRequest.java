package request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class PaymentRequest {

    private BigDecimal amount;

}
