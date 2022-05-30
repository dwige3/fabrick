package it.fabrick.bip.wwsbipbackend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
@Embeddable
@Getter
@Setter
public class Fees implements Serializable {

    @Column(name = "feeCode")
    private String feeCode;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private String currency;

}
