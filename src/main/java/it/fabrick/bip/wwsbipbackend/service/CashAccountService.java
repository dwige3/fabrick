package it.fabrick.bip.wwsbipbackend.service;

import it.fabrick.bip.wwsbipbackend.exceptions.MoneyTransferAlreadyExistsException;
import it.fabrick.bip.wwsbipbackend.exceptions.ResourceNotFoundException;
import it.fabrick.bip.wwsbipbackend.model.dto.AccountBalanceResponse;
import it.fabrick.bip.wwsbipbackend.model.dto.AccountTransactionResponse;
import it.fabrick.bip.wwsbipbackend.model.dto.MoneyTransferRequest;
import it.fabrick.bip.wwsbipbackend.model.dto.MoneyTransferResponse;
import org.springframework.data.domain.Pageable;

public interface CashAccountService {
    AccountTransactionResponse getAccountTransactions(String accountId, String fromAccountingDate, String toAccountingDate, Pageable pageable) throws ResourceNotFoundException;

    MoneyTransferResponse createMoneyTransfer(String accountId, MoneyTransferRequest request) throws MoneyTransferAlreadyExistsException;

    AccountBalanceResponse getBalance(String accountId) throws ResourceNotFoundException;
}
