package it.fabrick.bip.wwsbipbackend.model.enumeration;

public enum BeneficiaryType {

    NATURAL_PERSON("NATURAL_PERSON"),

    LEGAL_PERSON("LEGAL_PERSON");

    private final String description;
    BeneficiaryType(String description) {
        this.description = description;
    }
}
