package it.fabrick.bip.wwsbipbackend.model.enumeration;

public enum Direction {

    INCOMING("INCOMING"),

    OUTGOING("OUTGOING");

    private final String description;

    Direction(String description) {
        this.description = description;
    }
}
