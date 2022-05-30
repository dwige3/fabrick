package it.fabrick.bip.wwsbipbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyTransferRequest implements Serializable {

    @NotNull
    private CreditorDto creditor;

    private Date executionDate;

    private String uri;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private String currency;

    private Boolean isUrgent;

    private Boolean isInstant;

    private String feeType;

    private String feeAccountId;

    private TaxRelief taxRelief;
}
