package it.fabrick.bip.wwsbipbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class MoneyTransferAlreadyExistsException extends RuntimeException {
    private String message;

    public MoneyTransferAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    public MoneyTransferAlreadyExistsException() {
    }
}
