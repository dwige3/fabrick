package it.fabrick.bip.wwsbipbackend.repository;

import it.fabrick.bip.wwsbipbackend.model.entity.AccountTransactionEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CashAccountRepository extends JpaRepository<AccountTransactionEntity, Long> {
    @Query("select account " +
            "from AccountTransactionEntity account " +
            "where (account.accountId = :accountId) " +
            "and (account.accountingDate between :startDate and :endDate) ")
    List<AccountTransactionEntity> getTransactionsByReferenceDate(@Param("accountId") String accountId,
                                                                  @Param("startDate") Date startDate,
                                                                  @Param("endDate") Date endDate,
                                                                  Pageable pageable);
}
