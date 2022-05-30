package it.fabrick.bip.wwsbipbackend.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreditorDto {

    @NotNull
    private String name;

    @NotNull
    private CreditorAccount account;

    private CreditorAddress address;

}
