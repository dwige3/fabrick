package it.fabrick.bip.wwsbipbackend.model.enumeration;

public enum TaxReliefId {

    R119("Interventi superbonus."),

    L027("Interventi superbonus."),

    DL50("Interventi antisismici"),

    L090("Interventi antisismici"),

    L296("Risparmio energetico"),

    L449("Ristrutturazione");

    private final String description;
    TaxReliefId(String description) {
        this.description = description;
    }
}
