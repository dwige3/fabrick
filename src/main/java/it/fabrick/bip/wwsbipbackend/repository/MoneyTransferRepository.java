package it.fabrick.bip.wwsbipbackend.repository;

import it.fabrick.bip.wwsbipbackend.model.entity.MoneyTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoneyTransferRepository extends JpaRepository<MoneyTransferEntity, Long> {
    Optional<MoneyTransferEntity> findByAccountId(String accountId);
}