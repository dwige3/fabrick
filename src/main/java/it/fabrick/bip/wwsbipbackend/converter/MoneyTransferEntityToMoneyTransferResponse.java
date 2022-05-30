package it.fabrick.bip.wwsbipbackend.converter;

import it.fabrick.bip.wwsbipbackend.model.dto.MoneyTransferResponse;
import it.fabrick.bip.wwsbipbackend.model.entity.MoneyTransferEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MoneyTransferEntityToMoneyTransferResponse implements Converter<MoneyTransferEntity, MoneyTransferResponse> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public MoneyTransferResponse convert(MoneyTransferEntity source) {

        MoneyTransferResponse moneyTransferResponse = new MoneyTransferResponse();
        return moneyTransferResponse;
    }
}
