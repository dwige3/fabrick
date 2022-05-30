package it.fabrick.bip.wwsbipbackend.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CreditorAddress implements Serializable {

    private String address;

    private String city;

    private String countryCode;
}
