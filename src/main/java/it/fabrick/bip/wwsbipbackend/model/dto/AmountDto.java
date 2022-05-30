package it.fabrick.bip.wwsbipbackend.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class AmountDto {

    private BigDecimal amountDebtorAmount;

    private String amountDebtorCurrency;

    private BigDecimal amountCreditorAmount;

    private String amountCreditorCurrency;

    private Date amountCreditorCurrencyDate;

    private BigDecimal amountExchangeRate;
}
