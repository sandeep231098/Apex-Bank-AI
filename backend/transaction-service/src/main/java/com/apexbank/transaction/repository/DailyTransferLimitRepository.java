package com.apexbank.transaction.repository;

import com.apexbank.transaction.entity.DailyTransferLimit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface DailyTransferLimitRepository
        extends JpaRepository<DailyTransferLimit, UUID> {

    Optional<DailyTransferLimit> findByAccountIdAndTransferDate(
            UUID accountId,
            LocalDate transferDate
    );
}