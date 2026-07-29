package com.apexbank.account.repository;

import com.apexbank.account.entity.Beneficiary;
import com.apexbank.common.enums.BeneficiaryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeneficiaryRepository
        extends JpaRepository<Beneficiary, UUID> {

    List<Beneficiary> findByCustomerId(UUID customerId);

    List<Beneficiary> findByCustomerIdAndStatus(
            UUID customerId,
            BeneficiaryStatus status
    );

    Optional<Beneficiary> findByIdAndCustomerId(
            UUID id,
            UUID customerId
    );

    boolean existsByCustomerIdAndBeneficiaryAccountNumber(
            UUID customerId,
            String beneficiaryAccountNumber
    );

    Optional<Beneficiary> findByCustomerIdAndBeneficiaryAccountNumber(
            UUID customerId,
            String beneficiaryAccountNumber);
    Optional<Beneficiary> findByCustomerIdAndBeneficiaryAccountNumberAndStatus(
            UUID customerId,
            String beneficiaryAccountNumber,
            BeneficiaryStatus status
    );

}