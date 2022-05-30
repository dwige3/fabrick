package it.fabrick.bip.wwsbipbackend.model.entity;

import it.fabrick.bip.wwsbipbackend.model.enumeration.Direction;
import it.fabrick.bip.wwsbipbackend.model.enumeration.FeeType;
import it.fabrick.bip.wwsbipbackend.model.enumeration.MoneyStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "moneyTransfer")
public class MoneyTransferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "accountId", nullable = false)
    private String accountId;

    @Column(name = "money_Transfer_Id")
    private String moneyTransferId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private MoneyStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "direction")
    private Direction direction;

    @Embedded
    private Creditor creditor;

    @Embedded
    private Debtor debtor;

    @Column(name = "cro")
    private String cro;

    @Column(name = "trn")
    private String trn;

    @Column(name = "uri")
    private String uri;

    @Column(name = "description")
    private String description;

    @Column(name = "createdDatetime")
    private LocalDateTime createdDatetime;

    @Column(name = "accountedDatetime")
    private LocalDateTime accountedDatetime;

    @Temporal(TemporalType.DATE)
    @Column(name = "debtorValueDate")
    private Date debtorValueDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "creditorValueDate")
    private Date creditorValueDate;

    @OneToOne
    @JoinColumn(name = "amount_id")
    private AmountEntity amt;

    @Column(name = "isUrgent")
    private Boolean isUrgent;

    @Column(name = "isInstant")
    private Boolean isInstant;

    @Enumerated(EnumType.STRING)
    @Column(name = "feeType")
    private FeeType feeType;

    @Column(name = "feeAccountID")
    private String feeAccountId;

    @ElementCollection
    private List<Fees> fees;

    @Column(name = "hasTaxRelief")
    private Boolean hasTaxRelief;

}
