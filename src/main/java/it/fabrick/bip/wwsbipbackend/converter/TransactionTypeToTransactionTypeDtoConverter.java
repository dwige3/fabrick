package it.fabrick.bip.wwsbipbackend.converter;

import it.fabrick.bip.wwsbipbackend.model.dto.TransactionTypeDto;
import it.fabrick.bip.wwsbipbackend.model.entity.TransactionType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransactionTypeToTransactionTypeDtoConverter implements Converter<TransactionType, TransactionTypeDto> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public TransactionTypeDto convert(TransactionType source) {

        TransactionTypeDto transactionTypeDto = new TransactionTypeDto();
        transactionTypeDto.setEnumeration(source.getEnumeration());
        transactionTypeDto.setValue(source.getValue());
        return transactionTypeDto;
    }
}
