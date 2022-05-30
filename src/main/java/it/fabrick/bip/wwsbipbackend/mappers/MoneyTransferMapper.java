package it.fabrick.bip.wwsbipbackend.mappers;

import it.fabrick.bip.wwsbipbackend.model.dto.MoneyTransferRequest;
import it.fabrick.bip.wwsbipbackend.model.dto.MoneyTransferResponse;
import it.fabrick.bip.wwsbipbackend.model.entity.MoneyTransferEntity;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        componentModel = "spring")
public interface MoneyTransferMapper {

    MoneyTransferMapper INSTANCE = Mappers.getMapper(MoneyTransferMapper.class);

    @Mappings({
            @Mapping(source = "creditor.address.address", target = "creditor.address"),
            @Mapping(source = "creditor.account.accountCode", target = "creditor.accountCode"),
            @Mapping(source = "creditor.account.bicCode", target = "creditor.bicCode"),
            @Mapping(source = "creditor.address.city", target = "creditor.city"),
            @Mapping(source = "creditor.address.countryCode", target = "creditor.countryCode"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "accountId", ignore = true),
            @Mapping(target = "moneyTransferId", ignore = true),
            @Mapping(target = "status", ignore = true),
            @Mapping(target = "direction", ignore = true),
            @Mapping(target = "debtor", ignore = true),
            @Mapping(target = "cro", ignore = true),
            @Mapping(target = "trn", ignore = true),
            @Mapping(target = "createdDatetime", ignore = true),
            @Mapping(target = "accountedDatetime", ignore = true),
            @Mapping(target = "debtorValueDate", ignore = true),
            @Mapping(target = "creditorValueDate", ignore = true),
            @Mapping(target = "amt", ignore = true),
            @Mapping(target = "fees", ignore = true),
            @Mapping(target = "hasTaxRelief", ignore = true)
    })
    MoneyTransferEntity toMoneyTransfer(MoneyTransferRequest request);

    @Mappings({
            @Mapping(target = "creditor.address.address", source = "creditor.address"),
            @Mapping(target = "creditor.account.accountCode", source = "creditor.accountCode"),
            @Mapping(target = "creditor.account.bicCode", source = "creditor.bicCode"),
            @Mapping(target = "creditor.address.city", source = "creditor.city"),
            @Mapping(target = "creditor.address.countryCode", source = "creditor.countryCode"),
            @Mapping(target = "debtor.account.accountCode", source = "debtor.accountCode"),
            @Mapping(target = "debtor.account.bicCode", source = "debtor.bicCode")
    })
    MoneyTransferResponse toMoneyTransferResponse(MoneyTransferEntity moneyTransfer);
}
