package it.fabrick.bip.wwsbipbackend.service;

import it.fabrick.bip.wwsbipbackend.converter.ConversionServiceHelper;
import it.fabrick.bip.wwsbipbackend.exceptions.InvalidReferenceDateException;
import it.fabrick.bip.wwsbipbackend.exceptions.MoneyTransferAlreadyExistsException;
import it.fabrick.bip.wwsbipbackend.exceptions.ResourceNotFoundException;
import it.fabrick.bip.wwsbipbackend.mappers.MoneyTransferMapper;
import it.fabrick.bip.wwsbipbackend.model.dto.AccountBalanceResponse;
import it.fabrick.bip.wwsbipbackend.model.dto.AccountTransactionDto;
import it.fabrick.bip.wwsbipbackend.model.dto.AccountTransactionResponse;
import it.fabrick.bip.wwsbipbackend.model.dto.MoneyTransferRequest;
import it.fabrick.bip.wwsbipbackend.model.dto.MoneyTransferResponse;
import it.fabrick.bip.wwsbipbackend.model.entity.AccountBalanceEntity;
import it.fabrick.bip.wwsbipbackend.model.entity.AccountTransactionEntity;
import it.fabrick.bip.wwsbipbackend.model.entity.MoneyTransferEntity;
import it.fabrick.bip.wwsbipbackend.repository.AccountBalanceRepository;
import it.fabrick.bip.wwsbipbackend.repository.CashAccountRepository;
import it.fabrick.bip.wwsbipbackend.repository.MoneyTransferRepository;
import it.fabrick.bip.wwsbipbackend.utils.DateUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class CashAccountServiceImpl implements CashAccountService {

    public static final String ACCOUNT_NOT_FOUND = "account not found";

    public static final String ACCOUNT_ID_ALREADY_PRESENT = "accountId already present[%s]";

    public static final String INVALID_REFERENCE_DATE = "Invalid referenceDate";
    @Autowired
    private CashAccountRepository cashAccountRepository;

    @Autowired
    private MoneyTransferRepository moneyTransferRepository;

    @Autowired
    private AccountBalanceRepository accountBalanceRepository;

    @Autowired
    private MoneyTransferMapper moneyTransferMapper;

    @Override
    public AccountTransactionResponse getAccountTransactions(String accountId, String fromAccountingDate, String toAccountingDate, Pageable pageable) throws ResourceNotFoundException {

        AccountTransactionResponse response = new AccountTransactionResponse();

        Date startDate = checkReferenceDate(fromAccountingDate);
        Date endDate = checkReferenceDate(toAccountingDate);
        List<AccountTransactionEntity> transactions = cashAccountRepository.getTransactionsByReferenceDate(accountId, startDate, endDate, pageable);
        if (!CollectionUtils.isEmpty(transactions)) {
            List<AccountTransactionDto> transactionsDto = ConversionServiceHelper.convert(transactions, AccountTransactionDto.class);
            response.setList(transactionsDto);
        } else {
            throw new ResourceNotFoundException(ACCOUNT_NOT_FOUND);
        }
        return response;
    }

    /**
     * @param accountId
     * @param request
     * @return
     */
//non implementato bene mi serviva piu informazioni
    @Transactional
    @Override
    public MoneyTransferResponse createMoneyTransfer(String accountId, MoneyTransferRequest request) throws MoneyTransferAlreadyExistsException {

        // check if account exist with this accountId

        MoneyTransferEntity moneyTransfer = MoneyTransferMapper.INSTANCE.toMoneyTransfer(request);
        moneyTransfer.setAccountId(accountId);
        return ConversionServiceHelper.convert(moneyTransferRepository.saveAndFlush(moneyTransfer), MoneyTransferResponse.class);
//        return MoneyTransferMapper.INSTANCE.toMoneyTransferResponse(moneyTransferRepository.saveAndFlush(moneyTransfer));
    }

    /**
     * @param accountId
     * @return
     */
    @Override
    public AccountBalanceResponse getBalance(String accountId) throws ResourceNotFoundException {

        Optional<AccountBalanceEntity> accountBalanceEntity = Optional.ofNullable(accountBalanceRepository.findByAccountId(accountId).orElseThrow(() -> new ResourceNotFoundException(String.format("Account Balance con accoundId '%s' non e' presente", accountId))));
        if (!accountBalanceEntity.isPresent()) {
            throw new NoSuchElementException();
        }
        return ConversionServiceHelper.convert(accountBalanceEntity.get(), AccountBalanceResponse.class);
    }

    private Date checkReferenceDate(String accountDate) {
        if (accountDate == null) {
            log.error("Missing referenceDate to");
        }
        Date referenceDate = DateUtility.dataFormat(accountDate);
        assert referenceDate != null;
        if (referenceDate.after(new Date())) {
            log.error("Invalid referenceDate, can't be in the future");
            throw new InvalidReferenceDateException(INVALID_REFERENCE_DATE);
        }
        return referenceDate;
    }
}
