package request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "Request object for bank slip (boleto) payment processing")
public class BankSlipPaymentRequest extends PaymentRequest {

    @Schema(description = "Customer document number (CPF/CNPJ)", example = "123.456.789-00", required = true)
    private String customerDocument;

    @Schema(description = "Customer full name", example = "John Doe", required = true)
    private String customerName;

    @Schema(description = "Customer complete address", example = "123 Main St, Apt 4B, São Paulo, SP, 01234-567", required = true)
    private String customerAddress;

}
