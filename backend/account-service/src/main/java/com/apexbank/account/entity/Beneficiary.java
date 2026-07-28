package com.apexbank.account.entity;

import com.apexbank.common.entity.BaseEntity;
import com.apexbank.common.enums.BeneficiaryStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.UUID;

@Entity
@Table(name = "beneficiaries")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary extends BaseEntity {

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "beneficiary_name", nullable = false, length = 150)
    private String beneficiaryName;

    @Column(name = "beneficiary_account_number", nullable = false, length = 30)
    private String beneficiaryAccountNumber;

    @Column(name = "beneficiary_ifsc", nullable = false, length = 20)
    private String beneficiaryIfsc;

    @Column(length = 100)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BeneficiaryStatus status;

    @Column(nullable = false)
    @Builder.Default
    private Boolean verified = false;
}