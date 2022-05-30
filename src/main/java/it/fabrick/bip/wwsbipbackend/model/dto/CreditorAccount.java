package it.fabrick.bip.wwsbipbackend.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CreditorAccount implements Serializable {

    @NotNull
    private String accountCode;

    private String bicCode;
}
