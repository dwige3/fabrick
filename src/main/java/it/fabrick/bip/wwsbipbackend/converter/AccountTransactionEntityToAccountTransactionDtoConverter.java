package it.fabrick.bip.wwsbipbackend.converter;

import it.fabrick.bip.wwsbipbackend.model.dto.AccountTransactionDto;
import it.fabrick.bip.wwsbipbackend.model.entity.AccountTransactionEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountTransactionEntityToAccountTransactionDtoConverter implements Converter<AccountTransactionEntity, AccountTransactionDto> {

    @Override
    public AccountTransactionDto convert(AccountTransactionEntity source) {

        AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
        TransactionTypeToTransactionTypeDtoConverter converter = new TransactionTypeToTransactionTypeDtoConverter();

        accountTransactionDto.setTransactionId(source.getTransactionId());
        accountTransactionDto.setOperationId(source.getOperationId());
        accountTransactionDto.setAccountingDate(source.getAccountingDate());
        accountTransactionDto.setValueDate(source.getValueDate());
        accountTransactionDto.setType(converter.convert(source.getType()));
        accountTransactionDto.setAmount(source.getAmount());
        accountTransactionDto.setCurrency(source.getCurrency());
        accountTransactionDto.setDescription(source.getDescription());

        return accountTransactionDto;
    }
}
