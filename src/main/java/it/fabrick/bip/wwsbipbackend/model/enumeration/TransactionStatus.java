package it.fabrick.bip.wwsbipbackend.model.enumeration;

public enum TransactionStatus {
    GBS_TRANSACTION_TYPE("GBS_TRANSACTION_TYPE_0023");

    private final String description;
    TransactionStatus(String description) {
        this.description = description;
    }
}
