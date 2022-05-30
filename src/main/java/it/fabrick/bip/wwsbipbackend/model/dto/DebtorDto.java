package it.fabrick.bip.wwsbipbackend.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DebtorDto {

    private String name;

    private DebtorAccount account;
}
