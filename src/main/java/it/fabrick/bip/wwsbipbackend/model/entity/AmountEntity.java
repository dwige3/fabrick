package it.fabrick.bip.wwsbipbackend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "amount")
public class AmountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount_debtorAmount")
    private BigDecimal amountDebtorAmount;

    @Column(name = "amount_debtorCurrency")
    private String amountDebtorCurrency;

    @Column(name = "amount_creditorAmount")
    private BigDecimal amountCreditorAmount;

    @Column(name = "amount_creditorCurrency")
    private String amountCreditorCurrency;

    @Temporal(TemporalType.DATE)
    @Column(name = "amount_creditorCurrencyDate")
    private Date amountCreditorCurrencyDate;

    @Column(name = "amount_exchangeRate")
    private BigDecimal amountExchangeRate;

}
