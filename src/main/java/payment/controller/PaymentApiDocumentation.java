package payment.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import payment.request.BankSlipPaymentRequest;
import payment.request.CreditCardPaymentRequest;
import payment.request.PixPaymentRequest;
import payment.response.PaymentResponse;

/**
 * This class contains the OpenAPI/Swagger documentation for the Payment API.
 * It is separated from the controller implementation to improve code readability.
 * <p>
 * The documentation is associated with the {@link PaymentController} methods
 * using the @see JavaDoc tag in the controller methods.
 */
@RequestMapping("/api/payments")
public class PaymentApiDocumentation {

    @Tag(name = "Payment API", description = "API for processing different types of payments")
    public static final class PaymentControllerTags {}

    /**
     * Documentation for the credit card payment endpoint.
     */
    public static final class CreditCardEndpoint {
        @Operation(summary = "Process a credit card payment", description = "Processes a payment using credit card details")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment processed successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid credit card details supplied", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
        })
        public void processCreditCardPayment() {}

        @RequestBody(description = "Credit card payment details", required = true,
                content = @Content(schema = @Schema(implementation = CreditCardPaymentRequest.class)))
        public void creditCardPaymentRequestBody() {}
    }

    /**
     * Documentation for the PIX payment endpoint.
     */
    public static final class PixEndpoint {
        @Operation(summary = "Process a PIX payment", description = "Processes a payment using PIX (Brazilian instant payment system)")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment processed successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid PIX details supplied", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
        })
        public void processPixPayment() {}

        @RequestBody(description = "PIX payment details", required = true,
                content = @Content(schema = @Schema(implementation = PixPaymentRequest.class)))
        public void pixPaymentRequestBody() {}
    }

    /**
     * Documentation for the bank slip payment endpoint.
     */
    public static final class BankSlipEndpoint {
        @Operation(summary = "Process a bank slip payment", description = "Processes a payment using bank slip (boleto)")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment processed successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid bank slip details supplied", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
        })
        public void processBankSlipPayment() {}

        @RequestBody(description = "Bank slip payment details", required = true,
                content = @Content(schema = @Schema(implementation = BankSlipPaymentRequest.class)))
        public void bankSlipPaymentRequestBody() {}
    }
}
