package it.fabrick.bip.wwsbipbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountBalanceResponse implements Serializable {

    private Date date;

    private BigDecimal balance;

    private BigDecimal availableBalance;

    private String currency;
}
