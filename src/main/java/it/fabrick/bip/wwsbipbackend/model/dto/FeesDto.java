package it.fabrick.bip.wwsbipbackend.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FeesDto {

    private String feeCode;

    private String description;

    private BigDecimal amount;

    private String currency;
}
