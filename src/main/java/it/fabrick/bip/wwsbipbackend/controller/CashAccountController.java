package it.fabrick.bip.wwsbipbackend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import it.fabrick.bip.wwsbipbackend.model.dto.AccountBalanceResponse;
import it.fabrick.bip.wwsbipbackend.model.dto.AccountTransactionResponse;
import it.fabrick.bip.wwsbipbackend.model.dto.MoneyTransferRequest;
import it.fabrick.bip.wwsbipbackend.model.dto.MoneyTransferResponse;
import it.fabrick.bip.wwsbipbackend.service.CashAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/gbs/banking/v4.0")
@Api(value = "CashAccount", tags = "Controller Cash Account Management")
public class CashAccountController {

    @Autowired
    private CashAccountService cashAccountService;

    @ApiOperation(
            value = "Retrieves the transactions of a specific cash account",
            notes = "Restitutive un collection di transactions in formato JSON",
            response = AccountTransactionResponse.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {@ApiResponse(code = 200, message = "I transazioni sono stati trovati"),
                    @ApiResponse(code = 404, message = "Non è stato trovato alcun transactions"),
                    @ApiResponse(code = 403, message = "Non sei AUTORIZZATO ad accedere alle informazioni"),
                    @ApiResponse(code = 401, message = "Non sei AUTENTICATO"),
                    @ApiResponse(code = 500, message = "Internal Server Error")
            })
    // ------------------- Search transactions  ------------------------------------//
    @GetMapping(value = "/accounts/{accountId}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountTransactionResponse> getCashAccountTransactions(//@RequestHeader(value = "X-Time-Zone", required = false) String timeZone,
                                                                                 @ApiParam("The ID of the account") @PathVariable(value = "accountId") String accountId,
                                                                                 @RequestParam(value = "fromAccountingDate") String fromAccountingDate,
                                                                                 @RequestParam(value = "toAccountingDate") String toAccountingDate,
                                                                                 @RequestParam(defaultValue = "0", value = "page") Integer page, @RequestParam(value = "limit") Integer limit
    ) {

        Pageable pageable = limit > 0 ? PageRequest.of(page, limit) : Pageable.unpaged();
        return ResponseEntity.ok().body(cashAccountService.getAccountTransactions(accountId, fromAccountingDate, toAccountingDate, pageable));
    }

    @ApiOperation(
            value = "Create Money Transfer",
            notes = "search money transfers",
            response = MoneyTransferResponse.class,
            produces = "application/json")
    @ApiResponses(value =
            {@ApiResponse(code = 200, message = "the newly created money transfer"),
                    @ApiResponse(code = 500, message = "Internal Server Error")
            })
    // ------------------- Insert Money Transfer  ------------------------------------//
    @PostMapping(value = "/accounts/{accountId}/payments/money-transfers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MoneyTransferResponse> createMoneyTransfer(@ApiParam("The ID of the account") @PathVariable(value = "accountId") String accountId,
                                                                     @Valid @RequestBody MoneyTransferRequest request) {

        MoneyTransferResponse response = cashAccountService.createMoneyTransfer(accountId, request);
        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(
            value = "Retrieves the balance of a specific cash account.",
            notes = "Cash accounts with balance in formato JSON",
            response = AccountBalanceResponse.class,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value =
            {@ApiResponse(code = 200, message = "success"),
                    @ApiResponse(code = 404, message = " Not Found Balance"),
                    @ApiResponse(code = 403, message = "forbidden"),
                    @ApiResponse(code = 401, message = "unauthorized"),
                    @ApiResponse(code = 500, message = "Internal Server Error")
            })
    // ------------------- Search Balance ------------------------------------
    @GetMapping(value = "/accounts/{accountId}/balances", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountBalanceResponse> getAccountBalance(@RequestHeader(value = "X-Time-Zone", required = false) String timeZone,
                                                                    @ApiParam("The ID of the account") @PathVariable(value = "accountId") String accountId) {

        return ResponseEntity.ok().body(cashAccountService.getBalance(accountId));
    }
}
