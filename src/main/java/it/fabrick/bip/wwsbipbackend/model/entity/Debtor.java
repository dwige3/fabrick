package it.fabrick.bip.wwsbipbackend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Debtor {

    @Column(name = "debitor_name")
    private String name;

    @Column(name = "debitor_accountCode")
    private String accountCode;

    @Column(name = "debitor_bicCode")
    private String bicCode;
}