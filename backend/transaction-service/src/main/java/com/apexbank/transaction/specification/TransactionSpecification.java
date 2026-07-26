package com.apexbank.transaction.specification;

import com.apexbank.common.enums.TransactionStatus;
import com.apexbank.common.enums.TransactionType;
import com.apexbank.transaction.entity.Transaction;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionSpecification {

    private TransactionSpecification() {
    }

    public static Specification<Transaction> search(
            UUID accountId,
            TransactionType transactionType,
            TransactionStatus transactionStatus,
            LocalDateTime fromDate,
            LocalDateTime toDate,
            BigDecimal minAmount,
            BigDecimal maxAmount) {

        return (root, query, cb) -> {

            var predicate = cb.conjunction();

            if (accountId != null) {
                predicate.getExpressions().add(
                        cb.equal(root.get("fromAccountId"), accountId)
                );
            }

            if (transactionType != null) {
                predicate.getExpressions().add(
                        cb.equal(root.get("transactionType"), transactionType)
                );
            }

            if (transactionStatus != null) {
                predicate.getExpressions().add(
                        cb.equal(root.get("transactionStatus"), transactionStatus)
                );
            }

            if (fromDate != null) {
                predicate.getExpressions().add(
                        cb.greaterThanOrEqualTo(root.get("createdAt"), fromDate)
                );
            }

            if (toDate != null) {
                predicate.getExpressions().add(
                        cb.lessThanOrEqualTo(root.get("createdAt"), toDate)
                );
            }

            if (minAmount != null) {
                predicate.getExpressions().add(
                        cb.greaterThanOrEqualTo(root.get("amount"), minAmount)
                );
            }

            if (maxAmount != null) {
                predicate.getExpressions().add(
                        cb.lessThanOrEqualTo(root.get("amount"), maxAmount)
                );
            }

            return predicate;
        };
    }
}