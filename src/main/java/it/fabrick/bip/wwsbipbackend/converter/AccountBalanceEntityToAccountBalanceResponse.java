package it.fabrick.bip.wwsbipbackend.converter;

import it.fabrick.bip.wwsbipbackend.model.dto.AccountBalanceResponse;
import it.fabrick.bip.wwsbipbackend.model.entity.AccountBalanceEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountBalanceEntityToAccountBalanceResponse implements Converter<AccountBalanceEntity, AccountBalanceResponse> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public AccountBalanceResponse convert(AccountBalanceEntity source) {

        AccountBalanceResponse accountBalanceResponse = new AccountBalanceResponse();

        accountBalanceResponse.setBalance(source.getBalance());
        accountBalanceResponse.setAvailableBalance(source.getAvailableBalance());
        accountBalanceResponse.setCurrency(source.getCurrency());
        accountBalanceResponse.setDate(source.getDate());

        return accountBalanceResponse;
    }

}
