package it.fabrick.bip.wwsbipbackend.model.dto;

import it.fabrick.bip.wwsbipbackend.model.enumeration.BeneficiaryType;
import it.fabrick.bip.wwsbipbackend.model.enumeration.TaxReliefId;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class TaxRelief implements Serializable {

    private TaxReliefId taxReliefId;

    @NotNull
    private Boolean isCondoUpgrade;

    @NotNull
    private String creditorFiscalCode;

    @NotNull
    private BeneficiaryType beneficiaryType;

    private NaturalPersonBeneficiary naturalPersonBeneficiary;

    private LegalPersonBeneficiary legalPersonBeneficiary;

}
