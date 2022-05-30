package it.fabrick.bip.wwsbipbackend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Creditor {

    @Column(name = "creditor_name")
    private String name;

    @Column(name = "creditor_accountCode")
    private String accountCode;

    @Column(name = "creditor_bicCode")
    private String bicCode;

    @Column(name = "creditor_address")
    private String address;

    @Column(name = "creditor_city")
    private String city;

    @Column(name = "creditor_countryCode")
    private String countryCode;
}
