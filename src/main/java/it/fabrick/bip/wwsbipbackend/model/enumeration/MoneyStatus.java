package it.fabrick.bip.wwsbipbackend.model.enumeration;

public enum MoneyStatus {

    EXECUTED("EXECUTED"),

    BOOKED("BOOKED"),

    WORK_IN_PROGRESS("WORK_IN_PROGRESS"),

    CANCELLED("CANCELLED"),

    REJECTED("REJECTED");
    private final String description;
    MoneyStatus(String description) {
        this.description = description;
    }
}
