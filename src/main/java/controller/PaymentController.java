package controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import request.BankSlipPaymentRequest;
import request.CreditCardPaymentRequest;
import request.PixPaymentRequest;
import response.PaymentResponse;
import service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@Tag(name = "Payment API", description = "API for processing different types of payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(summary = "Process a credit card payment", description = "Processes a payment using credit card details")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Payment processed successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid credit card details supplied", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/credit-card")
    public ResponseEntity<PaymentResponse> processCreditCardPayment(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Credit card payment details", required = true,
                    content = @Content(schema = @Schema(implementation = CreditCardPaymentRequest.class)))
            @RequestBody CreditCardPaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Process a PIX payment", description = "Processes a payment using PIX (Brazilian instant payment system)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Payment processed successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid PIX details supplied", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/pix")
    public ResponseEntity<PaymentResponse> processPixPayment(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "PIX payment details", required = true,
                    content = @Content(schema = @Schema(implementation = PixPaymentRequest.class)))
            @RequestBody PixPaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Process a bank slip payment", description = "Processes a payment using bank slip (boleto)")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Payment processed successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = PaymentResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid bank slip details supplied", content = @Content),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/bank-slip")
    public ResponseEntity<PaymentResponse> processBankSlipPayment(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Bank slip payment details", required = true,
                    content = @Content(schema = @Schema(implementation = BankSlipPaymentRequest.class)))
            @RequestBody BankSlipPaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

}
