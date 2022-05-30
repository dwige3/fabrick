package it.fabrick.bip.wwsbipbackend.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class AccountTransactionDto {

    private String transactionId;

    private String operationId;

    private Date accountingDate;

    private Date valueDate;

    private TransactionTypeDto type;

    private BigDecimal amount;

    private String currency;

    private String description;
}
