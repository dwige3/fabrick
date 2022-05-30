package it.fabrick.bip.wwsbipbackend.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AccountTransactionResponse {

    private List<AccountTransactionDto> list = new ArrayList<>();
}
