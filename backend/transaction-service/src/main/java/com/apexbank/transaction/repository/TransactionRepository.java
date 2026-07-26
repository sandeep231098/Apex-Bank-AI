package com.apexbank.transaction.repository;

import com.apexbank.common.enums.TransactionType;
import com.apexbank.transaction.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends
        JpaRepository<Transaction, UUID>,
        JpaSpecificationExecutor<Transaction> {

    boolean existsByTransactionReference(String transactionReference);

    List<Transaction> findByFromAccountId(UUID accountId);

    Page<Transaction> findByFromAccountIdOrderByCreatedAtDesc(
            UUID accountId,
            Pageable pageable
    );
    @Query("""
       SELECT COALESCE(SUM(t.amount), 0)
       FROM Transaction t
       WHERE t.transactionType = :transactionType
       """)
    BigDecimal getTotalAmountByTransactionType(TransactionType transactionType);

    @Query("""
       SELECT COUNT(t)
       FROM Transaction t
       """)
    Long getTotalTransactions();
}