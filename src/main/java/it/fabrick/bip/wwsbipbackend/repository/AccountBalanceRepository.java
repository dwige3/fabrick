package it.fabrick.bip.wwsbipbackend.repository;

import it.fabrick.bip.wwsbipbackend.model.entity.AccountBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountBalanceRepository extends JpaRepository<AccountBalanceEntity, Long> {
    Optional<AccountBalanceEntity> findByAccountId(String accountId);
}