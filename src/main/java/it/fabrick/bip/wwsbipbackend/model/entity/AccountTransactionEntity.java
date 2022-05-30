package it.fabrick.bip.wwsbipbackend.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "account")
public class AccountTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "accountId", nullable = false)
    private String accountId;

    @Column(name = "transactionId")
    private String transactionId;

    @Column(name = "operationId", nullable = true)
    private String operationId;

    @Temporal(TemporalType.DATE)
    @Column(name = "accountingDate")
    private Date accountingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "valueDate")
    private Date valueDate;

    @Embedded
    private TransactionType type;

    @Column(name = "amount", nullable = true)
    private BigDecimal amount;

    @Column(name = "currency", nullable = true)
    private String currency;

    @Column(name = "description")
    private String description;

}


