package it.fabrick.bip.wwsbipbackend.model.enumeration;

public enum FeeType {

    SHA("SHA"),

    OUR("OUR"),

    BEN("BEN");

    private final String description;
    FeeType(String description) {
        this.description = description;
    }
}
