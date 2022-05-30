package it.fabrick.bip.wwsbipbackend.model.dto;

import it.fabrick.bip.wwsbipbackend.model.enumeration.TransactionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionTypeDto {

    private TransactionStatus enumeration;

    private String value;
}
