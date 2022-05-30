package it.fabrick.bip.wwsbipbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import it.fabrick.bip.wwsbipbackend.model.entity.Fees;
import it.fabrick.bip.wwsbipbackend.model.enumeration.Direction;
import it.fabrick.bip.wwsbipbackend.model.enumeration.FeeType;
import it.fabrick.bip.wwsbipbackend.model.enumeration.MoneyStatus;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MoneyTransferResponse implements Serializable {

    private String moneyTransferId;
    private MoneyStatus status;
    private Direction direction;
    private CreditorDto Creditor;
    private DebtorDto Debtor;
    private String cro;
    private String uri;
    private String trn;
    private String description;
    private String createdDatetime;
    private String accountedDatetime;
    private String debtorValueDate;
    private String creditorValueDate;
    private AmountDto amt;
    private Boolean isUrgent;
    private Boolean isInstant;
    private FeeType feeType;
    private String feeAccountId;
    private List<FeesDto> fees;
    private Boolean hasTaxRelief;
}
